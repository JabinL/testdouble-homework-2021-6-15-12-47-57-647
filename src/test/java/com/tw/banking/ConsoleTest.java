package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleTest {

    @Test
    void should_print_correct_content_when_printLine() {

        Console console = new Console();
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        console.printLine("Test");
        assertTrue(outputStream.toString().contains("Test"));
    }
}