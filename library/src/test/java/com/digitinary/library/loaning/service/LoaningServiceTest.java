package com.digitinary.library.loaning.service;

import com.digitinary.library.catalog.entity.Book;
import com.digitinary.library.catalog.entity.BookId;
import com.digitinary.library.catalog.repository.BookRepository;
import com.digitinary.library.loaning.entity.Loan;
import com.digitinary.library.loaning.entity.LoanStatus;
import com.digitinary.library.loaning.repository.LoanRepository;
import com.digitinary.library.user.entity.Librarian;
import com.digitinary.library.user.entity.Member;
import com.digitinary.library.user.entity.User;
import com.digitinary.library.user.entity.UserId;
import com.digitinary.library.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        User user = new Member();
        Book book = new Book();
        UserId userId = new UserId(1);
        BookId bookId = new BookId(1);

        user.setUserId(userId);
        book.setBookId(bookId);

        when(userRepository.findById(eq(userId))).thenReturn(Optional.of(user));
        when(bookRepository.findById(eq(bookId))).thenReturn(Optional.of(book));

        Loan loan = loanService.loanBook(userId, bookId);

        assertNotNull(loan);
        assertEquals(user, loan.getUser());
        assertEquals(book, loan.getBook());
        assertEquals(LocalDate.now(), loan.getLoanDate());
        assertEquals(LocalDate.now().plusWeeks(2), loan.getDueDate());
        assertEquals(LoanStatus.LOANED, loan.getStatus());

        verify(loanRepository, times(1)).save(any(Loan.class));
    }

    @Test
    public void testReturnBook() {
        User user = new Member();
        Book book = new Book();
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now().minusDays(1));
        loan.setStatus(LoanStatus.LOANED);

        when(loanRepository.findByUserAndBook(user, book)).thenReturn(Optional.of(loan));

        loanService.returnBook(user, book);

        assertEquals(LocalDate.now(), loan.getReturnDate());
        assertEquals(LoanStatus.RETURNED, loan.getStatus());
        verify(loanRepository, times(1)).save(loan);
    }

    @Test
    public void testGetLoansByUser() {
        User user = new Member();
        List<Loan> expectedLoans = new ArrayList<>();
        when(loanRepository.findByUser(user)).thenReturn(expectedLoans);

        List<Loan> actualLoans = loanService.getLoansByUser(user);

        assertEquals(expectedLoans, actualLoans);
        verify(loanRepository, times(1)).findByUser(user);
    }
}