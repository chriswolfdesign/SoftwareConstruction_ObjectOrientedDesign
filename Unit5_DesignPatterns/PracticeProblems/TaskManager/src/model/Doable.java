package model;

public abstract class Doable {
    protected boolean complete;

    public Doable() {
        complete = false;
    }

    public void complete() {
        if(!complete)
            complete = true;
    }

    public boolean isComplete() {
        return complete;
    }
    abstract String getDescription();
    abstract void display(String indentSpace);
}
