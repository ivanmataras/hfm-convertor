package ru.hfm.convertor;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

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
    private List<DataRecord> referenceDataArray = new ArrayList<DataRecord>();
    //Connection connection;
    private int currentDatabaseItemIndex = 0;

    Validator(Parameters parameters, List<DataRecord> dataArray) {

        this.parameters = parameters;
        this.dataArray = dataArray;

    }

    List<DataRecord> validate() {

        this.getReferenceDataFromDataBase();
        List<DataRecord> mergeResult = this.mergeDataUsingStandardBinarySearch();
        return mergeResult;

    }

    private List<DataRecord> mergeDataUsingStandardBinarySearch() {

        Comparator<DataRecord> sourceFMAccountComparatorThenSourceICPComparator = new SourceFMAccountComparator().thenComparing(new SourceICPComparator());

        Collections.sort(this.dataArray, sourceFMAccountComparatorThenSourceICPComparator);
        Collections.sort(this.referenceDataArray, sourceFMAccountComparatorThenSourceICPComparator);

        for (DataRecord inputDataRecordElement : this.dataArray) {

            int elementIndex = Collections.binarySearch(this.referenceDataArray, inputDataRecordElement, sourceFMAccountComparatorThenSourceICPComparator);

            if (elementIndex >= 0) {
                DataRecord databaseDataRecordElement = this.referenceDataArray.get(elementIndex);
                inputDataRecordElement.fillDataRecord(databaseDataRecordElement);
            } else if (elementIndex < 0) {

                /*
                * TODO
                * implement element not found case and it's loging
                * */

            }

        }

        List<DataRecord> mergedDataSet = new ArrayList<DataRecord>();
        mergedDataSet.addAll(this.dataArray);

        return mergedDataSet;

    }

    private void getReferenceDataFromDataBase() {

        List<DataRecord> referenceData = new ArrayList<DataRecord>();
        Connection connection = null;

        try {

            // create a database connection
            //String url = "jdbc:sqlite:E:\\Development\\HFM convertor project\\database\\database.db";
            String url = "jdbc:sqlite:".concat(this.parameters.getConnectionString());
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
