package ru.hfm.convertor;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Class for reading input data
 *
 * @author imataras
 * @since 06.04.2017
 */

class Reader {

    private Parameters parameters;
    private File file;
    private FileInputStream fileInputStream;
    private XSSFWorkbook xssfWorkbook;
    private DataRecord dataRecord;
    private List<DataRecord> dataArray;

    Reader() {

    }

    void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    private void setFilePath() {
        this.file = new File(this.parameters.getInputFile());
    }

    private boolean verifyFileExistence() {
        return this.file.exists();
    }

    private boolean canRead() {
        return this.file.canRead();
    }

    List<DataRecord> readFile() {

        this.dataArray = new ArrayList<DataRecord>();

        if (this.verifyFileExistence()) {

            if (this.canRead()) {

            } else if (!this.canRead()) {

            }

        } else if (!this.verifyFileExistence()) {

        }

        return this.dataArray;
    }

    private FileInputStream getFileInputStream() {

        try (FileInputStream fileInputStream = new FileInputStream(this.file)) {

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return fileInputStream;
    }

}
