package ru.hfm.console;

import java.io.PrintStream;
import java.util.Scanner;

/*
 * Implements IO interface
 *
 * @author imataras
 * @since 06.04.2017
 */

public class ConsoleIO implements IO {

    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleIO(final Scanner scanner, final PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    @Override
    public String read() {
        return null;
    }

    @Override
    public void println(Object value) {

    }

}
