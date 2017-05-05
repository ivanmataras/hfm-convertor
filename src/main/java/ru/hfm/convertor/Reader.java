package ru.hfm.convertor;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


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
    //private DataRecord dataRecord;
    private List<DataRecord> dataArray;
    private int[] columnsNumbersIdentityArray;

    Reader() {

    }

    Parameters getParameters() {
        return this.parameters;
    }

    void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    void setFile() {
        this.file = new File(parameters.getInputFile());
    }

    List<DataRecord> readFile() {

        this.dataArray = new ArrayList<DataRecord>();

        char splitSymbol = '\u0020';
//        int firstRowNumber = Integer.parseInt(parameters.getFirstRowNumber());
//        int lastRowNumber = Integer.parseInt(parameters.getLastRowNumber());

        int firstRowNumber = parameters.getFirstRowNumber();
        int lastRowNumber = parameters.getLastRowNumber();

        this.setColumnIdentityArray();

//        int columnNumberSourceFMEntity = parameters.getColumnNumberSourceFMEntity();
//        int columnNumberSourceFMAccount = parameters.getColumnNumberSourceFMAccount();
//        int columnNumberSourceICP = parameters.getColumnNumberSourceICP();
//        int columnNumberSourceCustom1 = parameters.getColumnNumberSourceCustom1();
//        int columnNumberSourceCustom2 = parameters.getColumnNumberSourceCustom2();
//        int columnNumberSourceCustom3 = parameters.getColumnNumberSourceCustom3();
//        int columnNumberSourceCustom4 = parameters.getColumnNumberSourceCustom4();
//        int columnNumberAmount = parameters.getColumnNumberAmount();

        StringBuilder stringBuilder = new StringBuilder(128);

        try (FileInputStream fileInputStream = new FileInputStream(this.file)) {

            try (XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream)) {

                Sheet sheet = workBook.getSheet(this.parameters.getSheetName());

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {

                    Row row = rowIterator.next();
                    Iterator<Cell> cellsIterator = row.iterator();

                    int currentRowNumber = row.getRowNum();

                    if (currentRowNumber >= firstRowNumber & currentRowNumber <= lastRowNumber) {

                        while (cellsIterator.hasNext()) {

                            Cell cell = cellsIterator.next();
                            CellType cellType = cell.getCellTypeEnum();

                            int currentCellNumber = cell.getColumnIndex();

                            if (checkColumnIdentity(currentCellNumber)) {

                                if (cellType.equals(CellType.BLANK)) {
                                    continue;
                                } else if (cellType.equals(CellType.STRING)) {

                                    stringBuilder.append(cell.getStringCellValue()).append(splitSymbol);
                                } else if (cellType.equals(CellType.NUMERIC)) {

                                    stringBuilder.append(cell.getNumericCellValue()).append(splitSymbol);
                                } else if (cellType.equals(CellType.FORMULA)) {

                                    stringBuilder.append(cell.getNumericCellValue()).append(splitSymbol);
                                }

                            } else if (checkColumnIdentity(currentCellNumber)) {
                                continue;
                            }

                        }

                        String stringRecord = new String(stringBuilder).trim();
                        System.out.println(stringRecord);
                        stringBuilder.delete(0, stringBuilder.length());

                    }
                }

            } catch (IOException exception) {
                exception.printStackTrace();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return this.dataArray;
    }

    private void setColumnIdentityArray() {

        this.columnsNumbersIdentityArray = new int[8];

        this.columnsNumbersIdentityArray[0] = parameters.getColumnNumberSourceFMEntity();
        this.columnsNumbersIdentityArray[1] = parameters.getColumnNumberSourceFMAccount();
        this.columnsNumbersIdentityArray[2] = parameters.getColumnNumberSourceICP();
        this.columnsNumbersIdentityArray[3] = parameters.getColumnNumberSourceCustom1();
        this.columnsNumbersIdentityArray[4] = parameters.getColumnNumberSourceCustom2();
        this.columnsNumbersIdentityArray[5] = parameters.getColumnNumberSourceCustom3();
        this.columnsNumbersIdentityArray[6] = parameters.getColumnNumberSourceCustom4();
        this.columnsNumbersIdentityArray[7] = parameters.getColumnNumberAmount();

    }

    private boolean checkColumnIdentity(int currentCellNumber) {

        boolean result = false;

        int searchResult = Arrays.binarySearch(this.columnsNumbersIdentityArray, currentCellNumber);

        if (searchResult >=0) result = true;
        else if(searchResult <0) result = false;

        return result;
    }

}
