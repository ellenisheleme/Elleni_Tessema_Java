package com.company;

public class App {
    public static void main(String[] args) {
        com.company.factory.IceCream iceCreamFac =
                new com.company.factory.IceCream();

        com.company.pointofsale.IceCream iceCream =
                new com.company.pointofsale.IceCream("Vanilla","medium", 5.60 );

        System.out.println(iceCream);
        System.out.println(iceCreamFac);          ;
    }
}
