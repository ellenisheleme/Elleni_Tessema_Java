package com.company;

public class App {
    public static void main(String[] args) {

       Farmer farmer = new Farmer("Bini",false,false);
        Constable constable = new Constable("John",true );
       Warrior warrior = new Warrior("NINJA", 100);

        constable.arrestCharacter(farmer);
        System.out.println(constable.getAttackPower());
//        System.out.println(constable.getHealth());

    }
}