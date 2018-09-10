package exceptions;

public class WaterException extends Exception {
    private double water;

    public WaterException(double water) {
        super(water + " cups is not enough water.");
        this.water = water;
    }
}
