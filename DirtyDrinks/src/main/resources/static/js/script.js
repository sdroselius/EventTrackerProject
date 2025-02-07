console.log('script.js loaded');

window.addEventListener('load', function(e){
	console.log('Document loaded.')
	init();
} );


let url = 'api/dirtyDrinks';

function init() {
	console.log('In init()');
	
	loadDrinkList();
	
	//TODO: event listeners for HTML form buttons, etc.
}

function loadDrinkList() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', url);
//	xhr.open('GET', 'api/dirtyDrinks');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				displayDrinkList(JSON.parse(xhr.responseText) );	
			}
		}
	};
	xhr.send();
	
}

function displayDrinkList(drinks) {
	//DOM to build table rows, append to tbody
	let tbody = document.getElementById('drinkListTbody');
	tbody.textContent = '';
	
	for (let drink of drinks) {
		let tr = document.createElement('tr'); // one per drink
		
		let img = document.createElement('img');
		img.src = drink.imageUrl;
		img.alt = 'Image of ' + drink.name;
//		img.classList.add('drink-thumbnail-img');
		img.classList.add('w-25');
//		img.classList.add('h-100');
		
		let td = document.createElement('td');
		td.appendChild(img);
		td.drinkId = drink.id;
		tr.appendChild(td);
		
		td = document.createElement('td');
		td.textContent = drink.name;
		tr.appendChild(td);
		
		tr.drinkId = drink.id;
		
		tr.addEventListener('click',function(e){
			drinkId = e.target.parentElement.drinkId;
//			console.log(drinkId);
			getDrink(drinkId);
		});
		tbody.appendChild(tr);
	}
}

function getDrink(drinkId) {
	let xhr = new XMLHttpRequest();
//	xhr.open('GET', `api/dirtyDrinks/${drinkId}`);
	xhr.open('GET', `${url}/${drinkId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				displayDrink(JSON.parse(xhr.responseText) );	
			}
			else {
				//TODO say "Drink not found" somewhere
			}
		}
	};
	xhr.send();
}

function displayDrink(drink){
	
	let drinkDiv = document.getElementById('drinkDetailsDiv');
	drinkDiv.textContent = '';
	
	let h3 = document.createElement('h3');
	h3.textContent = drink.name;
	drinkDiv.appendChild(h3);
	let img = document.createElement('img');
	img.src = drink.imageUrl;
	img.alt = 'Image of ' + drink.name;
	img.classList.add('drink-details-img');
	drinkDiv.appendChild(img);
	
	let backButton = document.createElement('button');
	backButton.textContent = 'Back to List';
	backButton.classList.add('btn','btn-primary');
	backButton.addEventListener('click', function(e){
		showList();
	});
	drinkDiv.appendChild(backButton);
	
	showDetails();
}

function showDetails() {
	let detailsDiv = document.getElementById('drinkDetailsDiv');
	let listDiv = document.getElementById('drinkListDiv');
	detailsDiv.style.display = 'block';
	listDiv.style.display = 'none';
}

function showList() {
	let detailsDiv = document.getElementById('drinkDetailsDiv');
	let listDiv = document.getElementById('drinkListDiv');
	detailsDiv.style.display = 'none';
	listDiv.style.display = 'block';
}
 
