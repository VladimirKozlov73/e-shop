package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return getName() + " тип " + getContentType();
    }

    String getName();
}
