package com.sy37.interfacedemo;

public class Cylinder implements CylinderOperations{
    private double radius;
    private double height;
    private String color;

    public Cylinder(){

    }

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void calculateVolume() {
        double volume = area() * height;

    }

    @Override
    public void setColor(String c) {
        this.color = c;

    }

    @Override
    public double area() {
        return radius * radius * PI;
    }

    public void displayInfo(){
        System.out.println("圆柱体颜色:" + color);
        System.out.println("圆柱体底面积:" + area());
        System.out.println("圆柱体底体积:" + (area() * height));
    }
}
