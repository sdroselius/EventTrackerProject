
console.log('script.js loaded');

window.addEventListener('load', function(evt) {
	console.log('page loaded');
	loadAllBooks();
	loadAuthors();
	hideAddAuthor();

	addBookForm.cancelAdd.addEventListener('click', function(evt) {
		evt.preventDefault();
		showTable();
	});

	addBookForm.showAddAuthorButton.addEventListener('click', function(evt) {
		evt.preventDefault();
		showAddAuthor();
	});

	addBookForm.saveNewBook.addEventListener('click', function(evt) {
		evt.preventDefault();
		let newBook = {
			id: addBookForm.id.value,
			title: addBookForm.title.value,
			description: addBookForm.description.value,
			pages: addBookForm.pages.value,
			lastFinished: addBookForm.lastFinished.value,
			coverImageUrl: addBookForm.coverImageUrl.value,
			author: {
				id: editBookForm.author.value,
			}
		};
		saveBook(newBook);
	});
	
	editBookForm.cancelEdit.addEventListener('click', function(evt) {
		evt.preventDefault();
		showDetails();
	});

	editBookForm.saveEditedBook.addEventListener('click', function(evt) {
		evt.preventDefault();
		let editedBook = {
			id: editBookForm.id.value,
			title: editBookForm.title.value,
			description: editBookForm.description.value,
			pages: editBookForm.pages.value,
			lastFinished: editBookForm.lastFinished.value,
			coverImageUrl: editBookForm.coverImageUrl.value,
			author: {
				id: editBookForm.author.value,
			}
		};
		updateBook(editedBook);
	});
	
	let goToAddButton = document.getElementById('goToAddButton');
	goToAddButton.addEventListener('click',function(e){
		e.preventDefault();
		showAddForm();
	});
	

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

function loadAuthors() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/authors');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let authors = JSON.parse(xhr.responseText);
				displayAuthors(authors);
			}
			else {
				// TODO
			}
		}
	};
	xhr.send();
}

function displayAuthors(authors) {
	let editList = editBookForm.author;
	let addList = addBookForm.author;
	editList.textContent = '';
	addList.textContent = '';
	authors.forEach((author,i) => {
		let optE = document.createElement('option');
		let optA = document.createElement('option');
		optE.value = optA.value = author.id;
		optE.textContent = optA.textContent = author.fullName;
		if (i == 0) { optA.selected = true; }
		editList.appendChild(optE);
		addList.appendChild(optA);
	});
	addList.value = 1;
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

			td = document.createElement('td');
			tr.appendChild(td)
			let delBtn = document.createElement('button');
			delBtn.textContent = 'Delete';
			delBtn.classList.add('btn');
			delBtn.classList.add('btn-outline-danger');
			delBtn.addEventListener('click', function(evt) {
				deleteBook(book.id);
			});

			td.appendChild(delBtn);
		}
	}
	showTable();
}

function deleteBook(bookId) {
	//FIXME
	console.log('Deleting book ' + bookId);
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
	goBackButton.id = 'backButtonId';
	goBackButton.addEventListener('click', function(evt) {
		evt.preventDefault();
		showTable();
	});
	bookDiv.appendChild(goBackButton);
	let goToEditButton = document.createElement('button');
	goToEditButton.textContent = 'Edit';
	goToEditButton.classList.add('btn');
	goToEditButton.classList.add('btn-outline-primary');
	goToEditButton.id = 'backButtonId';
	goToEditButton.addEventListener('click', function(evt) {
		evt.preventDefault();
		goToEditForm(book);
	});
	bookDiv.appendChild(goToEditButton);
	showDetails();
}

function goToEditForm(book) {
	editBookForm.id.value = book.id;
	editBookForm.title.value = book.title;
	editBookForm.description.value = book.description;
	editBookForm.pages.value = book.pages;
	editBookForm.coverImageUrl.value = book.coverImageUrl;
	editBookForm.author.value = book.author.id;
	showEditForm();
}
function updateBook(editedBook) {
	console.log("Updating book");
	console.log(editedBook);
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/books/' + editedBook.id);
	xhr.onreadystatechange = function(){
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let book = JSON.parse(xhr.responseText);
				getBook(editedBook.id);
			}
			else {
				// TODO
			}
		}
	};
	xhr.setRequestHeader('Content-type','application/json');
	xhr.send(JSON.stringify(editedBook));
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

function showAddForm() {
	let list = document.getElementById('bookListDiv');
	let details = document.getElementById('bookDetailDiv');
	let add = document.getElementById('addBookDiv');
	let edit = document.getElementById('editBookDiv');
	list.style.display = 'none';
	details.style.display = 'none';
	add.style.display = 'block';
	edit.style.display = 'none';
}

function showEditForm() {
	let list = document.getElementById('bookListDiv');
	let details = document.getElementById('bookDetailDiv');
	let add = document.getElementById('addBookDiv');
	let edit = document.getElementById('editBookDiv');
	list.style.display = 'none';
	details.style.display = 'none';
	add.style.display = 'none';
	edit.style.display = 'block';
}

function showAddAuthor() {
	let div = document.getElementById('addAuthorAddDiv');
	div.style.display = 'block';
}

function hideAddAuthor() {
	let div = document.getElementById('addAuthorAddDiv');
	div.style.display = 'none';
}


