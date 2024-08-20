package com.digitinary.library.catalog.service;

import com.digitinary.library.catalog.repository.BookRepository;
import com.digitinary.library.util.BookValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private BookRepository bookRepository;
    private BookService bookCatalogService;

    @BeforeEach
    void setUp(){
        bookRepository = Mockito.mock(BookRepository.class);
        bookCatalogService = new BookService(bookRepository);
    }

    @Test
    void bookExists(){

    }

    @Test
    void booksDosentExist(){

    }

}