package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchTermComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthCompare = Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return o1.getSearchTerm().compareTo(o2.getSearchTerm());
    }
}
