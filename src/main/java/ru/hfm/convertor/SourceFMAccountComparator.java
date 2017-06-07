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

        int result = 0;

        if (o1.getSourceFMAccount() > o2.getSourceFMAccount()) {
            result = 1;
        } else if (o1.getSourceFMAccount() < o2.getSourceFMAccount()) {
            result = -1;
        } else if (o1.getSourceFMAccount() == o2.getSourceFMAccount()) {
            result = 0;
        }

        return result;

    }

}
