package com.digitinary.library.catalog.mapper;

import com.digitinary.library.catalog.entity.Author;
import com.digitinary.library.catalog.entity.Book;
import com.digitinary.library.catalog.entity.BookId;
import com.digitinary.library.catalog.model.BookModel;

public class BookMapper {

    public static Book toEntity(BookModel bookModel){
        return Book.builder()
                .bookId(new BookId(bookModel.getBookId().getId()))
                .title(bookModel.getTitle())
                .author(new Author(bookModel.getAuthor().getAuthorId(),bookModel.getAuthor().getName(),bookModel.getAuthor().getBio()))
                .categoryType(bookModel.getCategoryType())
                .price(bookModel.getPrice())
                .quantity(bookModel.getQuantity())
                .build();
    }

    public static BookModel toModel(Book book){
        return BookModel.builder()
                .bookId(new BookId(book.getBookId().getId()))
                .title(book.getTitle())
                .author(new Author(book.getAuthor().getAuthorId(),book.getAuthor().getName(),book.getAuthor().getBio()))
                .categoryType(book.getCategoryType())
                .price(book.getPrice())
                .quantity(book.getQuantity())
                .build();
    }

}
