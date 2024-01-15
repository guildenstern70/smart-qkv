/*
 * The Smart QKV Project
 * Copyright (c) Alessio Saltarin, 2024
 * This software is licensed under MIT License
 * See LICENSE
 */

package net.littlelite.service;

import jakarta.enterprise.context.ApplicationScoped;
import net.littlelite.model.Author;
import net.littlelite.model.Book;
import net.littlelite.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class DbInitializer
{
    private static final Logger LOG = LoggerFactory.getLogger(DbInitializer.class);

    public void populateDb()
    {
        if (Book.getSize() < 1)
        {
            LOG.info("Populating DB...");
            this.getBooks().forEach(Book::create);
            LOG.info("Done populating DB.");
            var size = Book.getSize();
            LOG.info("Books in MongoDB: " + size);
        }
        else
        {
            LOG.info("DB already populated with " + Book.getSize() + " books.");
        }
    }

    private List<Book> getBooks()
    {
        var saltarin = new Author();
        saltarin.name = "Alessio";
        saltarin.surname = "Saltarin";
        saltarin.birthDate = java.time.LocalDate.of(1970, 1, 1);

        var rubyrails = new Book();
        rubyrails.isbn = "978-1-93435-608-1";
        rubyrails.title = "Ruby e Rails";
        rubyrails.description = "Learn Web Development with Rails";
        rubyrails.publicationDate = java.time.LocalDate.of(2019, 1, 1);
        rubyrails.status = Status.AVAILABLE;
        rubyrails.authorList.add(saltarin);

        var eckel = new Author();
        eckel.name = "Bruce";
        eckel.surname = "Eckel";
        eckel.birthDate = java.time.LocalDate.of(1957, 7, 8);

        var marsch = new Author();
        marsch.name = "Dianne";
        marsch.surname = "Marsch";
        marsch.birthDate = java.time.LocalDate.of(1960, 1, 1);

        var atomicScala = new Book();
        atomicScala.isbn = "978-1-93435-608-1";
        atomicScala.title = "Atomic Scala";
        atomicScala.description = "Learn Programming in the Language of the Future";
        atomicScala.publicationDate = java.time.LocalDate.of(2019, 1, 1);
        atomicScala.status = Status.AVAILABLE;
        atomicScala.authorList.add(eckel);
        atomicScala.authorList.add(marsch);

        var manzoni = new Author();
        manzoni.name = "Alessandro";
        manzoni.surname = "Manzoni";
        manzoni.birthDate = java.time.LocalDate.of(1785, 3, 7);

        var promessiSposi = new Book();
        promessiSposi.isbn = "978-1-93435-608-1";
        promessiSposi.title = "I Promessi Sposi";
        promessiSposi.description = "Storia di due sposi";
        promessiSposi.publicationDate = java.time.LocalDate.of(1805, 1, 1);
        promessiSposi.status = Status.AVAILABLE;
        promessiSposi.authorList.add(manzoni);

        return List.of(rubyrails, atomicScala, promessiSposi);
    }
}
