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

    Validator(IO io) {
        this.io = io;
    }

    String getString(String message) {
        this.io.print(message);
        return this.io.readNextLine();
    }

    int getInt(String message){
        this.io.print(message);
        return this.io.readInt();
    }

    boolean startConvertation(String message, String answer) {
        System.out.print(message);

        Boolean result = false;
        String answerResult = "";
        do {
            answerResult = io.readNextLine();
            if (!answerResult.isEmpty()) {
                result = answer.equals(answerResult);
                break;
            } else if (answerResult.isEmpty()) {
                io.print("Press \"y\" for start convertation or \"n\" for change parameters.");
            }
        } while (!answer.isEmpty());
        return result;
    }

    boolean exit(String message, String answer) {
        System.out.print(message);
        Boolean result = false;
        String answerResult = "";
        do {
            answerResult = io.readNextLine();
            if (!answerResult.isEmpty()) {
                result = answer.equals(answerResult);
                break;
            } else if (answerResult.isEmpty()) {
                io.print("Press \"y\" for continue or \"n\" for exit.");
            }
        } while (!answer.isEmpty());
        return result;
    }

    @Override
    public void close() throws IOException {

    }

}
