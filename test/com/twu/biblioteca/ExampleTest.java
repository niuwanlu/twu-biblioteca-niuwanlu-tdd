package com.twu.biblioteca;


import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testWelcomeMessage() {
        BibliotecaAppManager manager = new BibliotecaAppManager();
        manager.showWelcome();
        String output = outContent.toString();
        String[] linesOfOutput = output.split(System.getProperty("line.separator"));
        assertEquals("Welcome!", linesOfOutput[0]);
        assertEquals("=======================", linesOfOutput[1]);
    }

    @Test
    public void testBookList() {
        BibliotecaAppManager manager = new BibliotecaAppManager();
        manager.createApp();
        String output = outContent.toString();
        String[] linesOfOutput = output.split(System.getProperty("line.separator"));
        assertEquals("=======Book List=======", linesOfOutput[0]);
        assertEquals("Book Name: Harry Potter  Author:  J.K.Rolling  Published Year: 2000", linesOfOutput[1]);
        assertEquals("Book Name: Head First Java  Author:  Kathy Sierra  Published Year: 2007", linesOfOutput[2]);
    }

    @Test
    public void testShowOptions() {
        BibliotecaAppManager manager = new BibliotecaAppManager();
        manager.showOptions();
        String output = outContent.toString();
        assertEquals("Please choose an option:\n1.List Books\n", output);
    }

}
