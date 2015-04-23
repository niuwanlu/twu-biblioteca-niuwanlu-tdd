package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by wlniu on 4/23/15.
 */
public class ItemList<T extends Item> {

    private ArrayList<T> items;

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

    public void showItemList() {
        System.out.println("======================== List ========================");
        for (T item : items) {
            if (item.isAvailable()) {
                item.printInfo();
            }
        }
        System.out.println("===========================================================");
    }

    public void showCheckedOutBookListWithPrompt() {
        showCheckedOutList();
        System.out.println("Please input the book number which you want to return. Input 0 to exit.");
    }

    public void showCheckedOutList() {
        System.out.println("===================== Checked Out List =====================");
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
}
