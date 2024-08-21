package com.digitinary.library.catalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book {

    @EmbeddedId
    private BookId bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private Author author;

    @Column(name = "category")
    private CategoryType categoryType;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private long quantity = 0;

}
