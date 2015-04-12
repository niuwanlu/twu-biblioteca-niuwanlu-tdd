package com.twu.biblioteca;


import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
        BibliotecaApp app = new BibliotecaApp();
        Book book1 = new Book("Harry Potter", "J.K.Rolling", "2000", false);
        app.addBook(book1);
        Book book2 = new Book("Head First Java", "Kathy Sierra", "2007", false);
        app.addBook(book2);
        app.printBookList();
        String output = outContent.toString();
        String[] linesOfOutput = output.split(System.getProperty("line.separator"));
        assertEquals(3, linesOfOutput.length);
        assertEquals("=======Book List=======", linesOfOutput[0]);
        assertEquals("Book Number: 1  Book Name: Harry Potter  Author:  J.K.Rolling  Published Year: 2000", linesOfOutput[1]);
        assertEquals("Book Number: 2  Book Name: Head First Java  Author:  Kathy Sierra  Published Year: 2007", linesOfOutput[2]);
    }

    @Test
    public void testShowOptions() {
        BibliotecaAppManager manager = new BibliotecaAppManager();
        manager.showOptions();
        String output = outContent.toString();
        assertEquals("Please choose an option:\n1.List Books\n2.Check Out Books\n3.Return Book\n4.Quit\n", output);
    }

    @Test
    public void testShowOptionsCalled() {
    }

    @Test
    public void testInvalidMenuOption() {
    }

    @Test
    public void testCheckedBookCannotSeen() {
        BibliotecaApp app = new BibliotecaApp();
        Book book1 = new Book("Harry Potter", "J.K.Rolling", "2000", true);
        app.addBook(book1);
        Book book2 = new Book("Head First Java", "Kathy Sierra", "2007", false);
        app.addBook(book2);
        app.printBookList();
        String output = outContent.toString();
        String[] linesOfOutput = output.split(System.getProperty("line.separator"));
        assertEquals(2, linesOfOutput.length);
        assertEquals("=======Book List=======", linesOfOutput[0]);
        assertEquals("Book Number: 2  Book Name: Head First Java  Author:  Kathy Sierra  Published Year: 2007", linesOfOutput[1]);
    }

}
