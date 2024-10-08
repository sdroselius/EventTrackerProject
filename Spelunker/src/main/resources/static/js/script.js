console.log('script.js loaded');

window.addEventListener('load', function() {
	console.log('DOM loaded');
	init();
});

function init() {
	loadAllCaves();
	loadFormationTypes();
	hideAddCave();
	
	caveForm.lookup.addEventListener('click', function(e){
		e.preventDefault();
		let caveId = caveForm.caveId.value;
		if (!isNaN(caveId) && caveId > 0) {
		  getCave(caveId);
		}
	});
	
	document.getElementById("showAddCaveButton").addEventListener('click', function(e){
		showAddCave();
	});
	
	document.getElementById("cancelAddCaveButton").addEventListener('click', function(e){
		hideAddCave();
	});
	
	
}

function loadAllCaves() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/caves');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let caves = JSON.parse(xhr.responseText);
				displayCavesList(caves);
			}
			else {
				//FIXME
			}
		}
	};
	xhr.send();
}

function loadFormationTypes() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/formationTypes');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let types = JSON.parse(xhr.responseText);
				displayFormationTypes(types);
			}
			else {
				//FIXME
			}
		}
	};
	xhr.send();
}

function displayCavesList(caveList) {
	let tbody = document.getElementById('caveListBody');
	if (Array.isArray(caveList) && caveList.length > 0) {
		for (let cave of caveList) {
			let tr = document.createElement('tr');
			tbody.appendChild(tr);
			
			tr.caveId = cave.id;
			tr.addEventListener('click', function(evt){
				let row = evt.target.parentElement;
				console.log(row.caveId);
				getCave(row.caveId);
			});
			
		
			let td = document.createElement('td');
			td.textContent = cave.name;
			tr.appendChild(td);
			td = document.createElement('td');
			let lastUpdate = new Date(cave.lastUpdate);
			td.textContent = lastUpdate.toDateString(); // or lastUpdate.toLocaleDateString()
			tr.appendChild(td);
			td = document.createElement('td');
			let length = new Number(cave.exploredLengthKm);
			td.textContent = length.toFixed(2); // 2 decimal digits
			tr.appendChild(td);

		}
	}
}

function displayFormationTypes(types) {
	let select = addNewCaveForm.formationType;
	for (let type of types) {
		let option = document.createElement('option');
		option.value = type.id;
		option.textContent = type.name;
		select.appendChild(option);
	}
}

function getCave(caveId) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/caves/' + caveId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let cave = JSON.parse(xhr.responseText);
//				console.log(cave);
				displayCave(cave);
			}
			else {
				//FIXME
			}
		}
	};
	xhr.send();
}

function displayCave(cave) {
	let detailsDiv = document.getElementById('caveDetailsDiv');
	detailsDiv.textContent = '';
	let h2 = document.createElement('h2');
	h2.textContent = cave.name;
	detailsDiv.appendChild(h2);
	let img = document.createElement('img');
	img.src = cave.imageUrl;
	img.alt = cave.name + ' image';
	img.classList.add('caveDetailImage');
	detailsDiv.appendChild(img);
	let bq = document.createElement('blockquote');
	bq.textContent = cave.description;
	detailsDiv.appendChild(bq);
	let ul = document.createElement('ul');
	detailsDiv.appendChild(ul);
	let li = document.createElement('li');
	li.textContent = 'Explored length in kilometers: ' + cave.exploredLengthKm;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Open to public? ' + cave.openToPublic;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = 'Entrance authority: ' + cave.entranceAuthority;
	ul.appendChild(li);
}


function showAddCave() {
	let detailsDiv = document.getElementById('caveDetailsDiv');
	let caveListDiv = document.getElementById('caveListDiv');
	let addCaveDiv = document.getElementById('addNewCaveDiv');
	detailsDiv.style.display = 'none';
	caveListDiv.style.display = 'none';
	addCaveDiv.style.display = 'block';
}

function hideAddCave() {
	let detailsDiv = document.getElementById('caveDetailsDiv');
	let caveListDiv = document.getElementById('caveListDiv');
	let addCaveDiv = document.getElementById('addNewCaveDiv');
	addCaveDiv.style.display = 'none';
	detailsDiv.style.display = 'block';
	caveListDiv.style.display = 'block';
	addNewCaveForm.reset();
}

