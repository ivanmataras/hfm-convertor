package ru.hfm.convertor;

/*
 * Main convertor class
 *
 * @author imataras
 * @since 06.04.2017
 */

public class Convertor {

    private Parameters parameters;
    private Reader reader;
    //private Normalizer normalizer;
    //private Validator validator;
    //private Writer writer;

    public Convertor() {
        this.reader = new Reader();
    }

    public void convert(Parameters parameters) {
        System.out.println("Hello i am convertor!");
        this.setParameters(parameters);

        this.read();
    }

    private void read() {

        this.reader.setParameters(this.parameters);
        Boolean fileExists = false;
        Boolean canRead = false;

        fileExists = this.reader.verifyFileExistence();

        if (fileExists) {

            if (canRead) {

            } else if (!canRead) {

            }

        } else if (!fileExists) {

        }

    }

    private void normalize() {

    }

    private void validate() {

    }

    private void write() {

    }

    private void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

}
