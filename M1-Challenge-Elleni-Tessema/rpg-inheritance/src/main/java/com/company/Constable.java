package com.company;

public class Constable extends Players {
    private boolean jurisdiction;

    public Constable(String name, boolean jurisdiction) {
        super(name);
        this.jurisdiction = true;
        this.setStrength(60);
        this.setStamina(75);
        this.setSpeed(20);
        this.setAttackPower(5);
        this.setJurisdiction(true);
    }

    public Constable(){

    }
    public Constable(String name){

    }

    public boolean isJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(boolean jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Override
    public String toString() {
        return "Constable{" +
                "jurisdiction=" + jurisdiction +
                '}';
    }


    public int arrestCharacter(Players player){
        if(this.jurisdiction){
            player.setArrested(true);
            int attackPower= this.getAttackPower();
            attackPower = attackPower + 5;
            this.setAttackPower(attackPower);
        }
        return this.getAttackPower();
    }

}
