package com.alexjeandev.optionstradingjournal.controller;

import com.alexjeandev.optionstradingjournal.model.Trade;
import com.alexjeandev.optionstradingjournal.service.TradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trades")
public class TradeController {
    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeService.getAllTrades();
    }

    @GetMapping("/{id}")
    public Optional<Trade> getTradeById(@PathVariable Long id) {
        return tradeService.getTradeById(id);
    }



}
