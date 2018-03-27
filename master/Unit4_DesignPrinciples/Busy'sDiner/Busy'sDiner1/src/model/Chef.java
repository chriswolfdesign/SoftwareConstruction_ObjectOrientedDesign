package model;

public class Chef {
    private static final String PREFIX = "CHEF - ";
    private Order order;

    public Chef() {
        this.order = null;
    }

    //MODIFIES: this, order
    //EFFECTS: logs order as served and brings to table
    public void deliverFood(Order order) {
        order.setIsServed();
        System.out.print(PREFIX + "Delivered food: ");
        order.print();
    }

    //MODIFIES: this, order
    //EFFECTS: makes food and logs order as prepared
    public void makeDish(Order order) {
        this.order = order;
        prepareIngredients();
        followRecipe();
        cookFood();
        plate(order);
    }

    //EFFECTS: prints out a doing dishes message
    public void doDishes() {
        System.out.println(PREFIX + "Cleaning, scrubbing...");
        System.out.println("Dishes done.");
    }

    //EFFECTS: prints out the ingredients being prepared
    private void prepareIngredients() {
        System.out.println(PREFIX + "Slicing tomatoes... Shredding lettuce...");
        System.out.println(PREFIX + "Mashing avocado! Yum!");
    }

    //EFFECTS: prints out the recipe being followed
    private void followRecipe() {
        System.out.println(PREFIX + "Stacking meat... Placing veggies.... ");
        System.out.println(PREFIX + "Pouring sriracha! Spreading avocado! Trendy!");
    }

    //EFFECTS: prints out a message about cooking food
    private void cookFood() {
        System.out.println(PREFIX + "Grilling sandwich...");
    }

    //MODIFIES: order
    //EFFECTS: logs order as prepared and prints out a plating message
    private void plate(Order order) {
        order.setIsPrepared();
        System.out.print(PREFIX + "Plated order: ");
        order.print();
        this.order = null;
    }
}
