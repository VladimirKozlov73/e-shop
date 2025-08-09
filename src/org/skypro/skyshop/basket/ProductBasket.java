package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private final Map<String, List<Product>> basket;
    private int countSpecial;

    public ProductBasket() {
        basket = new HashMap<>();
        countSpecial = 0;
    }

    public void add(Product product) {
        String nameKey = product.getName().toLowerCase();
        basket.putIfAbsent(nameKey, new LinkedList<>());
        basket.get(nameKey).add(product);

        if (product.isSpecial()) {
            countSpecial++;
        }
    }

    public int totalCostOfTheBasket() {
        int totalCost = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто.");
        } else {
            for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
                for (Product product : entry.getValue()) {
                    System.out.println(product);
                }
            }
        }
        System.out.println("Итого: " + totalCostOfTheBasket());
        System.out.println("Специальных товаров: " + countSpecial);
    }

    public boolean checkProduct(String name) {
        return basket.containsKey(name.toLowerCase()) && !basket.get(name.toLowerCase()).isEmpty();
    }

    public void clearBasket() {
        basket.clear();
        countSpecial = 0;
    }

    public List<Product> removeProductsByName(String name) {
        String nameKey = name.toLowerCase();
        List<Product> removedProducts = basket.remove(nameKey);

        if (removedProducts == null) {
            return Collections.emptyList();
        }

        for (Product product : removedProducts) {
            if (product.isSpecial()) {
                countSpecial--;
            }
        }

        return removedProducts;
    }
}
