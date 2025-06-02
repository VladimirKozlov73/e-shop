package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] basket;
    private int productCounter;

    public ProductBasket() {
        basket = new Product[5];
        productCounter = 0;
    }

    public void addProduct(Product product) {
        if (productCounter < 5) {
            basket[productCounter] = product;
            productCounter++;
        } else {
            System.out.println("Невозможно добавить продукт.");
        }
    }

    public int totalCostOfTheBasket() {
        int totalCost = 0;
        for (Product product : basket) {
            if(product != null) {
                totalCost += product.getProductPrice();
            }
        }
        return totalCost;
    }

    public void printBasket(){
        boolean basketIsEmpty = true;
        for (Product product : basket) {
                if (product != null) {
                    System.out.println(product);
                    basketIsEmpty = false;
                }
        }
        if (basketIsEmpty) {
            System.out.println("В корзине пусто");
        }
        System.out.println("Итого: " + totalCostOfTheBasket());
    }

    public boolean checkProduct(String name) {
        for (Product product : basket){
            if (product != null && product.getProductName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
    }
}
