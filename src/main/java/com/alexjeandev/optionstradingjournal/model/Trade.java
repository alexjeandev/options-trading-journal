package com.alexjeandev.optionstradingjournal.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String optionType;
    private BigDecimal strikePrice;
    private int contracts;
    private BigDecimal premium;
    private LocalDate tradeDate;
    private LocalDate expirationDate;
    private String status;
    private LocalDate closeDate;
    private BigDecimal realizedPnl;
}
