package org.skypro.skyshop.product.article;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {

    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return  name + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return name + " " + text;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return name;
    }
}
