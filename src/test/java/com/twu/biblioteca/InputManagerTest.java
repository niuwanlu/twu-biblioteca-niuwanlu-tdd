package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class InputManagerTest extends TestCase {

    @Test
    public void testGetInput() throws Exception {
        String input = "hello";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputManager inputManager = new InputManager();
        String result = inputManager.getInput();
        assertEquals(input, result);
    }
}