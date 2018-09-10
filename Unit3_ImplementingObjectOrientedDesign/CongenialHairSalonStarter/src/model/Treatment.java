package model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Treatment {

    private String name;
    private int hoursNeeded;

    public Treatment(String name, int time) {
        this.name = name;
        this.hoursNeeded = time;
    }

    // getters
    public String getName() { return name; }
    public int getHoursNeeded() { return hoursNeeded; }

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(o == null || getClass() != o.getClass())
			return false;

		Treatment treament = (Treatment) o;

		return name.equals(treament.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
