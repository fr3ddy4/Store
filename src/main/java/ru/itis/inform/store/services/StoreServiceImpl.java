package ru.itis.inform.store.services;

import java.util.logging.*;

import ru.itis.inform.store.dao.ItemsDao;

public class StoreServiceImpl implements StoreService {

    private ItemsDao itemsDao;

    public StoreServiceImpl(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public void buy(String itemName) {
        itemsDao.delete(itemName);
    }

    public boolean isExist(String itemName) {
        return itemsDao.select(itemName) != null;
    }

    public void delete(String itemName) {
        itemsDao.delete(itemName);
    }
}

