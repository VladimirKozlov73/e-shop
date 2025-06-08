package org.skypro.skyshop.product;

public class SimpleProduct extends Product{

    protected int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
