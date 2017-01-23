package ru.itis.inform.store.dao;

import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class ItemsDaoCsvBasedImpl implements ItemsDao {
    private PrintWriter writer;
    private File file;
    private CSVReader csvReader;

    ItemsDaoCsvBasedImpl(String path) {
        file = new File(path);
        try {
            csvReader = new CSVReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(String itemName) {
        initializeWriter();
        String[] current;
        try {
            while ((current = csvReader.readNext()) != null) {
                if (!current[0].equals(itemName))
                    writer.write(Arrays.toString(current));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        writer.close();
    }

    public Item select(String itemName) {
        String[] current;
        try {
            while ((current = csvReader.readNext()) != null) {
                if (current[0].equals(itemName)) {
                    return new Item(current[0], Double.valueOf(current[1]), Integer.valueOf(current[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(String itemName, double price, int id) {
        initializeWriter();
        writer.write("\n" + itemName + "," + price + "," + id);
        writer.close();
    }


    private void initializeWriter() {
        try {
            writer = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
