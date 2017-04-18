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


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Launcher(new Convertor(), new ConsoleIO(new Scanner(System.in), System.out)).start();
    }

}
