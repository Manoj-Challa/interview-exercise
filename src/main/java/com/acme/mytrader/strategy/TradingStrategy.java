package com.acme.mytrader.strategy;

import com.acme.mytrader.SecurityDTO;
import com.acme.mytrader.buy.StockBuyImpl;
import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.execution.ExecutionServiceImpl;
import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.price.PriceSourceImpl;

import static java.util.Arrays.asList;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {


    public static void main(String[] args) throws InterruptedException {
        StockBuyImpl tradingStrategy = new StockBuyImpl(new ExecutionServiceImpl(1),new PriceSourceImpl());
        SecurityDTO ibm=new SecurityDTO("IBM",90.00,10);
        SecurityDTO microsoft=new SecurityDTO("microsoft",80.00,20);

        tradingStrategy.stockBuy(asList(ibm, microsoft));

    }

}
