package com.acme.mytrader.price;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PriceSourceImpl implements PriceSource {
    private List<PriceListener> priceListenerList = new ArrayList<>();
    private static final List<String> SECURITIES = Arrays
            .asList("IBM", "Microsoft", "LinkedIn");

    private static final double MIN_RANGE = 1.00;
    private static final double MAX_RANGE = 100.00;

    public PriceSourceImpl() {
    }


    @Override
    public void addPriceListener(PriceListener priceListener) {
        this.priceListenerList.add(priceListener);
    }

    @Override
    public void removePriceListener(PriceListener priceListener) {
        this.priceListenerList.remove(priceListener);
    }

    @Override
    public void run() {
        //Used to generate a new Rnadom Object for Random Price generator
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            String security = SECURITIES.get(rand.nextInt(SECURITIES.size()));
            double price = MIN_RANGE + (MAX_RANGE - MIN_RANGE) * rand.nextDouble();
            priceListenerList.forEach(
                    priceListener -> priceListener.priceUpdate(security, price));
        }
    }



    public List<PriceListener> getPriceListenerList() {
        return priceListenerList;
    }

    public static List<String> getSECURITIES() {
        return SECURITIES;
    }

    public static double getMinRange() {
        return MIN_RANGE;
    }

    public static double getMaxRange() {
        return MAX_RANGE;
    }
}
