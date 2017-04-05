package ru.hfm.console;

/*
 * Main Class
 *
 * @author imataras
 * @since 06.04.2017
 */

import ru.hfm.convertor.Convertor;

import java.util.Scanner;

public class Launcher {

    private final Convertor convertor;
    private final IO io;

    public Launcher(final Convertor convertor, final IO io) {
        this.convertor = convertor;
        this.io = io;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to th main menu");
        new Launcher(new Convertor(), new ConsoleIO(new Scanner(System.in), System.out));
    }

}
