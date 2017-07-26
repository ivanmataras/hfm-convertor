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
    private Normalizer normalizer;
    private Validator validator;
    private Writer writer;
    private List<DataRecord> dataArray;

    public Convertor() {

    }

    public void convert(Parameters parameters) {
        this.setParameters(parameters);
        this.read();
        this.normalize();
        this.validate();
        this.write();
    }

    private void read() {
        this.reader = new Reader();
        this.parameters.setFieldsToRead();
        this.reader.setParameters(this.parameters);
        this.reader.setFile();
        this.dataArray = this.reader.readFile();
    }

    private void normalize() {
        this.normalizer = new Normalizer(this.parameters, this.dataArray);
        this.dataArray = this.normalizer.normalize();
    }

    private void validate() {
        this.validator = new Validator(this.parameters, this.dataArray);
        this.dataArray = this.validator.validate();

    }

    private void write() {
        this.writer = new Writer(this.parameters, this.dataArray);

    }

    private Parameters getParameters() {
        return this.parameters;
    }

    private void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

}
