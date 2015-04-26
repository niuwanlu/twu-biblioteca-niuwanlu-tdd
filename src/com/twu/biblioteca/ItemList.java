package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by wlniu on 4/23/15.
 */
public class ItemList<T extends Item> {

    private ArrayList<T> items;

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public int getAmountOfItems() {
        return items.size();
    }

    public int getAmountOfAvailableItems() {
        int count = 0;
        for (T item : items) {
            if (item.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public void showItemList(String itemType) {
        System.out.println("======================== " + itemType + " List ========================");
        for (T item : items) {
            if (item.isAvailable()) {
                item.printInfo();
            }
        }
        System.out.println("===========================================================");
    }

    public void showCheckedOutListWithPrompt(String itemType) {
        showCheckedOutList();
        System.out.println("Please input the " + itemType + " number which you want to return. Input 0 to exit.");
    }

    public void showCheckedOutList() {
        System.out.println("======================= Checked Out List ========================");
        for (T item : items) {
            if (!item.isAvailable()) {
                item.printInfo();
            }
        }
        System.out.println("=================================================================");
    }

    public String getBookBorrower(int number) {
        return items.get(number).getBorrower();
    }

    public boolean isItemAvailable(int number) {
        return getItems().get(number-1).isAvailable();
    }

    public void setItemAvailable(int number, boolean available) {
        getItems().get(number-1).setAvailable(available);
    }

    public void setItemBorrower(int number, User user) {
        getItems().get(number-1).setBorrower(user.getUserName());
    }
}
