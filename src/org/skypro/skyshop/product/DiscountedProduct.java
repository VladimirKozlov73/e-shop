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
        int price = 0;
        price = (int) Math.round (basePrice * (1 - discount / 100.0));
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return name + getPrice();
    }
}
