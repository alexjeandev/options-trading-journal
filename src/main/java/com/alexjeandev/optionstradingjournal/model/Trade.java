package com.alexjeandev.optionstradingjournal.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

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

    public Trade() {
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String ticker) {
        if (ticker != null && !ticker.isBlank()) {
            this.symbol = ticker;
        } else {
            throw new IllegalArgumentException("Invalid stock symbol");
        }
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        if (optionType != null && (optionType.equalsIgnoreCase("Call") || optionType.equalsIgnoreCase("Put"))) {
            this.optionType = optionType.toUpperCase();
        } else {
            throw new IllegalArgumentException("Invalid option type");
        }
    }

    public BigDecimal getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(BigDecimal strikePrice) {
        if (strikePrice != null && strikePrice.compareTo(BigDecimal.ZERO) > 0) {
            this.strikePrice = strikePrice;
        } else {
            throw new IllegalArgumentException("Invalid strike price");
        }
    }

    public int getContracts() {
        return contracts;
    }

    public void setContracts(int contracts) {
        if (contracts > 0) {
            this.contracts = contracts;
        } else {
            throw new IllegalArgumentException("Invalid number of contracts");
        }
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        if (premium != null && premium.compareTo(BigDecimal.ZERO) > 0) {
            this.premium = premium;
        } else {
            throw new IllegalArgumentException("Invalid premium amount");
        }
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        if (tradeDate != null) {
            this.tradeDate = tradeDate;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate != null && tradeDate != null && !expirationDate.isBefore(tradeDate)) {
            this.expirationDate = expirationDate;
        } else {
            throw new IllegalArgumentException("Invalid expiration date")
        }
    }
}
