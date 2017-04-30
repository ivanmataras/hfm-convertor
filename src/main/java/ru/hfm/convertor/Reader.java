package ru.hfm.convertor;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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


    Reader(String inputFile) {
        this.file = new File(inputFile);
    }

    Parameters getParameters() {
        return this.parameters;
    }

    void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    List<DataRecord> testReadFile() {

        this.dataArray = new ArrayList<DataRecord>();

        char splitSymbol = '\u0020';
        StringBuilder stringBuilder = new StringBuilder(128);

        try (FileInputStream fileInputStream = new FileInputStream(this.file)) {

            try (XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream)) {

                Sheet sheet = workBook.getSheet(this.parameters.getSheetName());

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {

                    Row row = rowIterator.next();
                    Iterator<Cell> cellsIterator = row.iterator();

                    while (cellsIterator.hasNext()) {

                        Cell cell = cellsIterator.next();
                        CellType cellType = cell.getCellTypeEnum();

                        if (cellType.equals(CellType.BLANK)) {
                            continue;
                        } else if (cellType.equals(CellType.STRING)) {

                            stringBuilder.append(cell.getStringCellValue()).append(splitSymbol);
                        } else if (cellType.equals(CellType.NUMERIC)) {

                            stringBuilder.append(cell.getNumericCellValue()).append(splitSymbol);
                        } else if (cellType.equals(CellType.FORMULA)) {

                            stringBuilder.append(cell.getNumericCellValue()).append(splitSymbol);
                        }
                    }

                    String stringRecord = new String(stringBuilder).trim();
                    System.out.println(stringRecord);
                    stringBuilder.delete(0, stringBuilder.length());

                }

            } catch (IOException exception) {
                exception.printStackTrace();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return this.dataArray;
    }

    List<DataRecord> readFile() {

        this.dataArray = new ArrayList<DataRecord>();

        char splitSymbol = '\u0020';
        StringBuilder stringBuilder = new StringBuilder(128);

        try (FileInputStream fileInputStream = new FileInputStream(this.file)) {

            try (XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream)) {

                Sheet sheet = workBook.getSheet(this.parameters.getSheetName());

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {

                    Row row = rowIterator.next();
                    Iterator<Cell> cellsIterator = row.iterator();

                    while (cellsIterator.hasNext()) {

                        Cell cell = cellsIterator.next();
                        CellType cellType = cell.getCellTypeEnum();

                        if (cellType.equals(CellType.BLANK)) {
                            continue;
                        } else if (cellType.equals(CellType.STRING)) {

                            stringBuilder.append(cell.getStringCellValue()).append(splitSymbol);
                        } else if (cellType.equals(CellType.NUMERIC)) {

                            stringBuilder.append(cell.getNumericCellValue()).append(splitSymbol);
                        } else if (cellType.equals(CellType.FORMULA)) {

                            stringBuilder.append(cell.getNumericCellValue()).append(splitSymbol);
                        }
                    }

                    String stringRecord = new String(stringBuilder).trim();
                    System.out.println(stringRecord);
                    stringBuilder.delete(0, stringBuilder.length());

                }

            } catch (IOException exception) {
                exception.printStackTrace();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return this.dataArray;
    }

}
