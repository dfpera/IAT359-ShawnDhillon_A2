package com.example.android.data.model;

public class DataItem {

    private int itemId;
    private String itemName;


    public DataItem() {
    }

    public DataItem(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
