package ru.itis.inform.store.dao;

import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.ArrayList;

public class ItemsDaoTsvBasedImpl implements ItemsDao {
    private BufferedReader reader;
    private PrintWriter writer;
    private String delimiter;
    private File file;
    private ArrayList<String> fileCopy = new ArrayList<String>();

    ItemsDaoTsvBasedImpl(String path) {
        delimiter = "   ";
        file = new File(path);
        textToStrList();
    }

    public void delete(String itemName) {
        initializeWriter();
        String current;
        for (String aFileCopy : fileCopy) {
            current = aFileCopy;
            String[] column = current.split(delimiter);
            if (!column[0].equals(itemName))
                writer.write(current);
        }
        writer.close();
    }

    public Item select(String itemName) {
        initializeWriter();
        for (String aFileCopy : fileCopy) {
            String[] columns = aFileCopy.split(delimiter);
            if (columns[0].equals(itemName)) {
                return new Item(columns[0], Double.valueOf(columns[1]), Integer.valueOf(columns[2]));
            }
        }
        return null;
    }

    private void textToStrList() {
        initializeReader();
        String current;
        try {
            while ((current = reader.readLine()) != null) {
                fileCopy.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(String itemName, double price, int id) {
        initializeWriter();
        writer.write("\n" + itemName + delimiter + price + delimiter + id);
        writer.close();
    }

    private void initializeReader() {
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initializeWriter() {
        try {
            writer = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
