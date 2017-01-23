package ru.itis.inform.store.services;

import org.apache.log4j.PropertyConfigurator;
import ru.itis.inform.store.dao.ItemsDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class StoreServiceImpl implements StoreService {
    private Logger logger;
    private ItemsDao itemsDao;
    private File file;
    private BufferedReader reader;

    public StoreServiceImpl(ItemsDao itemsDao, String propertiesPath) {
        file = new File(propertiesPath);
        initializeReader();
        PropertyConfigurator.configure("src/main/java/ru/itis/inform/store/services/log4j.properties");
        logger = LoggerFactory.getLogger(StoreServiceImpl.class);
        try {
            this.itemsDao = (ItemsDao) Class.forName(reader.readLine()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buy(String itemName) {
        logger.info(itemName + " was bought.");
        itemsDao.delete(itemName);
    }

    public boolean isExist(String itemName) {
        logger.info(itemName + " was checked for existence.");
        return itemsDao.select(itemName) != null;
    }

    public void delete(String itemName) {
        logger.info(itemName + " was deleted.");
        itemsDao.delete(itemName);
    }

    private void initializeReader(){
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

