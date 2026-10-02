package com.cs37.shop;

public class Shop {
    private double money;

    public Shop(){
    }

    public Shop(double money){
        this.money = money;
    }

    public void setMoney(double money){
        this.money = money;
    }

    public double getMoney(){
        return money;
    }
}
