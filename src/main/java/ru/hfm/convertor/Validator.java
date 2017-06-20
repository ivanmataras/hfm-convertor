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

/*        Comparator<DataRecord> sourceFMAccountComparator = new SourceFMAccountComparator();

        Collections.sort(this.dataArray, sourceFMAccountComparator);
        Collections.sort(this.referenceDataArray, sourceFMAccountComparator);*/

        Comparator<DataRecord> sourceFMAccountComparatorThenSourceICPComparator = new SourceFMAccountComparator().thenComparing(new SourceICPComparator());

        Collections.sort(this.dataArray, sourceFMAccountComparatorThenSourceICPComparator);
        Collections.sort(this.referenceDataArray, sourceFMAccountComparatorThenSourceICPComparator);

        List<DataRecord> mergeResult = this.mergeDataUsingOriginalAlgorithm(this.dataArray, referenceDataArray);

        return this.dataArray;

    }

    private List<DataRecord> mergeDataUsingOriginalAlgorithm(List<DataRecord> inputDataArray, List<DataRecord> databaseDataArray) {

        DataRecord[] inputArray = inputDataArray.toArray(new DataRecord[inputDataArray.size()]);
        DataRecord[] databaseArray = databaseDataArray.toArray(new DataRecord[databaseDataArray.size()]);

        for (int inputItemIndex = 0; inputItemIndex <= inputArray.length; inputItemIndex++) {

            DataRecord inputDataRecord = inputArray[inputItemIndex];
            Integer inputSourceFMAccount = inputDataRecord.getSourceFMAccount();
            String inputSourceICP = inputDataRecord.getSourceICP();

            for (int databaseItemIndex = currentDatabaseItemIndex; databaseItemIndex <= databaseArray.length; databaseItemIndex++) {

                DataRecord databaseDataRecord = databaseArray[databaseItemIndex];
                Integer databaseSourceFMAccount = databaseDataRecord.getSourceFMAccount();
                String databaseSourceICP = databaseDataRecord.getSourceICP();

                if (inputSourceFMAccount.compareTo(databaseSourceFMAccount) == 0 & inputSourceICP.compareTo(databaseSourceICP) == 0) {

                    inputDataRecord.fillDataRecord(databaseDataRecord);
                    currentDatabaseItemIndex = ++databaseItemIndex;
                    break;

                } else if (inputSourceFMAccount.compareTo(databaseSourceFMAccount) != 0 & inputSourceICP.compareTo(databaseSourceICP) != 0) {

                    /*
                    * TODO
                    * Implement logging for log merge mistakes.
                    * */

                }

            }

        }

        List<DataRecord> mergedDataSet = new ArrayList<DataRecord>(Arrays.asList(inputArray));

        return mergedDataSet;

/*        for (DataRecord inputDataRecord : inputDataArray) {

            Integer inputSourceFMAccount = inputDataRecord.getSourceFMAccount();
            String inputSourceICP = inputDataRecord.getSourceICP();

            for (DataRecord databaseDataRecord : databaseDataArray) {

                Integer databaseSourceFMAccount = databaseDataRecord.getSourceFMAccount();
                String databaseSourceICP = databaseDataRecord.getSourceICP();

                if (inputSourceFMAccount.compareTo(databaseSourceFMAccount) == 0 & inputSourceICP.compareTo(databaseSourceICP) == 0) {

                    inputDataRecord.fillDataRecord(databaseDataRecord);

                } else if (inputSourceFMAccount.compareTo(databaseSourceFMAccount) != 0 & inputSourceICP.compareTo(databaseSourceICP) != 0) {

                }

            }

        }

        return mergedDataSet;*/

    }

    private List<DataRecord> mergeDataUsingStandardBinarySearch(List<DataRecord> inputDataArray, List<DataRecord> databaseDataArray) {

        List<DataRecord> mergedDataSet = new ArrayList<DataRecord>();

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
