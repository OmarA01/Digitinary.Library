package com.digitinary.library.catalog.service;

import com.digitinary.library.catalog.entity.Book;
import com.digitinary.library.catalog.entity.BookId;
import com.digitinary.library.catalog.repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    public void save(Book book) {
        bookRepository.save(book);
    }

    public void saveAll(List<Book> books) {
        bookRepository.saveAll(books);
    }

    public boolean existsByName(String title) {
        return (boolean) bookRepository.existsByTitle(title);
    }

    public Book getById(BookId bookId) {
        return bookRepository.getById(bookId);
    }

    public Book getByTitle(String name) {
        return (Book) bookRepository.getByTitle(name);
    }
}
