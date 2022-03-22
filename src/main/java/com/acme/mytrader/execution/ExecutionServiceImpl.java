package com.acme.mytrader.execution;

public class ExecutionServiceImpl implements ExecutionService {
    private final int id;


    public ExecutionServiceImpl(int id) {
        this.id = id;
    }

    @Override
    public void buy(String security, double price, int volume) {
        System.out.println("Buy Trade at Price: " + price +" no of volumes: "+volume +" name of securities: "+security);
    }

    @Override
    public void sell(String security, double price, int volume) {

    }

    public int getId() {
        return id;
    }
}
