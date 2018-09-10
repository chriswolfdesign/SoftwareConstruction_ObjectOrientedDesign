package model;

import exceptions.BrokeException;
import exceptions.NotHungry;
import exceptions.AllergyException;
import exceptions.DidntEat;

import java.util.List;

public class Manager {

    private final List<Animal> animalsToManage;
    private final Keeper keeper;

    public Manager(List<Animal> animals, Keeper keeper) {
        this.animalsToManage = animals;
        this.keeper = keeper;
    }

    public void manage() throws BrokeException {
        try {
            keeper.feed();
        } catch (DidntEat didntEat) {
			System.out.println("Call the doctor!");
		}
		finally {
			System.out.println("Finally Managers says:" + 
					" Regardless of what happens");
		}
    }


}
