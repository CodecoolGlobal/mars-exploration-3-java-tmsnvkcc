package com.codecool.stackoverflowtw.postgresDb;

import java.sql.Connection;

public interface PsqlConnector {
    public Connection getConnection();
}
