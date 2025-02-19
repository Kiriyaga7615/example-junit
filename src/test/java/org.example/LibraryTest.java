package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Book Title 1", "Author 1");
        book2 = new Book("Book Title 2", "Author 2");
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    public void testRemoveBook() {
        library.addBook(book1);
        assertTrue(library.removeBook(book1));
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void testRemoveNonExistentBook() {
        assertFalse(library.removeBook(book1));
    }

    @Test
    public void testAddNullBook() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
        assertEquals("Book cannot be null", thrown.getMessage());
    }

    @Test
    public void testRemoveNullBook() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> library.removeBook(null));
        assertEquals("Book cannot be null", thrown.getMessage());
    }

    @Test
    public void testGetBooks() {
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getBooks().size());
        assertTrue(library.getBooks().contains(book1));
        assertTrue(library.getBooks().contains(book2));
    }

    @Test
    public void testGetBookCount() {
        assertEquals(0, library.getBookCount());
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
    }

    @Test
    public void testBookEqualsAndHashCode() {
        Book book3 = new Book("Book Title 1", "Author 1");
        assertEquals(book1, book3);
        assertEquals(book1.hashCode(), book3.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Book{title='Book Title 1', author='Author 1'}";
        assertEquals(expected, book1.toString());
    }
}
