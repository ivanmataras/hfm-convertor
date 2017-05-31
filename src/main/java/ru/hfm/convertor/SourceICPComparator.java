package ru.hfm.convertor;

import java.util.Comparator;

/*
 * Class implements data entity
 *
 * @author imataras
 * @since 01.06.2017
 */

class SourceICPComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

}
