package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] basket;
    private int counter;
    private int countSpecial;

    public ProductBasket() {
        basket = new Product[5];
        counter = 0;
        countSpecial = 0;
    }

    public void add(Product product) {
        if (counter < basket.length) {
            basket[counter++] = product;
            if (product.isSpecial()) {
                countSpecial++;
            }
        } else {
            System.out.println("Невозможно добавить продукт.");
        }
    }

    public int totalCostOfTheBasket() {
        int totalCost = 0;
        for (int i = 0; i < counter; i++) {
            totalCost += basket[i].getPrice();
        }
        return totalCost;
    }

    public void printBasket(){
        boolean basketIsEmpty = true;
        for (int i = 0; i < counter; i++) {
            System.out.println(basket[i]);
            basketIsEmpty = false;
        }
        if (basketIsEmpty) {
            System.out.println("В корзине пусто.");
        }
        System.out.println("Итого: " + totalCostOfTheBasket());
        System.out.println("Специальных товаров: " + countSpecial);
    }

    public boolean checkProduct(String name) {
        for (int i = 0; i < counter; i++){
            if (basket[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < counter; i++) {
            basket[i] = null;
        }
        counter = 0;
        countSpecial = 0;
    }
}
