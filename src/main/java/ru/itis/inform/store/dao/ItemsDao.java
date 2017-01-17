package ru.itis.inform.store.dao;


import ru.itis.inform.store.dao.models.Item;

import java.io.IOException;

public interface ItemsDao {

    /**
     * Удаляет товар из хранилища
     * @param itemName
     */
    void delete(String itemName) throws IOException;

    /**
     * Возвращает описание товара из БД
     * @param itemName
     * @return
     */
    Item select(String itemName) throws IOException;

    /**
     * Adds an item to the storage
     * @param itemName
     */
    void add(String itemName, double price, int id) throws IOException;
}
