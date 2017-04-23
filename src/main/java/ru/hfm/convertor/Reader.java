package ru.hfm.convertor;

import java.io.File;
import java.io.IOException;

/*
 * Class for reading input data
 *
 * @author imataras
 * @since 06.04.2017
 */
class Reader {

    private Parameters parameters;
    private File file;
    private DataRecord dataRecord;

    Reader() {

    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public void setFilePath() {
        this.file = new File(this.parameters.getInputFile());
    }

    public boolean verifyFileExistence() {
        Boolean result = false;
        if (this.file.exists()) {
            result = true;
        } else if (!this.file.exists()) {
            result = false;
        }
        return result;
    }


}
