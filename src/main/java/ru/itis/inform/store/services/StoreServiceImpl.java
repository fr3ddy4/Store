package ru.itis.inform.store.services;


import ru.itis.inform.store.dao.ItemsDao;

import java.io.IOException;

public class StoreServiceImpl implements StoreService {

    ItemsDao itemsDao;

    public StoreServiceImpl(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public void buy(String itemName) throws IOException {
        itemsDao.delete(itemName);
    }

    public boolean isExist(String itemName) throws IOException {
        return itemsDao.select(itemName) != null;
    }
}

