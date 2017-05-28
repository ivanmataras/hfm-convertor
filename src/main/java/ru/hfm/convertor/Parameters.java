package ru.hfm.convertor;

/**
 * Class for store and manipulate convertor's parameters
 *
 * @author imataras
 * @since 19.04.2017
 */

public class Parameters {

    private String inputFile;
    private String outputFile;

    private String sheetName;
    private String sectionName;
    private String scenario;
    private int year;
    private int month;

    private int firstRowNumber;
    private int lastRowNumber;

    private int columnNumberSourceFMEntity;
    private int rowNumberSourceFMEntity;

    private int columnNumberSourceFMAccount;
    private int rowNumberSourceFMAccount;

    private int columnNumberSourceICP;
    private int rowNumberSourceICP;

    private int columnNumberSourceCustom1;
    private int rowNumberSourceCustom1;

    private int columnNumberSourceCustom2;
    private int rowNumberSourceCustom2;

    private int columnNumberSourceCustom3;
    private int rowNumberSourceCustom3;

    private int columnNumberSourceCustom4;
    private int rowNumberSourceCustom4;

    private int columnNumberAmount;
    private int rowNumberAmount;

    private boolean readSourceFMEntity;
    private boolean readSourceFMAccount;
    private boolean readSourceICP;
    private boolean readSourceCustom1;
    private boolean readSourceCustom2;
    private boolean readSourceCustom3;
    private boolean readSourceCustom4;
    private boolean readAmount;

