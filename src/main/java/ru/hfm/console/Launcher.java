package ru.hfm.console;

import ru.hfm.convertor.Convertor;

/*
 * Main class
 *
 * @author imataras
 * @since 06.04.2017
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Launcher {

    private final Convertor convertor;
    private final IO io;
    private final Map<String, String> parameters;

    private String inputFile;
    private String outputFile;

    private String sheetName;
    private String sectionName;
    private String scenario;
    private String year;
    private String month;

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


    public static void main(String[] args) {
        new Launcher(new Convertor(), new ConsoleIO(new Scanner(System.in), System.out)).start();
    }

    Launcher(Convertor convertor, IO io) {
        this.convertor = convertor;
        this.io = io;
        this.parameters = new HashMap<String, String>();
    }

    public void start() {

        System.out.println("HFM convertor version 1.0.0.0 has started");

            try (Validator validator = new Validator(io)) {

                do {

                    this.inputFile = validator.getString("Enter file path for input data");
                    this.outputFile = validator.getString("Enter file path for output data");
                    this.sheetName = validator.getString("Enter sheet name");
                    this.sectionName = validator.getString("Enter section name");
                    this.scenario = validator.getString("Enter scenario");
                    this.year = validator.getString("Enter year");
                    this.month = validator.getString("Enter month");

                    System.out.println("Enter cell adress for Source FM Entity");
                    this.columnNumberSourceFMEntity = validator.getString("Enter column number for Source FM Entity");
                    this.rowNumberSourceFMEntity = validator.getString("Enter row number for Source FM Entity");

                    System.out.println("Enter cell adress for Source FM Account");
                    String columnNumberSourceFMAccount = validator.getString("Enter column number for Source FM Account");
                    String rowNumberSourceFMAccount = validator.getString("Enter row number for Source FM Account");

                    System.out.println("Enter cell adress for Source ICP");
                    this.columnNumberSourceICP = validator.getString("Enter column number for Source ICP");
                    this.rowNumberSourceICP = validator.getString("Enter row number for Source ICP");

                    System.out.println("Enter cell adress for Source Custom1");
                    this.columnNumberSourceCustom1 = validator.getString("Enter column number for Source Custom1");
                    this.rowNumberSourceCustom1 = validator.getString("Enter row number for Source Custom1");

                    System.out.println("Enter cell adress for Source Custom2");
                    this.columnNumberSourceCustom2 = validator.getString("Enter column number for Source Custom2");
                    this.rowNumberSourceCustom2 = validator.getString("Enter row number for Source Custom2");

                    System.out.println("Enter cell adress for Source Custom3");
                    this.columnNumberSourceCustom3 = validator.getString("Enter column number for Source Custom3");
                    this.rowNumberSourceCustom3 = validator.getString("Enter row number for Source Custom3");

                    System.out.println("Enter cell adress for Source Custom4");
                    this.columnNumberSourceCustom4 = validator.getString("Enter column number for Source Custom4");
                    this.rowNumberSourceCustom4 = validator.getString("Enter row number for Source Custom4");

                    System.out.println("Enter cell adress for Amount");
                    this.columnNumberAmount = validator.getString("Enter column number for Amount");
                    this.rowNumberAmount = validator.getString("Enter row number for Amount");

                    packParameters();

                } while (validator.exit("Do you want to continue? (y)", "y"));

            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public void packParameters() {

        this.parameters.put("inputFile", this.inputFile);
        this.parameters.put("outputFile", this.outputFile);
        this.parameters.put("sheetName", this.sheetName);
        this.parameters.put("sectionName", this.sectionName);
        this.parameters.put("scenario", this.scenario);
        this.parameters.put("year", this.year);
        this.parameters.put("month", this.month);
        this.parameters.put("columnNumberSourceFMEntity", this.columnNumberSourceFMEntity);
        this.parameters.put("rowNumberSourceFMEntity", this.rowNumberSourceFMEntity);
        this.parameters.put("columnNumberSourceFMAccount", this.columnNumberSourceFMAccount);
        this.parameters.put("rowNumberSourceFMAccount", this.rowNumberSourceFMAccount);

        this.parameters.put("columnNumberSourceICP", this.columnNumberSourceICP);
        this.parameters.put("rowNumberSourceICP", this.rowNumberSourceICP);

        this.parameters.put("columnNumberSourceICP", this.columnNumberSourceICP);
        this.parameters.put("rowNumberSourceICP", this.rowNumberSourceICP);

        this.parameters.put("columnNumberSourceCustom1", this.columnNumberSourceCustom1);
        this.parameters.put("rowNumberSourceCustom1", this.rowNumberSourceCustom1);

        this.parameters.put("columnNumberSourceCustom2", this.columnNumberSourceCustom2);
        this.parameters.put("rowNumberSourceCustom2", this.rowNumberSourceCustom2);

        this.parameters.put("columnNumberSourceCustom3", this.columnNumberSourceCustom3);
        this.parameters.put("rowNumberSourceCustom3", this.rowNumberSourceCustom3);

        this.parameters.put("columnNumberSourceCustom4", this.columnNumberSourceCustom4);
        this.parameters.put("rowNumberSourceCustom4", this.rowNumberSourceCustom4);

        this.parameters.put("columnNumberAmount", this.columnNumberAmount);
        this.parameters.put("rowNumberAmount", this.rowNumberAmount);
    }

}
