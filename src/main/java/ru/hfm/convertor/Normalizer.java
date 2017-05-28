package ru.hfm.convertor;

/*
 * Class for normalizing input data
 *
 * @author imataras
 * @since 06.04.2017
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
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

    private final String DEFAULT_SourceCustom4_LOCSTAT_VALUE = new String("LOCSTAT");
    private final String DEFAULT_SourceCustom4_GAAPADJ_VALUE = new String("GAAPADJ");

    private Parameters parameters;
    private List<DataRecord> dataArray;

    Normalizer(Parameters parameters, List<DataRecord> dataArray) {
        this.parameters = parameters;
        this.dataArray = dataArray;
    }

    List<DataRecord> normalize() {

        this.setDefaultValueForSourceFMEntity();
        //this.setDefaultValueForSourceFMAccount();
        this.setDefaultValueForSourceICP();
        this.setDefaultValueForSourceCustom1();
        this.setDefaultValueForSourceCustom2();
        this.setDefaultValueForSourceCustom3();
        this.setDefaultValueForSourceCustom4();
        //this.setDefaultValueForAmount();
        return dataArray;
    }

    private void setDefaultValueForSourceFMEntity() {

        Iterator<DataRecord> dataArrayIterator = dataArray.iterator();

        while (dataArrayIterator.hasNext()) {
            DataRecord dataArrayEntity = dataArrayIterator.next();
            dataArrayEntity.setSourceFMEntity(this.DEFAULT_SourceFMEntity_VALUE);
        }

    }

    private void setDefaultValueForSourceFMAccount() {
        Iterator<DataRecord> dataArrayIterator = dataArray.iterator();
        while (dataArrayIterator.hasNext()) {
            DataRecord dataArrayEntity = dataArrayIterator.next();
            dataArrayEntity.setSourceFMAccount(this.DEFAULT_SourceFMAccount_VALUE);
        }
    }

    private void setDefaultValueForSourceICP() {
        Iterator<DataRecord> dataArrayIterator = dataArray.iterator();
        while (dataArrayIterator.hasNext()) {
            DataRecord dataArrayEntity = dataArrayIterator.next();
            dataArrayEntity.setSourceICP(this.DEFAULT_SourceICP_VALUE);
        }
    }

    private void setDefaultValueForSourceCustom1() {
        Iterator<DataRecord> dataArrayIterator = dataArray.iterator();
        while (dataArrayIterator.hasNext()) {
            DataRecord dataArrayEntity = dataArrayIterator.next();
            dataArrayEntity.setSourceCustom1(this.DEFAULT_SourceCustom1_VALUE);
        }
    }

    private void setDefaultValueForSourceCustom2() {
        Iterator<DataRecord> dataArrayIterator = dataArray.iterator();
        while (dataArrayIterator.hasNext()) {
            DataRecord dataArrayEntity = dataArrayIterator.next();
            dataArrayEntity.setSourceCustom2(this.DEFAULT_SourceCustom2_VALUE);
        }
    }

    private void setDefaultValueForSourceCustom3() {
        Iterator<DataRecord> dataArrayIterator = dataArray.iterator();
        while (dataArrayIterator.hasNext()) {
            DataRecord dataArrayEntity = dataArrayIterator.next();
            dataArrayEntity.setSourceCustom3(this.DEFAULT_SourceCustom3_VALUE);
        }
    }

    private void setDefaultValueForSourceCustom4() {
        Iterator<DataRecord> dataArrayIterator = dataArray.iterator();
        while (dataArrayIterator.hasNext()) {

            DataRecord dataArrayEntity = dataArrayIterator.next();

            if (parameters.getSectionName() == FinancialDataSection.BALANCE_LOCSTAT.toString()) {
                dataArrayEntity.setSourceCustom4(DEFAULT_SourceCustom4_LOCSTAT_VALUE);
            } else if (parameters.getSectionName() == FinancialDataSection.BALANCE_GAAPADJ.toString()) {
                dataArrayEntity.setSourceCustom4(DEFAULT_SourceCustom4_GAAPADJ_VALUE);
            } else if (parameters.getSectionName() == FinancialDataSection.INCOME_LOCSTAT.toString()) {
                dataArrayEntity.setSourceCustom4(DEFAULT_SourceCustom4_LOCSTAT_VALUE);
            } else if (parameters.getSectionName() == FinancialDataSection.INCOME_GAAPADJ.toString()) {
                dataArrayEntity.setSourceCustom4(DEFAULT_SourceCustom4_GAAPADJ_VALUE);
            } else if (parameters.getSectionName() == FinancialDataSection.ROLLFORWARD_LOCSTAT.toString()) {
                dataArrayEntity.setSourceCustom4(DEFAULT_SourceCustom4_LOCSTAT_VALUE);
            } else if (parameters.getSectionName() == FinancialDataSection.ROLLFORWARD_GAAPADJ.toString()) {
                dataArrayEntity.setSourceCustom4(DEFAULT_SourceCustom4_GAAPADJ_VALUE);
            }

        }
    }

    private void setDefaultValueForAmount() {
        Iterator<DataRecord> dataArrayIterator = dataArray.iterator();
        while (dataArrayIterator.hasNext()) {
            DataRecord dataArrayEntity = dataArrayIterator.next();
            dataArrayEntity.setAmount(this.DEFAULT_Amount_VALUE);
        }
    }

}
