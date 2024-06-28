package dev.aziz.entities;

public class Book {

    private Long id;

    private String title;

    private String author;

    private Integer publishedYear;

    private Long ISBN;

    public Book(Long id, String title, String author, Integer publishedYear, Long ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.ISBN = ISBN;
    }

    public Book(String title, String author, Integer publishedYear, Long ISBN) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.ISBN = ISBN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedYear=" + publishedYear +
                ", ISBN=" + ISBN +
                '}';
    }
}
