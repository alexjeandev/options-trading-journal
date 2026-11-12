package com.alexjeandev.optionstradingjournal.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CloseTradeRequest {
    private LocalDate closeDate;
    private BigDecimal realizedPnl;

    public LocalDate getCloseDate()  {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public BigDecimal getRealizedPnl() {
        return realizedPnl;
    }

    public void setRealizedPnl(BigDecimal realizedPnl) {
        this.realizedPnl = realizedPnl;
    }
}
