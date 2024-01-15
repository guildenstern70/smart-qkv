/*
 * The Smart QKV Project
 * Copyright (c) Alessio Saltarin, 2024
 * This software is licensed under MIT License
 * See LICENSE
 */

package net.littlelite.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection="books")
public class Book extends PanacheMongoEntity
{
    public String isbn;

    public String title;

    public String description;

    public LocalDate publicationDate;

    public Status status;

    public List<Author> authorList = new ArrayList<>();

    public static Book findByIsbn(String isbn)
    {
        return find("isbn", isbn).firstResult();
    }

    public static List<Book> findByStatusAvailable()
    {
        return list("status", Status.AVAILABLE);
    }

    public static long getSize()
    {
        return count();
    }

    public static void deleteByIsbn(String isbn)
    {
        delete("isbn", isbn);
    }

    public static void create(Book book)
    {
        book.persist();
    }

}
