/*
 * The Smart QKV Project
 * Copyright (c) Alessio Saltarin, 2024
 * This software is licensed under ISC License
 * See LICENSE
 */

package net.littlelite.dao;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import net.littlelite.model.Book;
import net.littlelite.model.Status;

import java.util.List;

@ApplicationScoped
public class BookDao implements PanacheMongoRepository<Book>
{

    public Book findByIsbn(String isbn)
    {
        return find("isbn", isbn).firstResult();
    }

    public List<Book> findByStatusAvailable()
    {
        return list("status", Status.AVAILABLE);
    }

    public long getSize()
    {
        return count();
    }

    public void deleteByIsbn(String isbn)
    {
        delete("isbn", isbn);
    }

    public void create(Book book)
    {
        book.persist();
    }
}
