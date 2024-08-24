package com.digitinary.library.catalog.repository;

import com.digitinary.library.catalog.entity.Book;
import com.digitinary.library.catalog.entity.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, BookId> {
    Object existsByTitle(String title);

    Object getByTitle(String title);
}
