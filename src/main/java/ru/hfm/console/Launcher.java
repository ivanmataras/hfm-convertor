package ru.hfm.console;

import ru.hfm.convertor.Convertor;

/*
 * Main class
 *
 * @author imataras
 * @since 06.04.2017
 */

import java.util.Scanner;

public class Launcher {

    private final Convertor convertor;
    private final IO io;

    Launcher(final Convertor convertor, final IO io) {
        this.convertor = convertor;
        this.io = io;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to th main menu");
        new Launcher(new Convertor(), new ConsoleIO(new Scanner(System.in), System.out));
    }

}
