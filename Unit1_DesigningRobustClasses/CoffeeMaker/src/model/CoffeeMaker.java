package model;

import exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int minutesSinceLastBrewed;
    private int cupsRemaining;

    public CoffeeMaker() {
        this.minutesSinceLastBrewed = 61;
        this.cupsRemaining = 0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return this.minutesSinceLastBrewed;
    }
    public int getCupsRemaining() {
        return this.cupsRemaining;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return this.cupsRemaining > 0;
    }

    // REQUIRES: a non-negative integer
    // EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        minutesSinceLastBrewed = time;
    }

    // REQUIRES: an int 0 < int <= 20
    // MODIFIES: this
    // EFFECTS: sets the number of cups we have
    public void setCupsRemaining(int cupsRemaining) {
        this.cupsRemaining = cupsRemaining;
    }

    // REQUIRES: beans between 2.40 and 2.60 cups, water > 14.75 cups
    // EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    public void brew(double beans, double water) throws NotEnoughBeansException, TooManyBeansException, WaterException {
        if(beans < 2.4)
            throw new NotEnoughBeansException(beans);
        else if(beans > 2.6)
            throw new TooManyBeansException(beans);
        else if(water <= 14.75)
            throw new WaterException(water);

        cupsRemaining = 20;
        minutesSinceLastBrewed = 0;
    }

    // REQUIRES: cups remaining > 0, time since last brew < 60
    // MODIFIES: this
    // EFFECTS: subtracts one cup from cups remaining
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException {
        if(!areCupsRemaining())
            throw new NoCupsRemainingException();
        else if(minutesSinceLastBrewed >= 60)
            throw new StaleCoffeeException(getTimeSinceLastBrew());

        this.cupsRemaining--;
    }
}
