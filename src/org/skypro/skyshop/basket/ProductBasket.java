package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

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
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто.");
        } else {
            basket.values().stream()
                    .flatMap(Collection::stream)
                    .forEach(System.out::println);
        }
        System.out.println("Итого: " + totalCostOfTheBasket());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private int getSpecialCount() {
        return (int) basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
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