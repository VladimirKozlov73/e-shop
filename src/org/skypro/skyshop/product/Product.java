package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected final String name;

    public Product (String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не должно быть пустым.");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name;
    }
    @Override
    public String getSearchTerm(){
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
