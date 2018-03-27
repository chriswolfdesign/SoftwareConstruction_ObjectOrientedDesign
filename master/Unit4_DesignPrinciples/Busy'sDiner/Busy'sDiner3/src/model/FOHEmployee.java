package model;

import java.util.List;
import java.util.ArrayList;

public abstract class FOHEmployee {
    protected static final double DISH_PRICE = 10.00;

    protected List<Order> orders;
    protected double cash;
    protected int currentOrderNumber;
    protected Dish dish;

    public FOHEmployee(Dish dish) {
        this.orders = new ArrayList<>();
        currentOrderNumber = 100;
        this.dish = dish;
    }
	
    //EFFECTS: prints out a description of the dish on the menu
    public void describeDish() {
        System.out.println(dish.getDescription());
    }

    //EFFECTS: prints out a greeting
    public void greet() {
        System.out.println("\"Hello and welcome to Busy's, the home of the trendy turkey club sandwich.\"");
    }
	
    //MODIFIES: this, order
    //EFFECTS: logs order as served and brings to table
    public void deliverFood(Order order) {
        order.setIsServed();
        System.out.print(getPrefix() + "Delivered food: ");
        order.print();
    }

	abstract String getPrefix();
}
