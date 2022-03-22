package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionService;

public class PriceListenerImpl implements PriceListener {
    private final String security;
    private final double executeLevel;
    private final int noOfQuantities;
    private final ExecutionService executionService;
    private boolean isExceuted;

    public PriceListenerImpl(String security, double executeLevel, int noOfQuantities, ExecutionService executionService, boolean isExceuted) {
        this.security = security;
        this.executeLevel = executeLevel;
        this.noOfQuantities = noOfQuantities;
        this.executionService = executionService;
        this.isExceuted = isExceuted;
    }

    @Override
    public void priceUpdate(String security, double price) {
        if (!isExceuted && this.security.equals(security) && price < this.executeLevel) {
            executionService.buy(security, price, noOfQuantities);
            isExceuted = true;
        }
    }
}
