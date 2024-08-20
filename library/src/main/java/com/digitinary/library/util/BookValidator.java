package com.digitinary.library.util;

import com.digitinary.library.catalog.entity.Book;

import java.util.function.Predicate;

public class BookValidator implements Predicate<Book> {

    @Override
    public boolean test(Book book) {
        return true;
    }

    public boolean isAvailable(Book book){
        return book.getQuantity() > 0;
    }
}
