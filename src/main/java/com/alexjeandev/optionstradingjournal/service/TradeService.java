package com.alexjeandev.optionstradingjournal.service;

import com.alexjeandev.optionstradingjournal.model.Trade;
import com.alexjeandev.optionstradingjournal.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TradeService {
    private final TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public Trade saveTrade(Trade trade) {
        trade.validateTrade();
        return tradeRepository.save(trade);
    }

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    public Optional<Trade> getTradeById(Long id) {
        return tradeRepository.findById(id);
    }

    public Trade closeTrade(Long id, LocalDate closeDate, BigDecimal realizedPnl) {
        Optional<Trade> result = getTradeById(id);
        Trade trade = result.orElseThrow();

        if ("CLOSED".equals(trade.getStatus())) {
            throw new IllegalStateException("Trade is already closed");
        }

        trade.setStatus("CLOSED");
        trade.setCloseDate(closeDate);
        trade.setRealizedPnl(realizedPnl);
        trade.validateTrade();
        return tradeRepository.save(trade);
    }

}
