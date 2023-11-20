package com.votifysoft.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDb implements Serializable {

    private static final String URL = "jdbc:mysql://localhost:3306/votify";

    private static final String USER = "root";

    private static final String PASSWORD = "lafamilia";

    private static MySqlDb database;

    private Connection connection;

    private MySqlDb() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static MySqlDb getInstance() throws SQLException{
        if (database == null)
            database = new MySqlDb();

        return database;

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
