package ru.hfm.convertor;

import java.util.Comparator;

/*
 * Class implements data entity
 *
 * @author imataras
 * @since 01.06.2017
 */

class SourceFMAccountComparator implements Comparator<DataRecord> {

    SourceFMAccountComparator() {

    }

    @Override
    public int compare(DataRecord o1, DataRecord o2) {

        return o1.getSourceFMAccount().compareTo(o2.getSourceFMAccount());

    }

}
