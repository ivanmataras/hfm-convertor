package ru.hfm.convertor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private List<DataRecord> referenceDataArray = new ArrayList<DataRecord>();
    //Connection connection;

    Validator(Parameters parameters, List<DataRecord> dataArray) {

        this.parameters = parameters;
        this.dataArray = dataArray;

    }

    List<DataRecord> validate() {

        this.getReferenceDataFromDataBase();

//        Comparator<DataRecord> sourceFMAccountComparator = new SourceFMAccountComparator();
//        Collections.sort(this.dataArray, sourceFMAccountComparator);

        Comparator<DataRecord> sourceFMAccountComparatorThenSourceICPComparator = new SourceFMAccountComparator().thenComparing(new SourceICPComparator());
        Collections.sort(this.referenceDataArray, sourceFMAccountComparatorThenSourceICPComparator);

        return this.dataArray;

    }

    private void getReferenceDataFromDataBase() {

        List<DataRecord> referenceData = new ArrayList<DataRecord>();
        Connection connection = null;

        try {

            // create a database connection
            String url = "jdbc:sqlite:E:\\Development\\HFM convertor project\\database\\database.db";
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String dataBaseTableName = this.parameters.getDataBaseTableName();
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

                referenceDataArray.add(dataRecord);

            }

        } catch (SQLException exception) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            exception.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException exception) {
                // connection close failed.
                exception.printStackTrace();
            }
        }

    }

    private String getStatementText() {

        final String statementText = "SELECT SourceFMEntity, SourceFMAccount, SourceICP, SourceCustom1, SourceCustom2, SourceCustom3, SourceCustom4, Amount FROM ".concat(this.parameters.getDataBaseTableName());
        return statementText;

    }

}
