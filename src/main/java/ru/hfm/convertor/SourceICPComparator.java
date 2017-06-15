package ru.hfm.convertor;

import java.util.Comparator;

/*
 * Class implements data entity
 *
 * @author imataras
 * @since 01.06.2017
 */

class SourceICPComparator implements Comparator<DataRecord> {

    SourceICPComparator() {

    }

    @Override
    public int compare(DataRecord o1, DataRecord o2) {

        return o1.getSourceICP().compareTo(o2.getSourceICP());

    }

}
