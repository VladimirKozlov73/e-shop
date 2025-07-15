package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private final LinkedList<Product> basket;
    private int countSpecial;

    public ProductBasket() {
        basket = new LinkedList<>();
        countSpecial = 0;
    }

    public void add(Product product) {
        basket.add(product);
        if (product.isSpecial()) {
            countSpecial++;
        }
    }

    public int totalCostOfTheBasket() {
        int totalCost = 0;
        for (Product product : basket) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    public void printBasket(){
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто.");
        } else {
            for (Product product : basket) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + totalCostOfTheBasket());
        System.out.println("Специальных товаров: " + countSpecial);
    }

    public boolean checkProduct(String name) {
        for (Product product : basket){
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
        countSpecial = 0;
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                removedProducts.add(product);
                if (product.isSpecial()) {
                    countSpecial--;
                }
            }
        }
        return removedProducts;
    }
}
