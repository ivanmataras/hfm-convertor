package ru.hfm.convertor;

import java.util.Comparator;

/*
 * Class implements SourceFMAccountSourceICPComparator comparator
 *
 * @author imataras
 * @since 20.06.2017
 */

public class SourceFMAccountSourceICPComparator implements Comparator<DataRecord> {

    SourceFMAccountSourceICPComparator() {

    }

    @Override
    public int compare(DataRecord o1, DataRecord o2) {

        int result = 0;

        int SourceFMAccountPosition = o1.getSourceFMAccount().compareTo(o2.getSourceFMAccount());
        int SourceICPPosition = o1.getSourceICP().compareTo(o2.getSourceICP());

        if (SourceFMAccountPosition == 0) {

            if(SourceICPPosition == 0) result = 0;
            else if(SourceICPPosition > 0) result = 1;
            else if (SourceICPPosition < 0) result = -1;

        } else if (SourceFMAccountPosition > 0) {

            if(SourceICPPosition == 0) result = 1;
            else if(SourceICPPosition > 0) result = 1;
            else if (SourceICPPosition < 0) result = 1;

        } else if (SourceFMAccountPosition < 0) {

            if(SourceICPPosition == 0) result = -1;
            else if(SourceICPPosition > 0) result = -1;
            else if (SourceICPPosition < 0) result = -1;

        }

        return result;

    }
}
