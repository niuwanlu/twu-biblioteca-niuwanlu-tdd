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
        BibliotecaApp.main(new String[] {});
        String output = outContent.toString();
        String[] linesOfOutput = output.split(System.getProperty("line.separator"));
        assertEquals("Welcome!", linesOfOutput[0]);
        assertEquals("=======================", linesOfOutput[1]);
    }

    @Test
    public void testBookList() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        String[] bookList = {"Harry Potter", "Head First Java"};
        biblioteca.setBooks(bookList);
        biblioteca.printBookList();
        String output = outContent.toString();
        String[] linesOfOutput = output.split(System.getProperty("line.separator"));
        assertEquals("=======Book List=======", linesOfOutput[0]);
        assertEquals(bookList[0], linesOfOutput[1]);
        assertEquals(bookList[1], linesOfOutput[2]);
    }

}
