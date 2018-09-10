package model;

import model.exceptions.NoCookException;
import model.exceptions.NoIngredientException;
import model.exceptions.NotEnoughMoneyException;

public class Owner {

    private String name;
    private Kitchen kitchen;

    public Owner(String name, Kitchen kit) {
        this.name = name;
        kitchen = kit;
    }

    //getters
    public String getName() { return name; }
    public Kitchen getKitchen() { return kitchen; }

    // REQUIRES: we have enough ingredients to make the specified amount of tacos
    // MODIFIES: this
    // EFFECTS: calls makeTaco on the kitchen, returns true
    public boolean orderMoreTacos(int amount) {
        try {
            kitchen.makeTaco(amount);
        } catch (NoCookException e) {
            e.printStackTrace();
            return false;
        } catch (NoIngredientException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //MODIFIES: this 
    //EFFECTS: calls buyIngredients on the kitchen, returns true.
    public boolean askForMoreIngredients(int amount) {
        try {
            this.kitchen.buyIngredients(amount);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}