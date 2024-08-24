package com.digitinary.library.catalog.model;

import com.digitinary.library.catalog.entity.Author;
import com.digitinary.library.catalog.entity.BookId;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    private BookId bookId;

    private String title;

    private Author author;

    private String categoryType;

    private double price;

    private long quantity = 0;
}
