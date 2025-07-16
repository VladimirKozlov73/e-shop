package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws BestResultNotFound {

        FixPriceProduct bread = new FixPriceProduct("Хлеб");
        SimpleProduct milk = new SimpleProduct("Молоко", 114);
        DiscountedProduct butter = new DiscountedProduct("Масло сливочное", 800, 15);
        SimpleProduct cheese = new SimpleProduct("Сыр", 380);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 450, 10);
        FixPriceProduct pepper = new FixPriceProduct("Перец");
        SimpleProduct oil = new SimpleProduct("Масло растительное", 124);

        Article artCheese = new Article("Сыр Liebendorf", "Пищевая ценность на 100 г. : белки -25.0, жиры " +
                "- 25.0, углеводы - 0.0, 330.0 ккал.");
        Article artBread = new Article("Батон нарезной", "Пищевая ценность на 100 г. : белки -7.5, жиры - " +
                "2.9, углеводы - 51.4, 265.0 ккал.");
        Article artMilk = new Article("Молоко ЭкоНива", "Пищевая ценность на 100 г. : белки -7.5, жиры - "+
                "2.9, углеводы - 51.4, 265.0 ккал.");
        Article artButter = new Article("Масло сливочное 82.5%", "Пищевая ценность на 100 г. : белки -0.6," +
                " жиры - 82.5, углеводы - 0.8, 748.0 ккал.");
        Article artMeat = new Article("Окорок свиной", "Пищевая ценность на 100 г. : белки -18.0, жиры - " +
                "34.0, углеводы - 0.0, 330.0 ккал.");
        Article artPepper = new Article("Перец черный молотый", "Пищевая ценность на 100 г. : белки -0.0, " +
                "жиры - 0.0, углеводы - 0.0, 0.0 ккал.");

        SearchEngine sources = new SearchEngine();
        sources.addSearch(bread);
        sources.addSearch(milk);
        sources.addSearch(butter);
        sources.addSearch(cheese);
        sources.addSearch(meat);
        sources.addSearch(pepper);
        sources.addSearch(oil);
        sources.addSearch(artBread);
        sources.addSearch(artButter);
        sources.addSearch(artCheese);
        sources.addSearch(artMilk);
        sources.addSearch(artMeat);
        sources.addSearch(artPepper);

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
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите запрос: ");
        String desiredLine = scanner.nextLine();

        List<Searchable> searchResult = sources.search(desiredLine);

        for (Searchable searchable : searchResult) {
            if (searchResult.get(0) == null) {
                System.out.println("По данному запросу " + "\"" + desiredLine + "\"" + " ничего не найдено.");
                break;
            }
            if (searchable != null) {
                System.out.println(searchable.getStringRepresentation());
            }
        }

        try {
            FixPriceProduct blackBread = new FixPriceProduct("");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
        try {
            SimpleProduct greenOnions = new SimpleProduct("Зелёный лук", -75);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода цены продукта: " + e.getMessage());
        }
        try {
            DiscountedProduct salt = new DiscountedProduct("Соль", 50, -15);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода скидки на продукт: " + e.getMessage());
        }
        try {
            Article artSalt = new Article(null, "Пищевая ценность на 100 г. : белки -0.0, " +
                    "жиры - 0.0, углеводы - 0.0, 0.0 ккал.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка в имени статьи:" + e.getMessage());
        }
        try {
            Article artKetchup = new Article("Кетчуп", "     ");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка в тексте статьи: " + e.getMessage());
        }

        try {
            Searchable bestFind = sources.findBestMatch(desiredLine);
            System.out.println("Лучшее совпадение для '" + desiredLine + "': " + bestFind);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Список удаленных продуктов: " + basket2.removeProductsByName("молоко"));
        basket2.printBasket();
        System.out.println();
        List<Product> removedProducts = basket3.removeProductsByName("какао");
        if (removedProducts.isEmpty()){
            System.out.println("Список пуст");
        }
        basket3.printBasket();
    }
}