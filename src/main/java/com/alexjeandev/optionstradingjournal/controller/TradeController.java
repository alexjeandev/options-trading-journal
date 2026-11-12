package com.alexjeandev.optionstradingjournal.controller;

import com.alexjeandev.optionstradingjournal.dto.CloseTradeRequest;
import com.alexjeandev.optionstradingjournal.model.Trade;
import com.alexjeandev.optionstradingjournal.service.TradeService;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public Trade saveTrade(@RequestBody Trade trade) {
        return tradeService.saveTrade(trade);
    }

    @PutMapping("/{id}/close")
    public Trade closeTrade(@PathVariable Long id,
                            @RequestBody CloseTradeRequest request) {

        return tradeService.closeTrade(
                id,
                request.getCloseDate(),
                request.getRealizedPnl()
        );
    }



}
