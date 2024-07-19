package com.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    
	private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        // Add some sample books for testing
        library.addBook(new Book("Book1", "Author1", "111", "Fiction", 2000, "Department1"));
        library.addBook(new Book("Book2", "Author2", "222", "Non-fiction", 2010, "Department2"));
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("NewBook", "NewAuthor", "333", "Fantasy", 2020, "Department3");
        library.addBook(newBook);
        assertTrue(library.listAllBooks().contains(newBook));
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("111");
        assertEquals(1, library.listAllBooks().size());
        assertNull(library.findBookByTitle("Book1").get(0));
    }

    @Test
    public void testFindBookByTitle() {
        assertEquals(1, library.findBookByTitle("Book1").size());
    }

    @Test
    public void testFindBookByAuthor() {
        assertEquals(1, library.findBookByAuthor("Author2").size());
    }

    @Test
    public void testListAvailableBooks() {
        assertEquals(2, library.listAvailableBooks().size());
    }
}
