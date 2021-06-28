package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class PrinterTest {

    @Test
    void should_call_printInReverseOrder_when_call_printStatementLines() {
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        Transaction transaction = mock(Transaction.class);
        List<Transaction> transactions = Arrays.asList(transaction, transaction, transaction,transaction);
        Collections.shuffle(transactions);

        printer.print(transactions);

        verify(console, times(5)).printLine(anyString());
    }


}