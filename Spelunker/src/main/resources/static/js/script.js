console.log('script.js loaded');

window.addEventListener('load', function(){
	console.log('DOM loaded');
	init();
} );

function init() {
	loadAllCaves();
	//TODO - event listeners, etc
}

function loadAllCaves() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/caves');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE ) {
			if (xhr.status === 200) {
				let caves = JSON.parse(xhr.responseText);
				console.log(caves);
				displayCavesList(caves);
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
}