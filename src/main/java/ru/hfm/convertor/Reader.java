package ru.hfm.convertor;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


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
    private Map<Integer, FinancialDataType> financialDataMaping = new HashMap<Integer, FinancialDataType>();

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

        int firstRowNumber = parameters.getFirstRowNumber();
        int lastRowNumber = parameters.getLastRowNumber();

        this.setFinancialDataMaping();

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

                        DataRecord dataRecord = new DataRecord();

                        while (cellsIterator.hasNext()) {

                            Cell cell = cellsIterator.next();
                            CellType cellType = cell.getCellTypeEnum();

                            int currentCellNumber = cell.getColumnIndex();

                            FinancialDataType currentFinancialDataType = checkFinancialDataType(currentCellNumber);

                            if (currentFinancialDataType != FinancialDataType.NotFinancialDataType) {

                                this.setFieldValue(dataRecord, cell, cellType, currentFinancialDataType);

                                if (cellType.equals(CellType.BLANK)) {
                                    continue;
                                } else if (cellType.equals(CellType.STRING)) {

                                    stringBuilder.append(cell.getStringCellValue()).append(splitSymbol);
                                } else if (cellType.equals(CellType.NUMERIC)) {

                                    stringBuilder.append(cell.getNumericCellValue()).append(splitSymbol);
                                } else if (cellType.equals(CellType.FORMULA)) {

                                    stringBuilder.append(cell.getNumericCellValue()).append(splitSymbol);
                                }

                            } else if (currentFinancialDataType == FinancialDataType.NotFinancialDataType) {
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

    private void setFieldValue(DataRecord dataRecord, Cell cell, CellType cellType, FinancialDataType currentFinancialDataType) {

        if (currentFinancialDataType == FinancialDataType.SourceFMEntity) {

            dataRecord.setSourceFMEntity(cell.getStringCellValue());

        } else if (currentFinancialDataType == FinancialDataType.SourceFMAccount) {

            dataRecord.setSourceFMAccount(cell.getStringCellValue());

        } else if (currentFinancialDataType == FinancialDataType.SourceICP) {

            dataRecord.setSourceICP(cell.getStringCellValue());

        } else if (currentFinancialDataType == FinancialDataType.SourceCustom1) {

            dataRecord.setSourceCustom1(cell.getStringCellValue());

        } else if (currentFinancialDataType == FinancialDataType.SourceCustom2) {

            dataRecord.setSourceCustom2(cell.getStringCellValue());

        } else if (currentFinancialDataType == FinancialDataType.SourceCustom3) {

            dataRecord.setSourceCustom3(cell.getStringCellValue());

        } else if (currentFinancialDataType == FinancialDataType.SourceCustom4) {

            dataRecord.setSourceCustom4(cell.getStringCellValue());

        } else if (currentFinancialDataType == FinancialDataType.Amount) {

            Double doubleCellValue = cell.getNumericCellValue();
            BigDecimal bigDecimalCellValue = new BigDecimal(doubleCellValue.doubleValue()).setScale(0, RoundingMode.HALF_UP);
            dataRecord.setAmount(bigDecimalCellValue);

        }

    }

    private void setFinancialDataMaping() {

        this.financialDataMaping.put(parameters.getColumnNumberSourceFMEntity(), FinancialDataType.SourceFMEntity);
        this.financialDataMaping.put(parameters.getColumnNumberSourceFMAccount(), FinancialDataType.SourceFMAccount);
        this.financialDataMaping.put(parameters.getColumnNumberSourceICP(), FinancialDataType.SourceICP);
        this.financialDataMaping.put(parameters.getColumnNumberSourceCustom1(), FinancialDataType.SourceCustom1);
        this.financialDataMaping.put(parameters.getColumnNumberSourceCustom2(), FinancialDataType.SourceCustom2);
        this.financialDataMaping.put(parameters.getColumnNumberSourceCustom3(), FinancialDataType.SourceCustom3);
        this.financialDataMaping.put(parameters.getColumnNumberSourceCustom4(), FinancialDataType.SourceCustom4);
        this.financialDataMaping.put(parameters.getColumnNumberAmount(), FinancialDataType.Amount);

    }

    private FinancialDataType checkFinancialDataType(int currentCellNumber) {

        return this.financialDataMaping.getOrDefault(currentCellNumber, FinancialDataType.NotFinancialDataType);

    }

}
