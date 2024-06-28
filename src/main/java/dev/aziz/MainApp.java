package dev.aziz;

import dev.aziz.entities.Book;
import dev.aziz.repositories.BookRepository;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();

        Book headFirstJava = new Book("Head First Java", "Kathy Sierra", 2003, 1123341351123L);
        Book effectiveJava = new Book("Effective Java", "Joshua Bloch", 2008, 6633435112366L);
        Book thinkingInJava = new Book("Thinking in Java", "Bruce Eckel", 1998, 4443413512444L);
        Book cleanCode = new Book("Clean Code", "Robert Martin", 2012, 7773341351777L);
        Book findingAJob = new Book("Finding a Job", "Aziz Abdukarimov", 2012, 9999341351777L);
        bookRepository.addBook(headFirstJava);
        bookRepository.addBook(effectiveJava);
        bookRepository.addBook(thinkingInJava);
        bookRepository.addBook(cleanCode);
        bookRepository.addBook(findingAJob);

        System.out.println("Welcome to book management system");
        boolean isAlive = true;
        while (isAlive) {
            System.out.println("To add a book type: add title Star author Ben publishedYear 1975 ISBN 124565134133");
            System.out.println("To delete a book type: delete and id of the book: delete 1");
            System.out.println("To get all books type: getall");
            System.out.println("To get a book a search just type: get - then you will input with steps");
            System.out.println("To exit from the app type: exit");
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            String[] commands = command.split(" ");
            if (commands[0].equals("add")) {
                Book book = new Book(commands[2], commands[4], Integer.valueOf(commands[6]), Long.valueOf(commands[8]));
                bookRepository.addBook(book);
                System.out.println("Book added to the database");
            }

            if (commands[0].equals("getall")) {
                System.out.println(bookRepository.getBooks());
            }

            if (commands[0].equals("get")) {
                System.out.println("Please input wanted field: title or author or publishedYear");
                String field = scanner.nextLine();
                String title;
                String author;
                String publishedYear;
                if (field.equals("title")) {
                    System.out.println("Please input wanted book title: ");
                    title = scanner.nextLine();
                    List<Book> book = bookRepository.searchBookByTitle(title);
                    System.out.println("book = " + book);
                }
                if (field.equals("author")) {
                    System.out.println("Please input wanted book author: ");
                    author = scanner.nextLine();
                    List<Book> book = bookRepository.searchBookByAuthor(author);
                    System.out.println("book = " + book);
                }
                if (field.equals("publishedYear")) {
                    System.out.println("Please input wanted book publishedYear: ");
                    publishedYear = scanner.nextLine();
                    List<Book> book = bookRepository.searchBookByPublishedYear(publishedYear);
                    System.out.println("book = " + book);
                }
            }

            if (commands[0].equals("delete")) {
                bookRepository.deleteBookById(Long.valueOf(commands[1]));
                System.out.println("Book deleted from the database");
            }

            if (command.equals("exit")) {
                isAlive = false;
            }
            System.out.println("\nPlease type on of these commands:");
        }
    }
}
