package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class AccountTest {

    @Test
    public void should_call_addDeposit_when_deposit() {

        // given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        int amount = 1000;
        // when
        account.deposit(amount);
        // then
        verify(transactionRepository, times(1)).addDeposit(amount);
    }

    @Test
    public void should_call_addWithdraw_when_withdraw() {

        // given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        int amount = 1000;
        // when
        account.withdraw(amount);
        // then
        verify(transactionRepository, times(1)).addWithdraw(amount);
    }

    @Test
    public void should_call_addWithdraw_when_printStatement() {

        // given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);

        List<Transaction> transactions = Collections.singletonList(new Transaction("date", 1000));
        // when
        when(transactionRepository.allTransactions()).thenReturn(transactions);
        account.printStatement();

        // then
        verify(printer,times(1)).print(transactions);
    }
}