package ru.hfm.console;

import javax.swing.text.StyledEditorKit;
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

    public boolean startConvertation(String message, String answer) {
        System.out.print(message);

        Boolean result = false;
        String answerResult = "";
        do {
            answerResult = io.readNextLine();
            if (!answerResult.isEmpty()) {
                result = answer.equals(answerResult);
                break;
            } else if (answerResult.isEmpty()) {
                System.out.print("Press \"y\" for start convertation or \"n\" for change parameters.");
            }
        } while (!answer.isEmpty());
        return result;
    }

    public boolean exit(String message, String answer) {
        System.out.print(message);
        Boolean result = false;
        String answerResult = "";
        do {
            answerResult = io.readNextLine();
            if (!answerResult.isEmpty()) {
                result = answer.equals(answerResult);
                break;
            } else if (answerResult.isEmpty()) {
                System.out.print("Press \"y\" for continue or \"n\" for exit.");
            }
        } while (!answer.isEmpty());
        return result;
    }

    @Override
    public void close() throws IOException {

    }

}
