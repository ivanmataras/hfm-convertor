package ru.hfm.convertor;

/*
 * Class for writing output data
 *
 * @author imataras
 * @since 06.04.2017
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class Writer {

    private Parameters parameters;
    private File file;
    private List<DataRecord> dataArray;

    Writer(Parameters parameters, List<DataRecord> dataArray) {
        this.parameters = parameters;
        this.dataArray = dataArray;
    }

    void setFile() {
        this.file = new File(parameters.getOutputFile());
    }

    void writeFile() {

        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (this.file.exists()) {
            this.file.delete();
        }

        try (FileWriter fileWriter = new FileWriter(this.file.getAbsoluteFile())) {

            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, 1024 * 1024)) {

                Iterator<DataRecord> dataArrayIterator  = dataArray.iterator();

                while (dataArrayIterator.hasNext()) {

                    DataRecord dataRecord = dataArrayIterator.next();



                }

            } catch (IOException exception) {
                exception.printStackTrace();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }

    private String constructLine(DataRecord dataRecord) {

        String line = "";
        return line;

    }

}
