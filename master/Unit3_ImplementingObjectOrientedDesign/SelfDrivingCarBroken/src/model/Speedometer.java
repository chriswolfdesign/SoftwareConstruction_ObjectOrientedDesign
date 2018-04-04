package model;

import java.util.List;
import java.util.ArrayList;

import ui.SelfDrivingCar;

public class Speedometer {

	private List<Wheel> wheels = new ArrayList<Wheel>();

    public Speedometer(SelfDrivingCar car) {
        this.wheels = car.getWheels();
    }

    public int getSpeed() {
        Wheel w = wheels.get(0);
        return w.getSpeed();
    }


}
