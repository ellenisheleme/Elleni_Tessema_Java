package com.company.pointofsale;

public class IceCream {
    private String flavor;
    private String quantity;
    private Double price;
    public IceCream(String flavor, String quantity, Double price) {
        this.flavor = flavor;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public IceCream() {
    }

    public String getSize() {
        return quantity;
    }

    public void setSize(String quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "flavor='" + flavor + '\'' +
                ", size='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }




}
