package com.digitinary.library.user.entity;

import com.digitinary.library.catalog.entity.Book;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public abstract class User {

    @EmbeddedId
    private UserId userId;

    private String name;

    private Set<Book> books;


}
