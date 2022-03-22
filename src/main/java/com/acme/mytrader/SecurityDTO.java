package com.acme.mytrader;

public class SecurityDTO {
    private final String security;
    private final double priceThreshold;
    private final int quantity;

    public SecurityDTO(String security, double priceThreshold, int quantity) {
        this.security = security;
        this.priceThreshold = priceThreshold;
        this.quantity = quantity;
    }

    public String getSecurity() {
        return security;
    }

    public double getPriceThreshold() {
        return priceThreshold;
    }

    public int getQuantity() {
        return quantity;
    }
}