    public Parameters() {

    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getFirstRowNumber() {
        return firstRowNumber;
    }

    public void setFirstRowNumber(int firstRowNumber) {
        this.firstRowNumber = firstRowNumber;
    }

    public int getLastRowNumber() {
        return lastRowNumber;
    }

    public void setLastRowNumber(int lastRowNumber) {
        this.lastRowNumber = lastRowNumber;
    }

    public int getColumnNumberSourceFMEntity() {
        return columnNumberSourceFMEntity;
    }

    public void setColumnNumberSourceFMEntity(int columnNumberSourceFMEntity) {
        this.columnNumberSourceFMEntity = columnNumberSourceFMEntity;
    }

    public int getRowNumberSourceFMEntity() {
        return rowNumberSourceFMEntity;
    }

    public void setRowNumberSourceFMEntity(int rowNumberSourceFMEntity) {
        this.rowNumberSourceFMEntity = rowNumberSourceFMEntity;
    }

    public int getColumnNumberSourceFMAccount() {
        return columnNumberSourceFMAccount;
    }

    public void setColumnNumberSourceFMAccount(int columnNumberSourceFMAccount) {
        this.columnNumberSourceFMAccount = columnNumberSourceFMAccount;
    }

    public int getRowNumberSourceFMAccount() {
        return rowNumberSourceFMAccount;
    }

    public void setRowNumberSourceFMAccount(int rowNumberSourceFMAccount) {
        this.rowNumberSourceFMAccount = rowNumberSourceFMAccount;
    }

    public int getColumnNumberSourceICP() {
        return columnNumberSourceICP;
    }

    public void setColumnNumberSourceICP(int columnNumberSourceICP) {
        this.columnNumberSourceICP = columnNumberSourceICP;
    }

    public int getRowNumberSourceICP() {
        return rowNumberSourceICP;
    }

    public void setRowNumberSourceICP(int rowNumberSourceICP) {
        this.rowNumberSourceICP = rowNumberSourceICP;
    }

    public int getColumnNumberSourceCustom1() {
        return columnNumberSourceCustom1;
    }

    public void setColumnNumberSourceCustom1(int columnNumberSourceCustom1) {
        this.columnNumberSourceCustom1 = columnNumberSourceCustom1;
    }

    public int getRowNumberSourceCustom1() {
        return rowNumberSourceCustom1;
    }

    public void setRowNumberSourceCustom1(int rowNumberSourceCustom1) {
        this.rowNumberSourceCustom1 = rowNumberSourceCustom1;
    }

    public int getColumnNumberSourceCustom2() {
        return columnNumberSourceCustom2;
    }

    public void setColumnNumberSourceCustom2(int columnNumberSourceCustom2) {
        this.columnNumberSourceCustom2 = columnNumberSourceCustom2;
    }

    public int getRowNumberSourceCustom2() {
        return rowNumberSourceCustom2;
    }

    public void setRowNumberSourceCustom2(int rowNumberSourceCustom2) {
        this.rowNumberSourceCustom2 = rowNumberSourceCustom2;
    }

    public int getColumnNumberSourceCustom3() {
        return columnNumberSourceCustom3;
    }

    public void setColumnNumberSourceCustom3(int columnNumberSourceCustom3) {
        this.columnNumberSourceCustom3 = columnNumberSourceCustom3;
    }

    public int getRowNumberSourceCustom3() {
        return rowNumberSourceCustom3;
    }

    public void setRowNumberSourceCustom3(int rowNumberSourceCustom3) {
        this.rowNumberSourceCustom3 = rowNumberSourceCustom3;
    }

    public int getColumnNumberSourceCustom4() {
        return columnNumberSourceCustom4;
    }

    public void setColumnNumberSourceCustom4(int columnNumberSourceCustom4) {
        this.columnNumberSourceCustom4 = columnNumberSourceCustom4;
    }

    public int getRowNumberSourceCustom4() {
        return rowNumberSourceCustom4;
    }

    public void setRowNumberSourceCustom4(int rowNumberSourceCustom4) {
        this.rowNumberSourceCustom4 = rowNumberSourceCustom4;
    }

    public int getColumnNumberAmount() {
        return columnNumberAmount;
    }

    public void setColumnNumberAmount(int columnNumberAmount) {
        this.columnNumberAmount = columnNumberAmount;
    }

    public int getRowNumberAmount() {
        return rowNumberAmount;
    }

    public void setRowNumberAmount(int rowNumberAmount) {
        this.rowNumberAmount = rowNumberAmount;
    }

    public boolean isReadSourceFMEntity() {
        return readSourceFMEntity;
    }

    public void setReadSourceFMEntity(boolean readSourceFMEntity) {
        this.readSourceFMEntity = readSourceFMEntity;
    }

    public boolean isReadSourceFMAccount() {
        return readSourceFMAccount;
    }

    public void setReadSourceFMAccount(boolean readSourceFMAccount) {
        this.readSourceFMAccount = readSourceFMAccount;
    }

    public boolean isReadSourceICP() {
        return readSourceICP;
    }

    public void setReadSourceICP(boolean readSourceICP) {
        this.readSourceICP = readSourceICP;
    }

    public boolean isReadSourceCustom1() {
        return readSourceCustom1;
    }

    public void setReadSourceCustom1(boolean readSourceCustom1) {
        this.readSourceCustom1 = readSourceCustom1;
    }

    public boolean isReadSourceCustom2() {
        return readSourceCustom2;
    }

    public void setReadSourceCustom2(boolean readSourceCustom2) {
        this.readSourceCustom2 = readSourceCustom2;
    }

    public boolean isReadSourceCustom3() {
        return readSourceCustom3;
    }

    public void setReadSourceCustom3(boolean readSourceCustom3) {
        this.readSourceCustom3 = readSourceCustom3;
    }

    public boolean isReadSourceCustom4() {
        return readSourceCustom4;
    }

    public void setReadSourceCustom4(boolean readSourceCustom4) {
        this.readSourceCustom4 = readSourceCustom4;
    }

    public boolean isReadAmount() {
        return readAmount;
    }

    public void setReadAmount(boolean readAmount) {
        this.readAmount = readAmount;
    }

    public void setFieldsToRead() {

        this.setReadSourceFMEntity(false);
        this.setReadSourceFMAccount(true);
        this.setReadSourceICP(true);
        this.setReadSourceCustom1(false);
        this.setReadSourceCustom2(false);
        this.setReadSourceCustom3(false);
        this.setReadSourceCustom4(false);
        this.setReadAmount(true);

    }
}
