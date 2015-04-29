package com.twu.biblioteca;

import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wlniu on 4/23/15.
 */
public class ItemList<T extends Item> {

    private final Scanner scanner = new Scanner(System.in);

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

    public void showItemList() {
        String itemType = getItemType();
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

    void checkOutItem(User user) {
        String itemType = getItemType();
        showItemListWithCheckOutNote(itemType);
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                return;
            } else if (number > 0 && number <= getAmountOfItems() && isItemAvailable(number)) {
                successfulCheckOutItem(itemType, number, user);
            } else {
                unsuccessfulCheckOutItem(itemType);
            }
        }
    }

    void showItemListWithCheckOutNote(String itemType) {
        showItemList();
        System.out.println("Please choose the " + itemType + " number which you want to check out. Input 0 to exit.");
    }

    public void successfulCheckOutItem(String itemType, int number, User user) {
        setItemAvailable(number, false);
        setItemBorrower(number, user);
        System.out.println("Thank you! Enjoy the " + itemType + ".");
        showItemListWithCheckOutNote(itemType);
    }

    public void unsuccessfulCheckOutItem(String itemType) {
        System.out.println("That movie is not available. Please check out other b movies.");
        showItemListWithCheckOutNote(itemType);
    }

    public void returnItem() {
        String itemType = getItemType();
        showCheckedOutListWithPrompt(itemType);
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                return;
            } else if (number > 0 && number <= getAmountOfItems() && !isItemAvailable(number)) {
                successfulReturnItem(itemType, number);
            } else {
                unsuccessfulReturnItem(itemType);
            }
        }
    }

    public void successfulReturnItem(String itemType, int number) {
        setItemAvailable(number, true);
        System.out.println("Thank you for returning " + itemType + ".");
        showCheckedOutListWithPrompt(itemType);
    }

    public void unsuccessfulReturnItem(String itemType) {
        System.out.println("That " + itemType + " is not a valid " + itemType + " to return.");
        showCheckedOutListWithPrompt(itemType);
    }

    public String getItemType() {
        return items.get(0).getClass().getSimpleName();
    }
}
