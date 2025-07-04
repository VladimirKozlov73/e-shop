package org.skypro.skyshop.exception;

public class BestResultNotFound extends Exception{

    public BestResultNotFound(String search) {
        super("Лучший результат не найден для запроса: " + '\"' + search + '\"');
    }
}
