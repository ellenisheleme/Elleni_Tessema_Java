package com.company;

import java.util.Objects;

public class Warrior extends Players{
    private int shieldStrength;
    public Warrior(String name, int shieldStrength ) {
        super(name);
        this.shieldStrength = 100;
        this.setStamina(60);
        this.setSpeed(50);
        this.setAttackPower(10);

    }

    public Warrior(String name) {

    }
    public Warrior(){

    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }


    @Override
    public String toString() {
        return "Warrior{" +
                "shieldStrength=" + shieldStrength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warrior warrior = (Warrior) o;
        return shieldStrength == warrior.shieldStrength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shieldStrength);
    }
}
