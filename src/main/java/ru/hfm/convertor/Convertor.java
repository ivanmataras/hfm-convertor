package ru.hfm.convertor;

/*
 * Main convertor class
 *
 * @author imataras
 * @since 06.04.2017
 */

import java.util.List;

public class Convertor {

    private Parameters parameters;
    private Reader reader;
    //private Normalizer normalizer;
    //private Validator validator;
    //private Writer writer;
    private List<DataRecord> dataArray;

    public Convertor() {

    }

    public void convert(Parameters parameters) {
        System.out.println("Hello i am convertor!");
        this.setParameters(parameters);
        this.read();
    }

    private void read() {

        this.reader = new Reader();
        this.reader.setParameters(this.parameters);
        this.dataArray = this.reader.readFile();

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
