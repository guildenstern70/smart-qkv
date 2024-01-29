/*
 * The Smart QKV Project
 * Copyright (c) Alessio Saltarin, 2024
 * This software is licensed under ISC License
 * See LICENSE
 */

package net.littlelite.service;

import net.littlelite.config.SmartQkv;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class Startup
{
    @Inject
    SmartQkv smartqkv;

    @Inject
    DbInitializer dbInitializer;

    private static final Logger LOG = LoggerFactory.getLogger(Startup.class);

    void onStart(@Observes StartupEvent ev)
    {
        LOG.info("*****************************************************************");
        LOG.info("  SmartQKV v." + smartqkv.version());
        LOG.info("  JVM: " + System.getProperty("java.vendor") + " " + System.getProperty("java.version"));
        LOG.info("  Listening on: http://localhost:8080");
        LOG.info("*****************************************************************");

        this.dbInitializer.populateDb();
    }

    void onStop(@Observes ShutdownEvent ev)
    {
        LOG.info("The application is stopping...");
    }
}
