package com.alexjeandev.optionstradingjournal.service;

import com.alexjeandev.optionstradingjournal.model.Trade;
import com.alexjeandev.optionstradingjournal.repository.TradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {

    @Mock
    private TradeRepository tradeRepository;

    @InjectMocks
    private TradeService tradeService;

    @Test
    void saveTrade() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("CALL");
        trade.setStrikePrice(BigDecimal.valueOf(200));
        trade.setContracts(5);
        trade.setPremium(BigDecimal.valueOf(400));
        trade.setTradeDate(LocalDate.of(2025, 1, 01));
        trade.setExpirationDate(LocalDate.of(2025, 5, 12));
        trade.setStatus("OPEN");

        when(tradeRepository.save(trade)).thenReturn(trade);
        Trade savedTrade = tradeService.saveTrade(trade);
        assertEquals("AAPL", savedTrade.getSymbol());
        verify(tradeRepository).save(trade);
    }

    @Test
    void getAllTrades() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("CALL");
        trade.setStrikePrice(BigDecimal.valueOf(200));
        trade.setContracts(5);
        trade.setPremium(BigDecimal.valueOf(400));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));
        trade.setExpirationDate(LocalDate.of(2025, 5, 12));
        trade.setStatus("OPEN");

        List<Trade> trades = List.of(trade);

        when(tradeRepository.findAll()).thenReturn(trades);

        List<Trade> savedTrades = tradeService.getAllTrades();

        assertEquals(1, savedTrades.size());
        assertEquals("AAPL", savedTrades.get(0).getSymbol());

        verify(tradeRepository).findAll();
    }

    @Test
    void getTradeById() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("CALL");
        trade.setStrikePrice(BigDecimal.valueOf(200));
        trade.setContracts(5);
        trade.setPremium(BigDecimal.valueOf(400));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));
        trade.setExpirationDate(LocalDate.of(2025, 5, 12));
        trade.setStatus("OPEN");

        when(tradeRepository.findById(5L)).thenReturn(Optional.of(trade));
        Optional<Trade> saveTradeOptional = tradeService.getTradeById(5L);
        assertEquals("AAPL", saveTradeOptional.get().getSymbol());
        verify(tradeRepository).findById(5L);
    }

    @Test
    void closeTrade() {
        Trade trade = new Trade();
        trade.setSymbol("AAPL");
        trade.setOptionType("CALL");
        trade.setStrikePrice(BigDecimal.valueOf(200));
        trade.setContracts(5);
        trade.setPremium(BigDecimal.valueOf(400));
        trade.setTradeDate(LocalDate.of(2025, 1, 1));
        trade.setExpirationDate(LocalDate.of(2025, 5, 12));
        trade.setStatus("OPEN");

        LocalDate closeDate = LocalDate.of(2025, 3, 15);
        BigDecimal realizedPnl = BigDecimal.valueOf(250);

        when(tradeRepository.findById(5L)).thenReturn(Optional.of(trade));
        when(tradeRepository.save(trade)).thenReturn(trade);

        Trade closedTrade = tradeService.closeTrade(5L, closeDate, realizedPnl);

        assertEquals("CLOSED", closedTrade.getStatus());
        assertEquals(closeDate, closedTrade.getCloseDate());
        assertEquals(realizedPnl, closedTrade.getRealizedPnl());

        verify(tradeRepository).findById(5L);
        verify(tradeRepository).save(trade);
    }
}
