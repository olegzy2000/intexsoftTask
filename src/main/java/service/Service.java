package service;

import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Service {
    protected Statement statement;
    protected DatabaseConnection databaseConnection;
    public Service(){
        try {
            databaseConnection=new DatabaseConnection();
            Connection connection = DriverManager.getConnection(databaseConnection.getHost(),
                    databaseConnection.getUser(),
                    databaseConnection.getPassword());
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
