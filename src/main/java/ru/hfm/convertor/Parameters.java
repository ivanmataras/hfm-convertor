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
    private String year;
    private String month;

    private String firstRowNumber;
    private String lastRowNumber;

    private String columnNumberSourceFMEntity;
    private String rowNumberSourceFMEntity;

    private String columnNumberSourceFMAccount;
    private String rowNumberSourceFMAccount;

    private String columnNumberSourceICP;
    private String rowNumberSourceICP;

    private String columnNumberSourceCustom1;
    private String rowNumberSourceCustom1;

    private String columnNumberSourceCustom2;
    private String rowNumberSourceCustom2;

    private String columnNumberSourceCustom3;
    private String rowNumberSourceCustom3;

    private String columnNumberSourceCustom4;
    private String rowNumberSourceCustom4;

    private String columnNumberAmount;
    private String rowNumberAmount;

    public Parameters() {

    }

    public String getFirstRowNumber() {
        return this.firstRowNumber;
    }

    public void setFirstRowNumber(String firstRowNumber) {
        this.firstRowNumber = firstRowNumber;
    }

    public String getLastRowNumber() {
        return this.lastRowNumber;
    }

    public void setLastRowNumber(String lastRowNumber) {
        this.lastRowNumber = lastRowNumber;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getColumnNumberSourceFMEntity() {
        return columnNumberSourceFMEntity;
    }

    public void setColumnNumberSourceFMEntity(String columnNumberSourceFMEntity) {
        this.columnNumberSourceFMEntity = columnNumberSourceFMEntity;
    }

    public String getRowNumberSourceFMEntity() {
        return rowNumberSourceFMEntity;
    }

    public void setRowNumberSourceFMEntity(String rowNumberSourceFMEntity) {
        this.rowNumberSourceFMEntity = rowNumberSourceFMEntity;
    }

    public String getColumnNumberSourceFMAccount() {
        return columnNumberSourceFMAccount;
    }

    public void setColumnNumberSourceFMAccount(String columnNumberSourceFMAccount) {
        this.columnNumberSourceFMAccount = columnNumberSourceFMAccount;
    }

    public String getRowNumberSourceFMAccount() {
        return rowNumberSourceFMAccount;
    }

    public void setRowNumberSourceFMAccount(String rowNumberSourceFMAccount) {
        this.rowNumberSourceFMAccount = rowNumberSourceFMAccount;
    }

    public String getColumnNumberSourceICP() {
        return columnNumberSourceICP;
    }

    public void setColumnNumberSourceICP(String columnNumberSourceICP) {
        this.columnNumberSourceICP = columnNumberSourceICP;
    }

    public String getRowNumberSourceICP() {
        return rowNumberSourceICP;
    }

    public void setRowNumberSourceICP(String rowNumberSourceICP) {
        this.rowNumberSourceICP = rowNumberSourceICP;
    }

    public String getColumnNumberSourceCustom1() {
        return columnNumberSourceCustom1;
    }

    public void setColumnNumberSourceCustom1(String columnNumberSourceCustom1) {
        this.columnNumberSourceCustom1 = columnNumberSourceCustom1;
    }

    public String getRowNumberSourceCustom1() {
        return rowNumberSourceCustom1;
    }

    public void setRowNumberSourceCustom1(String rowNumberSourceCustom1) {
        this.rowNumberSourceCustom1 = rowNumberSourceCustom1;
    }

    public String getColumnNumberSourceCustom2() {
        return columnNumberSourceCustom2;
    }

    public void setColumnNumberSourceCustom2(String columnNumberSourceCustom2) {
        this.columnNumberSourceCustom2 = columnNumberSourceCustom2;
    }

    public String getRowNumberSourceCustom2() {
        return rowNumberSourceCustom2;
    }

    public void setRowNumberSourceCustom2(String rowNumberSourceCustom2) {
        this.rowNumberSourceCustom2 = rowNumberSourceCustom2;
    }

    public String getColumnNumberSourceCustom3() {
        return columnNumberSourceCustom3;
    }

    public void setColumnNumberSourceCustom3(String columnNumberSourceCustom3) {
        this.columnNumberSourceCustom3 = columnNumberSourceCustom3;
    }

    public String getRowNumberSourceCustom3() {
        return rowNumberSourceCustom3;
    }

    public void setRowNumberSourceCustom3(String rowNumberSourceCustom3) {
        this.rowNumberSourceCustom3 = rowNumberSourceCustom3;
    }

    public String getColumnNumberSourceCustom4() {
        return columnNumberSourceCustom4;
    }

    public void setColumnNumberSourceCustom4(String columnNumberSourceCustom4) {
        this.columnNumberSourceCustom4 = columnNumberSourceCustom4;
    }

    public String getRowNumberSourceCustom4() {
        return rowNumberSourceCustom4;
    }

    public void setRowNumberSourceCustom4(String rowNumberSourceCustom4) {
        this.rowNumberSourceCustom4 = rowNumberSourceCustom4;
    }

    public String getColumnNumberAmount() {
        return columnNumberAmount;
    }

    public void setColumnNumberAmount(String columnNumberAmount) {
        this.columnNumberAmount = columnNumberAmount;
    }

    public String getRowNumberAmount() {
        return rowNumberAmount;
    }

    public void setRowNumberAmount(String rowNumberAmount) {
        this.rowNumberAmount = rowNumberAmount;
    }
}
