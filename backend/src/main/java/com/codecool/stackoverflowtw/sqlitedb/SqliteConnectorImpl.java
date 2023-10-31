package com.codecool.stackoverflowtw.sqlitedb;

import com.codecool.stackoverflowtw.logger.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnectorImpl implements SqliteConnector {
    private final String connectionString;
    private final Logger logger;

    public SqliteConnectorImpl(String connectionString, Logger logger) {
        this.connectionString = connectionString;
        this.logger = logger;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + connectionString);
            logger.logInfo("Connection to SQLite has been established.");

            return conn;
        } catch (SQLException e) {
            logger.logError(e.getMessage());
        }
        return conn;
    }
}
