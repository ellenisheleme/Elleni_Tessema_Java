package com.company;

public class App {
//Based on class activity exercise 1.3
    public static void main(String[] args) {

        Address shippingAddress = new Address("5331 Randolph", "Rd 23", "Silver Spring", "MD", "Z2010");
        Address billingAddress = new Address("2604 E Jefferson", "Street 1,", "Rockville", "MD", "20850");
        Customer customer = new Customer(" John", "Jim","jjohn@gmail.com", "240-546-8365", shippingAddress,billingAddress);
        System.out.println(customer);
    }

}
