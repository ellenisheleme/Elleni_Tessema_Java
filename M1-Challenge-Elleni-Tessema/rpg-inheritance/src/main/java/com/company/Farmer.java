package com.company;

import java.util.Objects;

public class Farmer extends Players {
    private boolean plowing;
    private boolean harvesting;


    public Farmer(String name,  boolean plowing, boolean harvesting) {
        super(name);
        this.plowing = false;
        this.harvesting = false;
       this. setStrength(75);
       this.setHealth(100);
       this.setStamina(75);
       this.setSpeed(10) ;
        this.setAttackPower(1);
       this.setRunning(false);
      this.setArrested(false);
    }
     public Farmer(String name){

     }
    public Farmer() {

    }


    public boolean isPlowing() {
        return plowing;
    }

    public void setPlowing(boolean plowing) {
        this.plowing = plowing;
    }

    public boolean isHarvesting() {
        return harvesting;
    }

    public void setHarvesting(boolean harvesting) {
        this.harvesting = harvesting;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "plowing=" + plowing +
                ", harvesting=" + harvesting +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farmer farmer = (Farmer) o;
        return plowing == farmer.plowing && harvesting == farmer.harvesting;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plowing, harvesting);
    }

    public int attackAnotherCharacter (Players player){

            if (this.getAttackPower() > 0) {
                int health = player.getHealth();
                health -= 10;
                player.setHealth(health);

                int attackPower = this.getAttackPower();
                attackPower--;

                this.setAttackPower(attackPower);

            }
            return getAttackPower();
        }

    }

