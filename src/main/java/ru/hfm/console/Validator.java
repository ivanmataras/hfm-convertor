package ru.hfm.console;

import java.io.Closeable;
import java.io.IOException;

/*
 * TODO - comment
 *
 * @author imataras
 * @since 06.04.2017
 */

class Validator implements Closeable {

    private IO io;

    public Validator(IO io) {
        this.io = io;
    }

    public String getString(String message) {
        System.out.print(message);
        return this.io.readNextLine();
    }

    public boolean startConversion(String message, String answer) {
        System.out.print(message);
        return answer.equals(io.readNextLine());
    }

    public boolean exit(String message, String answer) {
        System.out.print(message);
        return answer.equals(io.readNextLine());
    }

    @Override
    public void close() throws IOException {

    }

}
