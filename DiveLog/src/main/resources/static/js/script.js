console.log('script.js loaded');

window.addEventListener('load', function(e) {
	console.log('DOM created');
	init();
});

function init() {
	loadDestinations();
	
	document.newDestinationForm.addDestinationButton.addEventListener('click', function(e){
		e.preventDefault();
		let f = document.newDestinationForm;
		let dest = {
			name: f.name.value,
			imageUrl: f.imageUrl.value,
			description: f.description.value,
			country: {
				countryCode: f.countryCode.value,
			}
		}
		addDestination(dest);
	});
}

function loadDestinations() {
	let url = 'api/destinations';
	let xhr = new XMLHttpRequest();
	xhr.open('GET', url);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let destinations = JSON.parse(xhr.responseText);
				displayDestinations(destinations);
				//console.log(destinations)
				showDestinationTable();
			}
			else {
				// how did I get here?
			}
		}
	};
	xhr.send();
}

function displayDestinations(destinationList) {
	let tbody = document.getElementById("destinationTableBody");
	tbody.textContent = '';
	if (!Array.isArray(destinationList)) {
		return;
	}
	for (let dest of destinationList) {
		let tr = document.createElement('tr');
		tbody.appendChild(tr);
		let td = document.createElement('td');
		let img = document.createElement('img')
		img.src = dest.imageUrl ? dest.imageUrl : 'images/defaultDiver.webp';

		img.alt = 'Image of ' + dest.name;
		img.classList.add('destThumbnail');

		td.appendChild(img);
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = dest.name;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = dest.country.name;
		tr.appendChild(td);

		tr.destinationId = dest.id;
		tr.addEventListener('click', function(e) {
			getDestinationDetails(e.target.parentElement.destinationId);
		});
	}
}

function getDestinationDetails(destId) {
	let url = `api/destinations/${destId}`;
	let xhr = new XMLHttpRequest();
	xhr.open('GET', url);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let destination = JSON.parse(xhr.responseText);
				displayDestination(destination);
			}
			else {
				// how did I get here? 404
			}
		}
	};
	xhr.send();
}

function displayDestination(destination) {
	console.log(destination);
	showDestinationDetails();
	let destDiv = document.getElementById('destinationDetailsDiv');
	destDiv.textContent = '';
	let h1 = document.createElement('h1');
	h1.textContent = destination.name;
	destDiv.appendChild(h1);
	
	let rowDiv = document.createElement('div');
	rowDiv.classList.add('row');
	destDiv.appendChild(rowDiv);

	let img = document.createElement('img');
	console.log(destination.imageUrl);
	img.src = destination.imageUrl ? destination.imageUrl : 'images/defaultDiver.webp';
	console.log(img.src);
	console.log(img);
	img.alt = destination.name + ' image';
	img.classList.add('col-6')
	img.classList.add('destImage')
	rowDiv.appendChild(img)
	
	let siteDetailsDiv = document.createElement('div');
	siteDetailsDiv.classList.add('col-6')
	siteDetailsDiv.id = 'siteDetailsDiv';
	rowDiv.appendChild(siteDetailsDiv)
	
	let sitesDiv = document.createElement('div');
	destDiv.appendChild(sitesDiv);
	sitesDiv.id = 'destinationSitesDiv';
	loadDestinationSites(destination.id);
	
	let bq = document.createElement('blockquote');
	bq.textContent = destination.description;
	bq.classList.add('destDescription');
	destDiv.appendChild(bq);

	let btn = document.createElement('button');
	btn.textContent = "Back to List";
	btn.classList.add('btn');
	btn.classList.add('btn-outline-primary');
	btn.addEventListener('click', showDestinationTable);
	destDiv.appendChild(btn)
}

function loadDestinationSites(destId) {
	let url = `api/destinations/${destId}/divesites`;
	let xhr = new XMLHttpRequest();
	xhr.open('GET', url);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let sites = JSON.parse(xhr.responseText);
				displayDestinationSites(sites);
			}
			else {
				// how did I get here? 404
			}
		}
	};
	xhr.send();

}

function displayDestinationSites(sites) {
	let destDiv = document.getElementById('destinationSitesDiv');
	let table = buildTableSkeleton('sitesTable');
	table.classList.add('table');
	let th = document.createElement('th');
	th.textContent = 'Dive Site Name';
	table.firstElementChild.firstElementChild.appendChild(th);
	th = document.createElement('th');
	th.textContent = 'Description';
	table.firstElementChild.firstElementChild.appendChild(th);
	let tbody = table.lastElementChild;
	for (let site of sites) {
		let tr = document.createElement('tr');
		tbody.appendChild(tr);
		let td = document.createElement('td');
		td.textContent = site.name;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = site.description;
		tr.appendChild(td);
		tr.addEventListener('click', function(e){
			displaySiteDetails(site);
		});
	}
	destDiv.appendChild(table);
}

function displaySiteDetails(site) {
	let siteDiv = document.getElementById('siteDetailsDiv');
	siteDiv.textContent = '';
//	siteDiv.textContent= JSON.stringify(site);
	let h4 = document.createElement('h4');
	h4.textContent = site.name;
	siteDiv.appendChild(h4);
	let desc = document.createElement('p');
	desc.textContent = site.description;
	siteDiv.appendChild(desc);
	siteDiv.appendChild(getGoogleMap(site.latitude,site.longitude));
}

function showDestinationTable() {
	let listDiv = document.getElementById('destinationListDiv');
	let detailsDiv = document.getElementById('destinationDetailsDiv');
	let newDestDiv = document.getElementById('newDestinationFormDiv');
	listDiv.style.display = 'block';
	detailsDiv.style.display = 'none';
	newDestDiv.style.display = 'none';
}

function showDestinationDetails() {
	let listDiv = document.getElementById('destinationListDiv');
	let detailsDiv = document.getElementById('destinationDetailsDiv');
	let newDestDiv = document.getElementById('newDestinationFormDiv');
	listDiv.style.display = 'none';
	detailsDiv.style.display = 'block';
	newDestDiv.style.display = 'none';
}

function showDestinationForm() {
	let listDiv = document.getElementById('destinationListDiv');
	let detailsDiv = document.getElementById('destinationDetailsDiv');
	let newDestDiv = document.getElementById('newDestinationFormDiv');
	listDiv.style.display = 'none';
	detailsDiv.style.display = 'none';
	newDestDiv.style.display = 'block';
}

function buildTableSkeleton(tableId) {
	let table = document.createElement('table');
	table.id = tableId ? tableId : 'table';
	let thead = document.createElement('thead');
	table.appendChild(thead);
	let tr = document.createElement('tr');
	thead.appendChild(tr);
	let tbody = document.createElement('tbody');
	table.appendChild(tbody);
	return table;
}

function getGoogleMap(lat, long) {
	let iframe = document.createElement('iframe');
	iframe.classList.add('diveSiteMap');
	iframe.src = `http://maps.google.com/maps?q=${lat},${long}&z=10&output=embed`
	return iframe;
}


function addDestination(dest) {
	let url = 'api/destinations';
	let xhr = new XMLHttpRequest();
	xhr.open('POST', url);
	
	xhr.onreadystatechange = function(){
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 201) {
				let createdDest = JSON.parse(xhr.responseText);
				loadDestinations();
			}
			else {
				displayError('Error creating destination');
			}
		}
	};
	
	xhr.setRequestHeader("Content-type", "application/json");
	let destJson = JSON.stringify(dest);
	xhr.send(destJson);	
}
