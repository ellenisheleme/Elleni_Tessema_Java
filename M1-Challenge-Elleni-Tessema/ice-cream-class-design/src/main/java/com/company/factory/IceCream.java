package com.company.factory;

import java.util.Objects;

public class IceCream {
  private String flavor;
  private String salesPrice;
  private String productionCost;
  private String productionTime;
  private String ingredients;

    public IceCream() {
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(String productionCost) {
        this.productionCost = productionCost;
    }

    public String getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(String productionTime) {
        this.productionTime = productionTime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public IceCream(String flavor, String salesPrice, String productionCost, String productionTime, String ingredients) {
        this.flavor = flavor;
        this.salesPrice = salesPrice;
        this.productionCost = productionCost;
        this.productionTime = productionTime;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "flavor='" + flavor + '\'' +
                ", salesPrice='" + salesPrice + '\'' +
                ", productionCost='" + productionCost + '\'' +
                ", productionTime='" + productionTime + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCream iceCream = (IceCream) o;
        return Objects.equals(flavor, iceCream.flavor) && Objects.equals(salesPrice, iceCream.salesPrice) && Objects.equals(productionCost, iceCream.productionCost) && Objects.equals(productionTime, iceCream.productionTime) && Objects.equals(ingredients, iceCream.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavor, salesPrice, productionCost, productionTime, ingredients);
    }

    public int getTotalProfit(){
        int totalProfit = Integer.parseInt(salesPrice) - Integer.parseInt(productionCost);
        return totalProfit;
    }

}

