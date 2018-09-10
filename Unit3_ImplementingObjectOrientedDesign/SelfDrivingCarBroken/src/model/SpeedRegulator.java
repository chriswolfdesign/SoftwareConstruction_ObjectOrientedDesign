package model;

import java.util.List;
import java.util.ArrayList;

import ui.SelfDrivingCar;

public class SpeedRegulator {

    private int intendedSpeed;
	private Engine engine;
	private List<Brake> brakes;
	private Speedometer speedometer;

    public SpeedRegulator(SelfDrivingCar car) {
        engine = car.getEngine();
        brakes = car.getBrakes();
        speedometer = car.getSpeedometer();
    }

    public void slowDown() {
        intendedSpeed--;
        engine.stop();
        while(speedometer.getSpeed() > intendedSpeed) {
            for (Brake b : brakes) {
                b.apply();
            }
        }
    }


}
