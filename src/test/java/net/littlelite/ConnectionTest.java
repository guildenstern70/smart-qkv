/*
 * The Smart QKV Project
 * Copyright (c) Alessio Saltarin, 2024
 * This software is licensed under ISC License
 * See LICENSE
 */

package net.littlelite;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import net.littlelite.service.DbInitializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@QuarkusTest
@DisplayName("Database")
public class ConnectionTest
{
    @Inject
    DbInitializer dbService;

    @Test
    @DisplayName("should be connected and running")
    void testDbConnection()
    {
        assertThat(dbService).isNotNull();
        assertThat(dbService.isDbConnected()).isTrue();
    }

}
