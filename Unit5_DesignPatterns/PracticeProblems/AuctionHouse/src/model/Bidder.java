package model;

import java.util.Random;

public class Bidder implements Observer {
    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    public Bidder(String name, double maxBid) {
        this.name = name;
        personalBid = 0;
        currentBid = 0;
        this.maxBid = maxBid;
    }


    public String getName() {
        return name;
    }

    public double getPersonalBid() {
        return personalBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public double getMaxBid() {
        return maxBid;
    }

    public void update(Subject auctioneer, Object arg) {
        Double newBid = (Double) arg;
        currentBid = newBid.doubleValue();

        if(currentBid < maxBid)
            makeBid(currentBid);
        else
            System.out.println("I can't bid any higher!");
    }

    public void makeBid(double currentBid) {
        Random rand = new Random();
        currentBid += rand.nextInt(10) + 1;
    }

}
