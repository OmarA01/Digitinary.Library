package com.digitinary.library.user.repository;

import com.digitinary.library.user.entity.User;
import com.digitinary.library.user.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByUserId(Integer id);

}
