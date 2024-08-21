package com.digitinary.library.loaning.repository;

import com.digitinary.library.catalog.entity.Book;
import com.digitinary.library.loaning.entity.Loan;
import com.digitinary.library.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    void save(Loan any);

    void delete(Loan any);

    List<Loan> findByUser(User user);

    Optional<Loan> findByUserAndBook(User user, Book book);
}
