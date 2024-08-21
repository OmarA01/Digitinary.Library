package com.digitinary.library.loaning.service;

import com.digitinary.library.catalog.entity.Book;
import com.digitinary.library.catalog.repository.BookRepository;
import com.digitinary.library.loaning.entity.Loan;
import com.digitinary.library.loaning.repository.LoanRepository;
import com.digitinary.library.user.entity.Librarian;
import com.digitinary.library.user.entity.User;
import com.digitinary.library.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoaningServiceTest {
    @Mock
    private LoanRepository loanRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private LoaningService loanService;


    @Test
    public void testLoanBook() {
        User user = new Librarian(); // Initialize with necessary data
        Book book = new Book(); // Initialize with necessary data

        loanService.loanBook(user, book);

        // Verify that the loan repository's save method was called once
        verify(loanRepository, times(1)).save(any(Loan.class));
    }

    @Test
    public void testReturnBook() {
        User user = new Librarian(); // Initialize with necessary data
        Book book = new Book(); // Initialize with necessary data

        loanService.returnBook(user, book);

        // Verify that the loan repository's delete method was called once
        verify(loanRepository, times(1)).delete(any(Loan.class));
    }

    @Test
    public void testGetLoansByUser() {
        User user = new Librarian(); // Initialize with necessary data
        List<Loan> expectedLoans = new ArrayList<>();
        when(loanRepository.findByUser(user)).thenReturn(expectedLoans);

        List<Loan> actualLoans = loanService.getLoansByUser(user);

        assertEquals(expectedLoans, actualLoans);
        verify(loanRepository, times(1)).findByUser(user);
    }
}