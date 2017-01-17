package ru.itis.inform.store.dao;

import ru.itis.inform.store.dao.models.Item;
import ru.itis.inform.store.services.StoreServiceImpl;

import java.io.IOException;

/**
 * Created by RuslanFarkhutdinov on 09.01.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StoreServiceImpl service = new StoreServiceImpl(new ItemsDaoFileBasedImpl());
        service.buy("Ball");
        System.out.println("Bought!");

    }
}
