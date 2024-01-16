/*
 * The Smart QKV Project
 * Copyright (c) Alessio Saltarin, 2024
 * This software is licensed under MIT License
 * See LICENSE
 */

package net.littlelite.controller.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import net.littlelite.dao.BookDao;
import net.littlelite.model.Book;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/books")
@Tag(name = "Books Controller", description = "Book related APIs")
public class Books
{

    @Inject
    BookDao bookDao;

    @GET
    @Operation(summary = "Get all books")
    public List<Book> list()
    {
        return this.bookDao.listAll();
    }

    @POST
    @Operation(summary = "Create new book")
    public Book add(Book book)
    {
        this.bookDao.create(book);
        return book;
    }

    @DELETE
    @Operation(summary = "Delete a book")
    public void delete(Book book)
    {
        this.bookDao.deleteByIsbn(book.isbn);
    }
}