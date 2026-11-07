package com.alexjeandev.optionstradingjournal.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TradeTest {


    @Test
    void testInvalidSymbol() {
        Trade trade = new Trade();
        assertThrows(IllegalArgumentException.class, () -> trade.setSymbol(null));
        assertThrows(IllegalArgumentException.class, () -> trade.setSymbol(""));
        assertThrows(IllegalArgumentException.class, () -> trade.setSymbol(" "));
    }

    @Test
    void testValidSymbol() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        assertEquals("AAPL", trade.getSymbol());
    }

    @Test
    void testMissingSymbolValidation() {
        Trade trade = new Trade();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,  trade::validateTrade);
        assertEquals("No ticker added to trade", exception.getMessage());
    }

    @Test
    void testInvalidOptionType() {
        Trade trade = new Trade();
        assertThrows(IllegalArgumentException.class, () -> trade.setOptionType(null));
        assertThrows(IllegalArgumentException.class, () -> trade.setOptionType(""));
        assertThrows(IllegalArgumentException.class, () -> trade.setOptionType(" "));
        assertThrows(IllegalArgumentException.class, () -> trade.setOptionType("Trades"));
    }

    @Test
    void testValidOptionType() {
        Trade trade = new Trade();
        trade.setOptionType("call");
        assertEquals("CALL", trade.getOptionType());
        trade.setOptionType("put");
        assertEquals("PUT", trade.getOptionType());
    }

    @Test
    void testMissingOptionTypeValidation() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,  trade::validateTrade);
        assertEquals("Option type is required", exception.getMessage());
    }

    @Test
    void testInvalidStrikePrice() {
        Trade trade = new Trade();
        assertThrows(IllegalArgumentException.class, () -> trade.setStrikePrice(null));
        assertThrows(IllegalArgumentException.class, () -> trade.setStrikePrice(new BigDecimal(0)));
        assertThrows(IllegalArgumentException.class, () -> trade.setStrikePrice(new BigDecimal(-1)));
    }

    @Test
    void testValidStrikePrice() {
        Trade trade = new Trade();
        trade.setStrikePrice(new BigDecimal(5));
        assertEquals(new BigDecimal(5), trade.getStrikePrice());
    }

    @Test
    void testMissingStrikePriceValidation() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,  trade::validateTrade);
        assertEquals("Invalid strike price", exception.getMessage());
    }

    @Test
    void testInvalidContracts() {
        Trade trade = new Trade();
        assertThrows(IllegalArgumentException.class, () -> trade.setContracts(0));
        assertThrows(IllegalArgumentException.class, () -> trade.setContracts(-1));
        assertThrows(IllegalArgumentException.class, () -> trade.setContracts(-5));
    }

    @Test
    void testValidContracts() {
        Trade trade = new Trade();
        trade.setContracts(5);
        assertEquals(5, trade.getContracts());
    }


    @Test
    void testMissingContractsValidation() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,  trade::validateTrade);
        assertEquals("Invalid number of contracts", exception.getMessage());
    }

    @Test
    void testInvalidPremium() {
        Trade trade = new Trade();
        assertThrows(IllegalArgumentException.class, () -> trade.setPremium(null));
        assertThrows(IllegalArgumentException.class, () -> trade.setPremium(new BigDecimal(0)));
        assertThrows(IllegalArgumentException.class, () -> trade.setPremium(new BigDecimal(-5)));
    }

    @Test
    void testValidPremium() {
        Trade trade = new Trade();
        trade.setPremium(new BigDecimal(5));
        assertEquals(new BigDecimal(5), trade.getPremium());
    }

    @Test
    void testMissingPremiumValidation() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,  trade::validateTrade);
        assertEquals("Invalid premium", exception.getMessage());
    }

    @Test
    void testInvalidTradeDate() {
        Trade trade = new Trade();
        assertThrows(IllegalArgumentException.class, () -> trade.setTradeDate(null));
    }

    @Test
    void testValidTradeDate() {
        Trade trade = new Trade();
        trade.setTradeDate(LocalDate.of(2025, 11, 25));
        assertEquals(LocalDate.of(2025, 11, 25), trade.getTradeDate());
    }

    @Test
    void testMissingTradeDateValidation() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, trade::validateTrade);
        assertEquals("Trade date is required", exception.getMessage());
    }

    @Test
    void testInvalidExpirationDate() {
        Trade trade = new Trade();
        assertThrows(IllegalArgumentException.class, () -> trade.setExpirationDate(null));
    }

    @Test
    void testValidExpirationDate() {
        Trade trade = new Trade();
        trade.setExpirationDate(LocalDate.of(2025, 12, 11));
        assertEquals(LocalDate.of(2025, 12, 11), trade.getExpirationDate());
    }

    @Test
    void testMissingExpirationDateValidation() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, trade::validateTrade);
        assertEquals("Expiration date is required", exception.getMessage());
    }

    @Test
    void testInvalidStatus() {
        Trade trade = new Trade();
        assertThrows(IllegalArgumentException.class, () -> trade.setStatus(null));
        assertThrows(IllegalArgumentException.class, () -> trade.setStatus(""));
        assertThrows(IllegalArgumentException.class, () -> trade.setStatus(" "));
        assertThrows(IllegalArgumentException.class, () -> trade.setStatus("Pending"));

    }

    @Test
    void testValidStatus() {
        Trade trade = new Trade();
        trade.setStatus("Open");
        assertEquals("OPEN", trade.getStatus());
        trade.setStatus("Closed");
        assertEquals("CLOSED", trade.getStatus());
    }

    @Test
    void testMissingStatusValidation() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));
        trade.setExpirationDate(LocalDate.of(2025, 5,5));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, trade::validateTrade);
        assertEquals("Trade status is required", exception.getMessage());
    }

    @Test
    void testClosedTradeMissingCloseDate() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));
        trade.setExpirationDate(LocalDate.of(2025, 5,5));
        trade.setStatus("Closed");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, trade::validateTrade);
        assertEquals("Closed trades must have a closing date", exception.getMessage());
    }

    @Test
    void testOpenTradeWithCloseDate() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));
        trade.setExpirationDate(LocalDate.of(2025, 5,5));
        trade.setStatus("Open");
        trade.setCloseDate(LocalDate.of(2025, 8, 2));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, trade::validateTrade);
        assertEquals("Open trades can't have a close date", exception.getMessage());
    }

    @Test
    void testClosedTradeMissingRealizedPnl() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));
        trade.setExpirationDate(LocalDate.of(2025, 5,5));
        trade.setStatus("Closed");
        trade.setCloseDate(LocalDate.of(2025, 8, 2));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, trade::validateTrade);
        assertEquals("Closed trade must have a realized PNL", exception.getMessage());
    }

    @Test
    void testOpenTradeWithRealizedPnl() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));
        trade.setExpirationDate(LocalDate.of(2025, 5,5));
        trade.setStatus("Open");
        trade.setRealizedPnl(new BigDecimal(200));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, trade::validateTrade);
        assertEquals("Open trade cannot have a realized PNL", exception.getMessage());
    }

    @Test
    void testExpirationBeforeTradeDate() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 6, 1));
        trade.setExpirationDate(LocalDate.of(2025, 5,5));
        trade.setStatus("Open");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, trade::validateTrade);
        assertEquals("Expiration date cannot be before trade date", exception.getMessage());
    }

    @Test
    void testCloseDateBeforeTradeDate() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 6, 1));
        trade.setExpirationDate(LocalDate.of(2025, 9,5));
        trade.setStatus("Closed");
        trade.setCloseDate(LocalDate.of(2025, 4, 2));
        trade.setRealizedPnl(new BigDecimal(200));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, trade::validateTrade);
        assertEquals("Closing date cannot be before opening date", exception.getMessage());
    }

    @Test
    void testValidOpenTrade() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 6, 1));
        trade.setExpirationDate(LocalDate.of(2025, 9,5));
        trade.setStatus("Open");

        assertDoesNotThrow(trade::validateTrade);

    }

    @Test
    void testValidCloseTrade() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("call");
        trade.setStrikePrice(new BigDecimal(5));
        trade.setContracts(5);
        trade.setPremium(new BigDecimal(250));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));
        trade.setExpirationDate(LocalDate.of(2025, 9,5));
        trade.setStatus("Closed");
        trade.setCloseDate(LocalDate.of(2025, 4, 2));
        trade.setRealizedPnl(new BigDecimal(200));

        assertDoesNotThrow(trade::validateTrade);

    }
}


