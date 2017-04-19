package ru.hfm.console;

import ru.hfm.convertor.Convertor;
import ru.hfm.convertor.Parameters;


/*
 * Main class
 *
 * @author imataras
 * @since 06.04.2017
 */


import java.util.Scanner;

public class Launcher {

    private Convertor convertor;
    private IO io;
    private Parameters parameters;

    public static void main(String[] args) {
        new Launcher(new Convertor(), new ConsoleIO(new Scanner(System.in), System.out), new Parameters()).start();
    }

    Launcher(Convertor convertor, IO io, Parameters parameters) {
        this.convertor = convertor;
        this.io = io;
        this.parameters = parameters;
    }

    public void start() {

        System.out.println("HFM convertor version 1.0.0.0 has started");

        try (Validator validator = new Validator(io)) {

            do {

                String inputFile = validator.getString("Enter file path for input data");
                this.parameters.setInputFile(inputFile);
                String outputFile = validator.getString("Enter file path for output data");
                this.parameters.setOutputFile(outputFile);

                String sheetName = validator.getString("Enter sheet name");
                this.parameters.setSheetName(sheetName);
                String sectionName = validator.getString("Enter section name");
                this.parameters.setSectionName(sectionName);
                String scenario = validator.getString("Enter scenario");
                this.parameters.setScenario(scenario);
                String year = validator.getString("Enter year");
                this.parameters.setYear(year);
                String month = validator.getString("Enter month");
                this.parameters.setMonth(month);

                System.out.println("Enter cell adress for Source FM Entity");
                String columnNumberSourceFMEntity = validator.getString("Enter column number for Source FM Entity");
                this.parameters.setColumnNumberSourceFMEntity(columnNumberSourceFMEntity);
                String rowNumberSourceFMEntity = validator.getString("Enter row number for Source FM Entity");
                this.parameters.setRowNumberSourceFMEntity(rowNumberSourceFMEntity);

                System.out.println("Enter cell adress for Source FM Account");
                String columnNumberSourceFMAccount = validator.getString("Enter column number for Source FM Account");
                this.parameters.setColumnNumberSourceFMAccount(columnNumberSourceFMAccount);
                String rowNumberSourceFMAccount = validator.getString("Enter row number for Source FM Account");
                this.parameters.setRowNumberSourceFMAccount(rowNumberSourceFMAccount);

                System.out.println("Enter cell adress for Source ICP");
                String columnNumberSourceICP = validator.getString("Enter column number for Source ICP");
                this.parameters.setColumnNumberSourceICP(columnNumberSourceICP);
                String rowNumberSourceICP = validator.getString("Enter row number for Source ICP");
                this.parameters.setRowNumberSourceICP(rowNumberSourceICP);

                System.out.println("Enter cell adress for Source Custom1");
                String columnNumberSourceCustom1 = validator.getString("Enter column number for Source Custom1");
                this.parameters.setColumnNumberSourceCustom1(columnNumberSourceCustom1);
                String rowNumberSourceCustom1 = validator.getString("Enter row number for Source Custom1");
                this.parameters.setRowNumberSourceCustom1(rowNumberSourceCustom1);

                System.out.println("Enter cell adress for Source Custom2");
                String columnNumberSourceCustom2 = validator.getString("Enter column number for Source Custom2");
                this.parameters.setColumnNumberSourceCustom2(columnNumberSourceCustom2);
                String rowNumberSourceCustom2 = validator.getString("Enter row number for Source Custom2");
                this.parameters.setRowNumberSourceCustom2(rowNumberSourceCustom2);

                System.out.println("Enter cell adress for Source Custom3");
                String columnNumberSourceCustom3 = validator.getString("Enter column number for Source Custom3");
                this.parameters.setColumnNumberSourceCustom3(columnNumberSourceCustom3);
                String rowNumberSourceCustom3 = validator.getString("Enter row number for Source Custom3");
                this.parameters.setRowNumberSourceCustom3(rowNumberSourceCustom3);

                System.out.println("Enter cell adress for Source Custom4");
                String columnNumberSourceCustom4 = validator.getString("Enter column number for Source Custom4");
                this.parameters.setColumnNumberSourceCustom4(columnNumberSourceCustom4);
                String rowNumberSourceCustom4 = validator.getString("Enter row number for Source Custom4");
                this.parameters.setRowNumberSourceCustom4(rowNumberSourceCustom4);

                System.out.println("Enter cell adress for Amount");
                String columnNumberAmount = validator.getString("Enter column number for Amount");
                this.parameters.setColumnNumberAmount(columnNumberAmount);
                String rowNumberAmount = validator.getString("Enter row number for Amount");
                this.parameters.setRowNumberAmount(rowNumberAmount);

                if (validator.startConversion("Do you want to start conversion", "y")) {
                    convertor.convert();
                }


            } while (validator.exit("Do you want to continue? (y)", "y"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
