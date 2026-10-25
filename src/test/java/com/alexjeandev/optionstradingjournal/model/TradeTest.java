package com.alexjeandev.optionstradingjournal.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TradeTest {

    @Test
    void testInvalidContracts() {
        Trade trade = new Trade();
        assertThrows(IllegalArgumentException.class, () -> trade.setContracts(-5));
    }
    @Test
    void testValidContracts() {
        Trade trade = new Trade();
        trade.setContracts(5);
        assertEquals(5, trade.getContracts());
    }

    @Test
    void testClosedTradeWithoutCloseDate() {
        Trade trade = new Trade();
        trade.setStatus("CLOSED");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                ()-> trade.validateTrade());

        assertEquals("Closed trades must have a closing date", exception.getMessage());
    }
}
