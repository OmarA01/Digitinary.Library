package com.digitinary.library.loaning.service;

import com.digitinary.library.catalog.entity.Book;
import com.digitinary.library.catalog.entity.BookId;
import com.digitinary.library.catalog.repository.BookRepository;
import com.digitinary.library.loaning.entity.Loan;
import com.digitinary.library.loaning.entity.LoanStatus;
import com.digitinary.library.loaning.repository.LoanRepository;
import com.digitinary.library.user.entity.Member;
import com.digitinary.library.user.entity.User;
import com.digitinary.library.user.entity.UserId;
import com.digitinary.library.user.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class LoaningService {
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private LoanRepository loanRepository;

    public LoaningService(BookRepository bookRepository, UserRepository userRepository, LoanRepository loanRepository){
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    public Loan loanBook(UserId userId, BookId bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("book not found"));

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusWeeks(2));
        loan.setStatus(LoanStatus.LOANED);

        loanRepository.save(loan);
        return loan;
    }

    public void returnBook(User user, Book book) {
        Loan loan = loanRepository.findByUserAndBook(user, book).orElseThrow(() -> new RuntimeException("loan not found"));
        loan.setReturnDate(LocalDate.now());
        loan.setStatus(LoanStatus.RETURNED);
        loanRepository.save(loan);
    }

    public List<Loan> getLoansByUser(User user) {
        List<Loan> loans = loanRepository.findByUser(user);
        return loans;
    }
}
