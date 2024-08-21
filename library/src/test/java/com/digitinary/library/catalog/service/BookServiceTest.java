package com.digitinary.library.catalog.service;

import com.digitinary.library.catalog.entity.Book;
import com.digitinary.library.catalog.entity.BookId;
import com.digitinary.library.catalog.repository.BookRepository;
import com.digitinary.library.util.BookValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testSave() {
        Book book = new Book();
        bookService.save(book);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testSaveAll() {
        List<Book> books = Arrays.asList(new Book(), new Book());
        bookService.saveAll(books);
        verify(bookRepository, times(1)).saveAll(books);
    }

    @Test
    void testExistsByName() {
        String name = "Test Book";
        when(bookRepository.existsByName(name)).thenReturn(true);

        boolean exists = bookService.existsByName(name);

        assertTrue(exists);
        verify(bookRepository, times(1)).existsByName(name);
    }

    @Test
    void testGetById() {
        BookId bookId = new BookId();
        bookId.setBookId(1);
        Book book = new Book();
        when(bookRepository.getById(bookId)).thenReturn(book);

        Book result = bookService.getById(bookId);

        assertEquals(book, result);
        verify(bookRepository, times(1)).getById(bookId);
    }

    @Test
    void testGetByName() {
        String name = "Test Book";
        Book book = new Book();
        when(bookRepository.getByTitle(name)).thenReturn(book);

        Book result = bookService.getByTitle(name);

        assertEquals(book, result);
        verify(bookRepository, times(1)).getByTitle(name);
    }
}