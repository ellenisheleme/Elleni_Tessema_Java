package com.company;

public class App {
    public static void main(String[] args) {
        com.company.factory.IceCream iceCreamFac =
                new com.company.factory.IceCream("Chocolate","100", "35", "5", "dairy, sugar and cacao" );

        com.company.pointofsale.IceCream iceCream =
                new com.company.pointofsale.IceCream("Vanilla","3", 5.60 );

        System.out.println(iceCream.totalPrice());
        System.out.println(iceCreamFac.getTotalProfit());

    }
}
