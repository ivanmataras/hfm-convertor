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
        this.setParameters(parameters);
        this.read();
    }

    private void read() {
        this.reader = new Reader(this.parameters.getInputFile());
        this.reader.setParameters(this.parameters);
        this.dataArray = this.reader.testReadFile();
    }

    private void normalize() {

    }

    private void validate() {

    }

    private void write() {

    }

    private Parameters getParameters() {
        return this.parameters;
    }

    private void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

}
