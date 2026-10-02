package com.cs37.shop;

public class Goods {
    private String tag;
    private double price;
    private String id;

    public Goods(){

    }

    public Goods(String tag,String id,double price){
        this.tag = tag;
        this.price = price;
        this.id = id;
    }

    public void setTag(String tag){
        this.tag = tag;
    }

    public String getTag(){
        return tag;
    }

    public void setPrice(){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
