package com.example.spring2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Books {
    private static Books instance;
    public final List<Book> books = new ArrayList<>();

    public Books() { }

    public static Books getInstance() {
        if (instance == null) instance = new Books();
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(Long id) {
        List<Book> books_filtered = books
                .stream()
                .filter(book -> Objects.equals(book.id, id))
                .toList();
        if (!books_filtered.isEmpty()) {
            return books_filtered.get(0);
        }
        return null;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public List<Book> addBooks(List<Book> books) {
        if (books.isEmpty()) return new ArrayList<>();
        this.books.addAll(books);
        return books;
    }

    public List<Book> deleteBook(Long id) {
        List<Book> books_filtered = books
                .stream()
                .filter(book -> Objects.equals(book.id, id))
                .toList();
        books.removeAll(books_filtered);
        return books_filtered;
    }
}
