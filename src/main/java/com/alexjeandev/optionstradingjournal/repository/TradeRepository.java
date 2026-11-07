package com.alexjeandev.optionstradingjournal.repository;

import com.alexjeandev.optionstradingjournal.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
