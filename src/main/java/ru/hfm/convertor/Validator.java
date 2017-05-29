package ru.hfm.convertor;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Class for validating input data
 *
 * @author imataras
 * @since 06.04.2017
 */


class Validator {

    private Parameters parameters;
    private List<DataRecord> dataArray;
    Connection connection;

    Validator(Parameters parameters, List<DataRecord> dataArray) {
        this.parameters = parameters;
        this.dataArray = dataArray;

    }

    List<DataRecord> validate() {

        connection = getConnection();

        return this.dataArray;
    }

    Connection getConnection() {

        Connection connection = null;

        try {
            String url = "jdbc:sqlite:E:\\Development\\HFM convertor project\\database\\database.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            //return connection;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return connection;
    }

}
