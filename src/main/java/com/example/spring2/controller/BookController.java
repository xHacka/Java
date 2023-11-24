package com.example.spring2.controller;

import com.example.spring2.model.Book;
import com.example.spring2.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    // Best Practice Is To Use Services

    private final IBookService bookService;

    @Autowired
    BookController(IBookService iBookService) {
        bookService = iBookService; // Dependency Injection
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("/addmany")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return bookService.addBooks(books);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @GetMapping("/")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @DeleteMapping("/{id}")
    public List<Book> deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}
