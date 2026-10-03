package com.sy37.interfacedemo;

public class TestCylinder {
    static void main() {
        Cylinder c1 = new Cylinder(3,5);
        Cylinder c2 = new Cylinder(6,10);

        c1.area();
        c1.calculateVolume();
        c1.setColor("red");
        c1.displayInfo();

        c2.setColor("yellow");
        c2.displayInfo();

    }
}
