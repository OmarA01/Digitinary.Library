package com.digitinary.library.user.repository;

import com.digitinary.library.catalog.entity.BookId;
import com.digitinary.library.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, BookId> {
}
