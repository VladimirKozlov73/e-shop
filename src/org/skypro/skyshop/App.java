package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        Product bread = new Product("Хлеб", 54);
        Product milk = new Product("Молоко", 114);
        Product butter = new Product("Масло сливочное", 800);
        Product cheese = new Product("Сыр", 380);
        Product meat = new Product("Мясо", 450);
        Product pepper = new Product("Перец", 72);
        Product oil = new Product("Масло растительное", 124);

        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();
        ProductBasket basket3 = new ProductBasket();

        basket.add(bread);
        basket.add(butter);
        basket.add(milk);
        basket.add(meat);
        basket.add(cheese);

        basket2.add(bread);
        basket2.add(milk);
        basket2.add(meat);

        basket3.add(cheese);
        basket3.add(oil);

        System.out.println("Добавление продукта в заполненую корзину");
        basket.add(pepper);
        System.out.println();

        System.out.println("Печать содержимого корзины с несколькими товарами");
        basket2.printBasket();
        System.out.println();

        System.out.println("Получение стоимости корзины с несколькими товарами");
        System.out.println("Стоимость корзины " + basket3.totalCostOfTheBasket());
        System.out.println();

        System.out.println("Поиск товара, который есть в корзине");
        System.out.println(basket2.checkProduct("молоко"));
        System.out.println();

        System.out.println("Поиск товара, которого нет в корзине");
        System.out.println(basket3.checkProduct("молоко"));
        System.out.println();

        System.out.println("Очистка корзины basket");
        basket.clearBasket();
        System.out.println();

        System.out.println("Печать содержимого пустой корзины");
        basket.printBasket();
        System.out.println();

        System.out.println("Получение стоимости пустой корзины");
        System.out.println(basket.totalCostOfTheBasket());
        System.out.println();

        System.out.println("Поиск товара по имени в пустой корзине");
        System.out.println(basket.checkProduct("шоколад"));

    }
}