package ru.hfm.convertor;

/*
 * Class for normalizing input data
 *
 * @author imataras
 * @since 06.04.2017
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class Normalizer {

    private final String DEFAULT_SourceFMEntity_VALUE = new String("E29000");
    private final Integer DEFAULT_SourceFMAccount_VALUE = 0;
    private final String DEFAULT_SourceICP_VALUE = new String("[ICP None]");
    private final String DEFAULT_SourceCustom1_VALUE = new String("[None]");
    private final String DEFAULT_SourceCustom2_VALUE = new String("[None]");
    private final String DEFAULT_SourceCustom3_VALUE = new String("[None]");
    private final String DEFAULT_SourceCustom4_VALUE = new String("[None]");
    private final BigDecimal DEFAULT_Amount_VALUE = new BigDecimal(0).setScale(0, RoundingMode.HALF_UP);

    private List<DataRecord> dataArray;

    Normalizer() {

    }

    List<DataRecord> normalize() {

        return dataArray;
    }

    private void setDefaultValueForSourceFMEntity() {

    }

    private void setDefaultValueForSourceFMAccount() {

    }

    private void setDefaultValueForSourceICP() {

    }

    private void setDefaultValueForSourceCustom1() {

    }

    private void setDefaultValueForSourceCustom2() {

    }

    private void setDefaultValueForSourceCustom3() {

    }

    private void setDefaultValueForSourceCustom4() {

    }

    private void setDefaultValueForAmount() {

    }

}
