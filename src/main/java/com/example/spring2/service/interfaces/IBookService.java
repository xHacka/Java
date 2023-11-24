package com.example.spring2.service.interfaces;

import com.example.spring2.model.Book;

import java.util.List;

public interface IBookService {
    // Service Methods

    List<Book> getBooks();

    Book getBook(Long id);

    List<Book> deleteBook(Long id);

    Book addBook(Book book);

    List<Book> addBooks(List<Book> books);
}
