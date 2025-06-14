package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        FixPriceProduct bread = new FixPriceProduct("Хлеб");
        SimpleProduct milk = new SimpleProduct("Молоко", 114);
        DiscountedProduct butter = new DiscountedProduct("Масло сливочное", 800, 15);
        SimpleProduct cheese = new SimpleProduct("Сыр", 380);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 450, 10);
        FixPriceProduct pepper = new FixPriceProduct("Перец");
        SimpleProduct oil = new SimpleProduct("Масло растительное", 124);

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