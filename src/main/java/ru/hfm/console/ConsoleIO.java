package ru.hfm.console;

import java.io.PrintStream;
import java.util.Scanner;

/*
 * Implements IO interface
 *
 * @author imataras
 * @since 06.04.2017
 */

class ConsoleIO implements IO {

    private final Scanner scanner;
    private final PrintStream out;

    ConsoleIO(final Scanner scanner, final PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    @Override
    public String readNextLine() {
        return this.scanner.nextLine();
    }

    public int readInt() {
        return this.scanner.nextInt();
    }

    @Override
    public void println(String value) {
        this.out.println(value);
    }

    @Override
    public void print(String value) {
        this.out.print(value);
    }

}
