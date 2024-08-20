package com.digitinary.library.catalog.repository;

import com.digitinary.library.catalog.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
