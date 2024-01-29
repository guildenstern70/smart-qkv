/*
 * The Smart QKV Project
 * Copyright (c) Alessio Saltarin, 2024
 * This software is licensed under ISC License
 * See LICENSE
 */

package net.littlelite.dto;

import net.littlelite.model.Author;
import net.littlelite.model.Book;
import net.littlelite.model.Status;

import java.time.LocalDate;
import java.util.List;

public record BookDto(
        String isbn,
        String title,
        String description,
        LocalDate publicationDate,
        Status status,
        List<Author> authors
)
{

    // Empty constructor for JSONB serialization
    public BookDto()
    {
        this("", "", "", LocalDate.now(), Status.UNKNOWN, List.of());
    }

    public Book toEntity()
    {
        var book = new Book();
        book.isbn = this.isbn;
        book.title = this.title;
        book.description = this.description;
        book.publicationDate = this.publicationDate;
        book.status = this.status;
        book.authorList = this.authors;
        return book;
    }

    public static BookDto fromEntity(Book book)
    {
        return new BookDto(
                book.isbn,
                book.title,
                book.description,
                book.publicationDate,
                book.status,
                book.authorList
        );
    }
}
