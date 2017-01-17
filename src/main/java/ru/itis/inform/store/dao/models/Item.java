package ru.itis.inform.store.dao.models;

import com.google.common.base.MoreObjects;

public class Item {
    private String name;
    private int id;
    private double price;

    public Item(String name, double price, int id) {
        this.id = id;
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public int getId() {return id;}

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Item that = (Item)object;

        return this.name.equals(that.name) && this.price == that.price;

    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + (int)this.price;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Price", this.price)
                .add("Name", this.name)
                .toString();
    }
}
