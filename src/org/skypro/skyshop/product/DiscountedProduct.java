package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{

    protected int basePrice;
    protected int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        int price;
        price = (int) Math.round (basePrice * (1 - discount / 100.0));
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + getPrice() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
