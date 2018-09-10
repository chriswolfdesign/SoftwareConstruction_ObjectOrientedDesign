package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends Choice {

    private List<Choice> choices;
    private int id;

    public Room(int id) {
        super("Enter Room  " + id +".");
        this.id = id;
        choices = new ArrayList<>();
        choices.add(0, null);
    }

    //EFFECTS: prints all possible next choices
    public void printNextChoices() {
        System.out.println("You are now in Room " + id + ".\n");
        System.out.println("You have the following options: ");

        for(int i = 1; i < choices.size(); i++) {
            System.out.print("\tOption " + i + ": ");
            choices.get(i).printOptionMessage();
        }
    }

    // MODIFIES: this
    // EFFECTS: adds c to next possible choices
    public void addChoice(Choice c) {
        choices.add(c);
    }

    //getters for gameplay

    public Choice getChoice(int i) {
        return choices.get(i);
    }

    public int getChoiceRange() {
        return choices.size();
    }

    //EFFECTS: prints the result of choosing this choice
    @Override
    public void printOutcome() {
        printNextChoices();
    }
}
