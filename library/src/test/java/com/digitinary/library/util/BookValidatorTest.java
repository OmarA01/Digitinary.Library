package com.digitinary.library.util;

import com.digitinary.library.catalog.entity.Book;
import com.digitinary.library.catalog.repository.BookRepository;
import com.digitinary.library.catalog.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BookValidatorTest {

    private BookValidator underTest;
    private BookRepository bookRepository;
    private BookService bookCatalogService;

    @BeforeEach
    void setUp(){
        underTest = new BookValidator();
        bookRepository = Mockito.mock(BookRepository.class);
        bookCatalogService = new BookService(bookRepository);
    }

    @Test
    void itShouldValidateBook(){
        Book book = new Book();

        boolean isValid = underTest.test(book);

        assertThat(isValid).isTrue();
    }

    @Test
    void itShouldValidateBookAvailability(){
        Book book = new Book();

        boolean isValid = underTest.isAvailable(book);

        assertThat(isValid).isTrue();
    }

}
