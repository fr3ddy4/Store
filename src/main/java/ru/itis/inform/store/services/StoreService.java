package ru.itis.inform.store.services;


import java.io.IOException;

public interface StoreService {
    /**
     * Покупка товара по имени
     * @param itemName имя товара
     */
    void buy(String itemName) throws IOException;

    /**
     * Проверяет, есть ли товар на складе
     * @param itemName название товара
     * @return true - если товар найден,
     * false - в противном случае
     */
    boolean isExist(String itemName) throws IOException;
}
