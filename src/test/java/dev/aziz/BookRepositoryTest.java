package dev.aziz;

import dev.aziz.entities.Book;
import dev.aziz.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookRepositoryTest {

    BookRepository bookRepository = new BookRepository();

    Book headFirstJava = new Book(1L, "Head First Java", "Kathy Sierra", 2003, 1123341351123L);
    Book effectiveJava = new Book(2L, "Effective Java", "Joshua Bloch", 2008, 6633435112366L);
    Book thinkingInJava = new Book(3L, "Thinking in Java", "Bruce Eckel", 1998, 4443413512444L);
    Book cleanCode = new Book(4L, "Clean Code", "Robert Martin", 2012, 7773341351777L);
    Book findingAJob = new Book(5L, "Finding a Job", "Aziz Abdukarimov", 2012, 9999341351777L);
    List<Book> books = List.of(headFirstJava, effectiveJava, thinkingInJava, cleanCode, findingAJob);

    @BeforeEach
    void setUp() {
        // Initialize your BookRepository instance (e.g., mock data or real data)
        Book headFirstJava = new Book(1L, "Head First Java", "Kathy Sierra", 2003, 1123341351123L);
        Book effectiveJava = new Book(2L, "Effective Java", "Joshua Bloch", 2008, 6633435112366L);
        Book thinkingInJava = new Book(3L, "Thinking in Java", "Bruce Eckel", 1998, 4443413512444L);
        Book cleanCode = new Book(4L, "Clean Code", "Robert Martin", 2012, 7773341351777L);
        Book findingAJob = new Book(5L, "Finding a Job", "Aziz Abdukarimov", 2012, 9999341351777L);
        bookRepository = new BookRepository();
        bookRepository.addBook(headFirstJava);
        bookRepository.addBook(effectiveJava);
        bookRepository.addBook(thinkingInJava);
        bookRepository.addBook(cleanCode);
        bookRepository.addBook(findingAJob);
    }

    @Test
    void getBooksTest() {
        //given
        //when
        List<Book> books1 = bookRepository.getBooks();
        //then
        assertAll(() -> {
            assertNotNull(books1);
            assertEquals(books1.size(), 5);
        });
    }

    @Test
    void deleteBookIdTest() {
        //given
        //when
        bookRepository.deleteBookById(1L);
        List<Book> books1 = bookRepository.getBooks();
        //then
        assertAll(() -> {
            assertNotNull(books1);
            assertEquals(books1.size(), 4);
        });
    }

    @Test
    void addBookTest() {
        //given
        Book newBook = new Book(6L, "Just title", "John Doe", 2020, 1323211441322L);
        //when
        bookRepository.addBook(newBook);
        List<Book> books1 = bookRepository.getBooks();
        //then
        assertAll(() -> {
            assertNotNull(books1);
            assertEquals(books1.size(), 6);
            assertEquals(books1.get(5).getTitle(), "Just title");
        });
    }

    @Test
    void searchBookByTitleTest() {
        //given
        String searchingByTitle = "Clean Code";
        //when
        List<Book> books1 = bookRepository.searchBookByTitle(searchingByTitle);
        //then
        assertAll(() -> {
            assertNotNull(books1);
            assertEquals(books1.size(), 1);
            assertEquals(books1.get(0).getAuthor(), "Robert Martin");
        });
    }

    @Test
    void searchBookByAuthorTest() {
        //given
        String searchingByAuthor = "Robert Martin";
        //when
        List<Book> books1 = bookRepository.searchBookByAuthor(searchingByAuthor);
        //then
        assertAll(() -> {
            assertNotNull(books1);
            assertEquals(books1.size(), 1);
            assertEquals(books1.get(0).getTitle(), "Clean Code");
        });
    }

    @Test
    void searchBookByPublishedYearTest() {
        //given
        String searchingByPublishedYear = "2008";
        //when
        List<Book> books1 = bookRepository.searchBookByPublishedYear(searchingByPublishedYear);
        //then
        assertAll(() -> {
            assertNotNull(books1);
            assertEquals(books1.size(), 1);
            assertEquals(books1.get(0).getTitle(), "Effective Java");
        });
    }

}
