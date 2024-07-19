package com.system;


import java.util.ArrayList;
import java.util.List;

public class Library {
	
	List<Book> books = new ArrayList<Book>();
	
	// Method to add a book
		public void addBook(Book book) {
			// Check if a book with the same ISBN already exists
			boolean found = books.stream().anyMatch(b -> b.getISBN().equals(book.getISBN()));
			if (!found) {
				books.add(book);
			} else {
				System.out.println("Book with ISBN " + book.getISBN() + " already exists in the library.");
			}
		}

		// Method to remove a book by ISBN
		public void removeBook(String ISBN) {
			books.removeIf(book -> book.getISBN().equals(ISBN));
		}

		// Method to find books by title (case-insensitive search)
		public List<Book> findBookByTitle(String title) {
			List<Book> result = new ArrayList<>();
			for (Book book : books) {
				if (book.getTitle().equalsIgnoreCase(title)) {
					result.add(book);
				}
			}
			return result;
		}

		// Method to find books by author (case-insensitive search)
		public List<Book> findBookByAuthor(String author) {
			List<Book> result = new ArrayList<>();
			for (Book book : books) {
				if (book.getAuthor().equalsIgnoreCase(author)) {
					result.add(book);
				}
			}
			return result;
		}

		// Method to list all books in the library
		public List<Book> listAllBooks() {
			return books;
		}

		// Method to list available books
		public List<Book> listAvailableBooks() {
			List<Book> availableBooks = new ArrayList<>();
			for (Book book : books) {
				if (book.isAvailable()) {
					availableBooks.add(book);
				}
			}
			return availableBooks;
		}
}
