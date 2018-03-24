package main;

import exceptions.BeansAmountException;
import exceptions.NoCupsRemainingException;
import exceptions.StaleCoffeeException;
import exceptions.WaterException;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args){
        CoffeeMaker maker = new CoffeeMaker();
        maker.setTimeSinceLastBrew(30);
        try {
            System.out.println("Trying brew coffee...");
            maker.brew(2.5, 15);
            System.out.println("Brewed coffee!!!");
        } catch (WaterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (BeansAmountException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println();

        try {
            System.out.println("Trying tou pour coffee...");
            maker.pourCoffee();
            System.out.println("Poured coffee!!!");
        } catch (StaleCoffeeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (NoCupsRemainingException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}