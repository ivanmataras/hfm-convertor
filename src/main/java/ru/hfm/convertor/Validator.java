package ru.hfm.convertor;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/*
 * Class for validating input data
 *
 * @author imataras
 * @since 06.04.2017
 */

class Validator {

    private Parameters parameters;
    private List<DataRecord> dataArray;
    private List<DataRecord> referenceData;
    //Connection connection;

    Validator(Parameters parameters, List<DataRecord> dataArray) {
        this.parameters = parameters;
        this.dataArray = dataArray;

    }

    List<DataRecord> validate() {

        this.referenceData = getReferenceDataFromDataBase();

        return this.dataArray;

    }

    List<DataRecord> getReferenceDataFromDataBase() {

        List<DataRecord> referenceData = new ArrayList<DataRecord>();
        Connection connection = null;

        try {
            // create a database connection
            String url = "jdbc:sqlite:E:\\Development\\HFM convertor project\\database\\database.db";
            connection = DriverManager.getConnection(url);
            //PreparedStatement preparedStatement = connection.prepareStatement(getStatementText());
            Statement statement = connection.createStatement();

            String dataBaseTableName = this.parameters.getDataBaseTableName();

            //preparedStatement.setString(1, dataBaseTableName);

            //ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSet = statement.executeQuery(getStatementText());

            while (resultSet.next()) {

                DataRecord dataRecord = new DataRecord();

                dataRecord.setSourceFMEntity(resultSet.getString("SourceFMEntity"));
                dataRecord.setSourceFMAccount(resultSet.getInt("SourceFMAccount"));
                dataRecord.setSourceICP(resultSet.getString("SourceICP"));
                dataRecord.setSourceCustom1(resultSet.getString("SourceCustom1"));
                dataRecord.setSourceCustom2(resultSet.getString("SourceCustom2"));
                dataRecord.setSourceCustom3(resultSet.getString("SourceCustom3"));
                dataRecord.setSourceCustom4(resultSet.getString("SourceCustom4"));
                dataRecord.setAmount(resultSet.getBigDecimal("Amount"));

                referenceData.add(dataRecord);

            }

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }

        return referenceData;
    }

    private String getStatementText() {

        final String statementText = "SELECT SourceFMEntity, SourceFMAccount, SourceICP, SourceCustom1, SourceCustom2, SourceCustom3, SourceCustom4, Amount FROM ".concat(this.parameters.getDataBaseTableName());
        return statementText;

    }

}
