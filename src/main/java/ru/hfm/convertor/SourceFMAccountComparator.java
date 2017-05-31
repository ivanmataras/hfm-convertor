package ru.hfm.convertor;

import java.util.Comparator;

/*
 * Class implements data entity
 *
 * @author imataras
 * @since 01.06.2017
 */

class SourceFMAccountComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

}
