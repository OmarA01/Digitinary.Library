package com.digitinary.library;

import com.digitinary.library.catalog.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookValidatorTest {

    private BookValidator underTest;
    private BookRepository bookRepository;
    private BookCatalogService bookCatalogService;

    @BeforeEach
    void setUp(){
        underTest = new BookValidator();
        bookRepository = Mockito.mock(BookRepository.class);
        bookCatalogService = new BookCatalogService(bookRepository);
    }

    @Test
    void itShouldValidateBook(){
        Book book = new Book();

        boolean isValid = underTest.validate(book);


    }

}
