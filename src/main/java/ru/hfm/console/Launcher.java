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

    Launcher(Convertor convertor, IO io) {
        this.convertor = convertor;
        this.io = io;
        this.parameters = new HashMap<String, String>();
    }

    public void start() {

        System.out.println("HFM convertor version 1.0.0.0 has started");

            try (Validator validator = new Validator(io)) {

                do {

                    String inputFile = validator.getString("Enter file path for input data");
                    String outputFile = validator.getString("Enter file path for output data");
                    String sheetName = validator.getString("Enter sheet name");
                    String sectionName = validator.getString("Enter section name");
                    String scenario = validator.getString("Enter scenario");
                    String year = validator.getString("Enter year");
                    String month = validator.getString("Enter month");

                    System.out.println("Enter cell adress for Source FM Entity");
                    String columnNumberSourceFMEntity = validator.getString("Enter column number for Source FM Entity");
                    String rowNumberSourceFMEntity = validator.getString("Enter row number for Source FM Entity");

                    System.out.println("Enter cell adress for Source FM Account");
                    String columnNumberSourceFMAccount = validator.getString("Enter column number for Source FM Account");
                    String rowNumberSourceFMAccount = validator.getString("Enter row number for Source FM Account");

                    System.out.println("Enter cell adress for Source ICP");
                    String columnNumberSourceICP = validator.getString("Enter column number for Source ICP");
                    String rowNumberSourceICP = validator.getString("Enter row number for Source ICP");

                    System.out.println("Enter cell adress for Source Custom1");
                    String columnNumberSourceCustom1 = validator.getString("Enter column number for Source Custom1");
                    String rowNumberSourceCustom1 = validator.getString("Enter row number for Source Custom1");

                    System.out.println("Enter cell adress for Source Custom2");
                    String columnNumberSourceCustom2 = validator.getString("Enter column number for Source Custom2");
                    String rowNumberSourceCustom2 = validator.getString("Enter row number for Source Custom2");

                    System.out.println("Enter cell adress for Source Custom3");
                    String columnNumberSourceCustom3 = validator.getString("Enter column number for Source Custom3");
                    String rowNumberSourceCustom3 = validator.getString("Enter row number for Source Custom3");

                    System.out.println("Enter cell adress for Source Custom4");
                    String columnNumberSourceCustom4 = validator.getString("Enter column number for Source Custom4");
                    String rowNumberSourceCustom4 = validator.getString("Enter row number for Source Custom4");

                    System.out.println("Enter cell adress for Amount");
                    String columnNumberAmount = validator.getString("Enter column number for Amount");
                    String rowNumberAmount = validator.getString("Enter row number for Amount");



                } while (validator.exit("Do you want to continue? (y)", "y"));

            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) {
        new Launcher(new Convertor(), new ConsoleIO(new Scanner(System.in), System.out)).start();
    }

}
