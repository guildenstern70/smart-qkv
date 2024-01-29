/*
 * The Smart QKV Project
 * Copyright (c) Alessio Saltarin, 2024
 * This software is licensed under ISC License
 * See LICENSE
 */

package net.littlelite.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.time.LocalDate;
import java.util.List;


@MongoEntity(collection="books")
public class Book extends PanacheMongoEntity
{
    public String isbn;

    public String title;

    public String description;

    public LocalDate publicationDate;

    public Status status;

    public List<Author> authorList;

}
