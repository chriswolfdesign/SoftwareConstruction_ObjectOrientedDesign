package model;

public abstract class Book {
    private String title;
    private double price;
    private Box box;

    private static final double FLAT_RATE_SHIPPING = 2.00;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.box = null; // book starts off unpackaged
    }

    // REQUIRES: model.Box must be medium or large
    // MODIFIES: this
    // EFFECTS:  If the book fits in the given box, then the two are associated (the book is packaged).
    abstract Box packageBook(Box b);

    public String getTitle() {
        return title;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    // EFFECTS: Returns the flat rate for shipping a standard sized book
    public double calculateShipping() {
        return FLAT_RATE_SHIPPING;
    }

    // EFFECTS: returns the minimum required size of box for packaging this book
    public abstract String getMinBoxSize();
}
