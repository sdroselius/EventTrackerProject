
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
			if (xhr.status === 200) {
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
			//			td.textContent = book.id;
			let img = document.createElement('img');
			img.src = book.coverImageUrl;
			img.classList.add('coverImageThumbnail');
			td.appendChild(img);
			tr.appendChild(td);
			td = document.createElement('td');
			td.textContent = book.title;
			tr.appendChild(td);
			tr.bookId = book.id; // stash book id in the tr in the DOM

			tr.addEventListener('click', function(evt) {
				//				console.log(evt.target);
				//				let bookId = evt.target.parentElement.firstElementChild.textContent;
				let bookId = evt.target.parentElement.bookId;
				console.log(bookId);
				getBook(bookId);
			});

		}
	}
}

function getBook(bookId) {
	if (!bookId || isNaN(bookId)) {
		return;
	}
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/books/' + bookId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let book = JSON.parse(xhr.responseText);
				displayBook(book);
			}
			else {
				// TODO
			}
		}
	};
	xhr.send();
}

function displayBook(book) {
	let bookDiv = document.getElementById('bookDetailDiv');
	bookDiv.textContent = '';
	let title = document.createElement('h2');
	title.textContent = book.title;
	bookDiv.appendChild(title);
	let author = document.createElement('h5');
	author.textContent = "By " + book.author.fullName;
	bookDiv.appendChild(author);
	let cover = document.createElement('img');
	cover.src = book.coverImageUrl;
	cover.alt = 'Cover art for ' + book.title;
	cover.classList.add('coverImage');
	bookDiv.appendChild(cover);
	let desc = document.createElement('p');
	desc.textContent = book.description;
	bookDiv.appendChild(desc);
	let hr = document.createElement('hr');
	hr.classList.add('clear');
	bookDiv.appendChild(hr)
	let p = document.createElement('p');
	p.textContent = book.pages + ' pages';
	bookDiv.appendChild(p);
	if (book.lastFinished) {
		p = document.createElement('p');
		p.textContent = "Last read: " + book.lastFinished;
		bookDiv.appendChild(p);
	}
	let goBackButton = document.createElement('button');
	goBackButton.textContent = 'Back to Reading List';
	goBackButton.classList.add('btn');
	goBackButton.classList.add('btn-outline-primary');
	goBackButton.addEventListener('click', function(evt){
		evt.preventDefault();
		showTable();
	});
	bookDiv.appendChild(goBackButton)
	showDetails();
}

function showTable() {
	let list = document.getElementById('bookListDiv');
	let details = document.getElementById('bookDetailDiv');
	let add = document.getElementById('addBookDiv');
	let edit = document.getElementById('editBookDiv');
	list.style.display = 'block';
	details.style.display = 'none';
	add.style.display = 'none';
	edit.style.display = 'none';
}

function showDetails() {
	let list = document.getElementById('bookListDiv');
	let details = document.getElementById('bookDetailDiv');
	let add = document.getElementById('addBookDiv');
	let edit = document.getElementById('editBookDiv');
	list.style.display = 'none';
	details.style.display = 'block';
	add.style.display = 'none';
	edit.style.display = 'none';
}


