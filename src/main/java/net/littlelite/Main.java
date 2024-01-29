/*
 * The Smart QKV Project
 * Copyright (c) Alessio Saltarin, 2024
 * This software is licensed under ISC License
 * See LICENSE
 */

package net.littlelite;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@QuarkusMain
public class Main implements QuarkusApplication
{
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    @Override
    public int run(String... args)
    {
        LOG.info("Running Quarkus");
        Quarkus.waitForExit();
        return 0;
    }
}
