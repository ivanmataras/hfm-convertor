package ru.hfm.convertor;

/*
 * Class for writing output data
 *
 * @author imataras
 * @since 06.04.2017
 */

import java.io.*;
import java.util.Iterator;
import java.util.List;

class Writer {

    private Parameters parameters;
    private File file;
    private List<DataRecord> dataArray;
    private StringBuilder resultString;
    private final String DEFAULT_DEPARATOR = ";";

    Writer(Parameters parameters, List<DataRecord> dataArray) {
        this.parameters = parameters;
        this.dataArray = dataArray;
        this.resultString = new StringBuilder(128);
    }

    void setFile() {
        this.file = new File(parameters.getOutputFile());
    }

    private void createNewFile() {

        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else if (this.file.exists()) {
            if (this.file.canWrite()) {
                this.file.delete();
            }
        }

    }

    void writeFile() {

        createNewFile();

        try (FileWriter fileWriter = new FileWriter(this.file.getAbsoluteFile())) {

            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, 1024 * 1024)) {

                Iterator<DataRecord> dataArrayIterator = dataArray.iterator();

                while (dataArrayIterator.hasNext()) {

                    DataRecord dataRecord = dataArrayIterator.next();
                    StringBuilder resultStringLine = constructLine(dataRecord);
                    bufferedWriter.write(resultStringLine.toString());
                    this.resultString.delete(0, resultString.length());
                    bufferedWriter.newLine();

                }

                bufferedWriter.flush();

                bufferedWriter.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private StringBuilder constructLine(DataRecord dataRecord) {

        this.resultString.append(dataRecord.getSourceFMEntity());
        this.resultString.append(DEFAULT_DEPARATOR);
        this.resultString.append(dataRecord.getSourceFMAccount());
        this.resultString.append(DEFAULT_DEPARATOR);
        this.resultString.append(dataRecord.getSourceICP());
        this.resultString.append(DEFAULT_DEPARATOR);
        this.resultString.append(dataRecord.getSourceCustom1());
        this.resultString.append(DEFAULT_DEPARATOR);
        this.resultString.append(dataRecord.getSourceCustom2());
        this.resultString.append(DEFAULT_DEPARATOR);
        this.resultString.append(dataRecord.getSourceCustom3());
        this.resultString.append(DEFAULT_DEPARATOR);
        this.resultString.append(dataRecord.getSourceCustom4());
        this.resultString.append(DEFAULT_DEPARATOR);
        this.resultString.append(dataRecord.getAmount());

        return resultString;

    }

}
