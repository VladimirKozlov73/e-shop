package org.skypro.skyshop.product.article;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {

    private final String name;
    private final String text;

    public Article(String name, String text) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название статьи не должно быть пустым.");
        }
        this.name = name;
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Текст статьи не может быть пустым.");
        }
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
