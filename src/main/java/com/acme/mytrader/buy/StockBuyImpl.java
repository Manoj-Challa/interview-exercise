package com.acme.mytrader.buy;

import com.acme.mytrader.SecurityDTO;
import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListenerImpl;
import com.acme.mytrader.price.PriceSource;

import java.util.List;

public class StockBuyImpl {
    private final ExecutionService executionService;
    private final PriceSource priceSource;

    public StockBuyImpl(ExecutionService executionService, PriceSource priceSource) {
        this.executionService = executionService;
        this.priceSource = priceSource;
    }

    public void stockBuy(List<SecurityDTO> request) throws InterruptedException {

        request.stream().map(
                p -> new PriceListenerImpl(p.getSecurity(), p.getPriceThreshold(), p.getQuantity(),
                        executionService, false)).forEach(priceSource::addPriceListener);
        Thread thread = new Thread(priceSource);
        thread.start();
        thread.join();
        request.stream().map(
                p -> new PriceListenerImpl(p.getSecurity(), p.getPriceThreshold(), p.getQuantity(),
                        executionService, false)).forEach(priceSource::removePriceListener);
    }
}
