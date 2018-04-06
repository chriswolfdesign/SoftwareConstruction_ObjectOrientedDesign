package model;

import java.util.LinkedList;
import java.util.List;


public class Todo extends Doable {

    private String description;
    private List<Doable> doables;
    private boolean complete;
    private boolean subTodoComplete;
    private boolean subTaskComplete;


    public Todo(String description) {
        this.description = description;
        doables = new LinkedList<>();
        complete = false;
        subTodoComplete = false;
        subTaskComplete = false;
    }

    // getters
    public List<Doable> getDoables() { return doables; }
    public boolean getStatus() { return complete; }

    public boolean addDoable(Doable d) {
        if (!doables.contains(d)) {
            doables.add(d);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeDoable(Doable d) {
        if (doables.contains(d)) {
            doables.remove(d);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return true if the this subtodos are complete
     */
    public boolean doablesComplete() {
        boolean areDoablesComplete = true;
        for (Doable d : doables) {
            if (!d.isComplete()) {
                areDoablesComplete = false;
            }
        }
        subTodoComplete = areDoablesComplete;
        return subTodoComplete;
    }

    /**
     *
     * @return true if THIS subtask is complete
     */
    public boolean isThisTodoComplete() {
        return complete;
    }

    @Override
    public String getDescription() {
        return "TODO List: " + description;
    }


    @Override
    void display(String indentSpace) {

    }
}