package ru.itis.inform.store.dao;

import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.ArrayList;

public class ItemsDaoFileBasedImpl implements ItemsDao {
    private BufferedReader reader;
    private PrintWriter writer;
    private File file = new File("src/main/java/ru/itis/inform/store/dao/Items.csv");
    private ArrayList<String> fileCopy = new ArrayList<String>();

    public void delete(String itemName) {
        try {
            if (fileCopy.size() == 0)
                textToStrList();
            initializeWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String current;
        for (String aFileCopy : fileCopy) {
            current = aFileCopy;
            String[] column = current.split(",");
            if (!column[0].equals(itemName))
                writer.write(current);
        }
        writer.close();
    }

    public Item select(String itemName) {
        try {
            if (fileCopy == null)
                textToStrList();
            initializeWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String aFileCopy : fileCopy) {
            String[] columns = aFileCopy.split(",");
            if (columns[0].equals(itemName)) {
                return new Item(columns[0], Double.valueOf(columns[1]), Integer.valueOf(columns[2]));
            }
        }
        return null;
    }

    private void textToStrList() throws IOException {
        try {
            initializeReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String current;
        while ((current = reader.readLine()) != null) {
            fileCopy.add(current);
        }
    }

    public void add(String itemName, double price, int id) throws IOException {
        initializeWriter();
        writer.write("\n" + itemName + "," + price + "," + id);
        writer.close();
    }

    private void initializeReader() throws IOException {
        reader = new BufferedReader(new FileReader(file));
    }

    private void initializeWriter() throws IOException {
        writer = new PrintWriter(new FileWriter(file));
    }
}
