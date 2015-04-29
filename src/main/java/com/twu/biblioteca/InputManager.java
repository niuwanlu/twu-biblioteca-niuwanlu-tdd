package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by wlniu on 4/28/15.
 */
public class InputManager {

    private static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        String input = null;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        return input;
    }
}
