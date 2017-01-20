package ru.itis.inform.store.dao;

import ru.itis.inform.store.services.StoreServiceImpl;

import java.io.IOException;

/**
 * Created by RuslanFarkhutdinov on 09.01.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StoreServiceImpl service = new StoreServiceImpl(new ItemsDaoCsvBasedImpl("src/main/java/ru/itis/inform/store/dao/Items.csv", ","));
        //StoreServiceImpl service1 = new StoreServiceImpl(new ItemsDaoTsvBasedImpl("src/main/java/ru/itis/inform/store/dao/Items.tsv"));
        service.buy("Ball");
        System.out.println("Bought!");

    }
}
