package dev.aziz.repositories;

import dev.aziz.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {

    Long counter = 1L;

    List<Book> books = new ArrayList<>();

    public BookRepository() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void deleteBookById(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public void addBook(Book book) {
        book.setId(counter);
        books.add(book);
        counter++;
    }

    public List<Book> searchBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchBookByAuthor(String Author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(Author))
                .collect(Collectors.toList());
    }

    public List<Book> searchBookByPublishedYear(String publishedYear) {
        Integer publishedYearInt;
        try {
            publishedYearInt = Integer.parseInt(publishedYear);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid input number, please input valid number");
            return null;
        }
        return books.stream()
                .filter(book -> book.getPublishedYear().equals(publishedYearInt))
                .collect(Collectors.toList());
    }

}
