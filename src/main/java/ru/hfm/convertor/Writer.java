package ru.hfm.convertor;

/*
 * Class for writing output data
 *
 * @author imataras
 * @since 06.04.2017
 */

import java.io.File;
import java.util.List;

class Writer {

    private Parameters parameters;
    private File file;
    private List<DataRecord> dataArray;

    Writer(Parameters parameters, List<DataRecord> dataArray){
        this.parameters = parameters;
        this.dataArray = dataArray;
    }

    void setFile(){
        this.file = new File(parameters.getOutputFile());
    }

    void writeFile(){



    }


}
