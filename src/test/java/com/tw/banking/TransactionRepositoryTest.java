package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TransactionRepositoryTest {

    @Test
    void should_return_transaction_with_same_amount_when_call_addDeposit_given_amount() {
        //given
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        int amount = 1000;
        String string = "28/06/2021";
        when(clock.todayAsString()).thenReturn(string);

        //when
        transactionRepository.addDeposit(amount);

        //then
        List<Transaction> result = transactionRepository.allTransactions();
        assertSame(1, result.size());
        assertEquals(string, result.get(0).date());
        assertEquals(amount, result.get(0).amount());
    }

    @Test
    void should_return_transaction_with_negative_amount_when_call_addWithdraw() {
        //given
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        int amount = 1000;
        String string = "28/06/2021";
        when(clock.todayAsString()).thenReturn(string);
        //when
        transactionRepository.addWithdraw(amount);
        //then
        List<Transaction> result = transactionRepository.allTransactions();
        assertSame(1, result.size());
        assertEquals(string, result.get(0).date());
        assertEquals(-1 * amount, result.get(0).amount());
    }


}