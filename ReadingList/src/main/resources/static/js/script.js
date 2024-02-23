
console.log('script.js loaded');

window.addEventListener('load', function(evt) {
	console.log('page loaded');
	loadAllBooks();
});

function loadAllBooks() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/books');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if ( xhr.status === 200 ) {
				let bookList = JSON.parse(xhr.responseText);
				displayBookList(bookList);
			}
			else {
				// TODO
			}
		}
	};
	xhr.send();
}

function displayBookList(books) {
	if (books && Array.isArray(books) && books.length > 0) {
		let tbody = document.getElementById('bookTable');
		tbody.textContent = '';
		for (let book of books) {
			let tr = document.createElement('tr');
			tbody.appendChild(tr);
			let td = document.createElement('td');
			td.textContent = book.id;
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = book.title;
			tr.appendChild(td);
			tr.bookId = book.id; // stash book id in the tr in the DOM
			
			tr.addEventListener('click', function(evt){
//				console.log(evt.target);
//				let bookId = evt.target.parentElement.firstElementChild.textContent;
				let bookId = evt.target.parentElement.bookId;
				console.log(bookId);
				showBookDetails(bookId);
			});
			
		}
	}
}

function showBookDetails(bookId) {
	//TODO
	//TODO display book in book details div, hide table div
}




