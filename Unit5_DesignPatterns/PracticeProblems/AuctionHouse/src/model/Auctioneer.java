package model;

public class Auctioneer extends Subject {
    private String name;
    private double currentBid;

    public Auctioneer(String name) {
        this.name = name;
        currentBid = 0;
    }

    public String getName() {
        return name;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void acceptBid(double newBid) {
        if(newBid > currentBid) {
            currentBid = newBid;
            super.notifyObservers(this, currentBid);
        }
        else
            System.out.println("That bid isn't larger than the current bid!");
    }

}
