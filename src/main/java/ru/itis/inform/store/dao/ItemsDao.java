package ru.itis.inform.store.dao;


import ru.itis.inform.store.dao.models.Item;

public interface ItemsDao {

    /**
     * Удаляет товар из хранилища
     * @param itemName название товара
     */
    void delete(String itemName);

    /**
     * Возвращает описание товара из БД
     * @param itemName название товара
     * @return объект типа Item
     */
    Item select(String itemName);

    /**
     * Adds an item to the storage
     * @param itemName название товара
     */
    void add(String itemName, double price, int id);
}
