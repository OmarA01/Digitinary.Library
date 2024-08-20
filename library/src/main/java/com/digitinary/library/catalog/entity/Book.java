package com.digitinary.library.catalog.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book {

    @EmbeddedId
    private BookId bookId;

    private String title;

    private Author author;

    private CategoryType categoryType;

    private long quantity = 0;

}
