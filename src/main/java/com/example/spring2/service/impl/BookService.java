package com.example.spring2.service.impl;

import com.example.spring2.model.Book;
import com.example.spring2.model.Books;
import com.example.spring2.service.interfaces.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    // Implement Methods And Error Handling

    @Override
    public List<Book> getBooks() {
        return Books.getInstance().getBooks();
    }

    @Override
    public Book getBook(Long id) {
        return Books.getInstance().getBook(id);
    }

    @Override
    public List<Book> deleteBook(Long id) {
        return Books.getInstance().deleteBook(id);
    }

    @Override
    public Book addBook(Book book) {
        return Books.getInstance().addBook(book);
    }

    @Override
    public List<Book> addBooks(List<Book> books) {
        return Books.getInstance().addBooks(books);
    }
}
