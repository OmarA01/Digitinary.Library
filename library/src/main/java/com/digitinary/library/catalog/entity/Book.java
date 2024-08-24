package com.digitinary.library.catalog.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private Author author;

    @Column(name = "category")
    private String categoryType;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private long quantity = 0;

}
