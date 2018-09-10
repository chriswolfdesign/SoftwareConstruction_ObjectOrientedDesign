package test;

import exceptions.*;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CoffeeMakerTest {

    CoffeeMaker maker;

    @Before
    public void setUp(){
        maker = new CoffeeMaker();
    }

    @Test
    public void testGetCupsRemaining() {
        assertEquals(0, maker.getCupsRemaining());
    }

    @Test
    public void testGetTimeSinceLastBrewed() {
        assertEquals(61, maker.getTimeSinceLastBrew());
    }

    @Test
    public void testSetCupsRemaining() {
        assertEquals(0, maker.getCupsRemaining());
        maker.setCupsRemaining(5);
        assertEquals(5, maker.getCupsRemaining());
    }

    @Test
    public void testSetTimeSinceLastBrewed() {
        assertEquals(61, maker.getTimeSinceLastBrew());
        maker.setTimeSinceLastBrew(20);
        assertEquals(20, maker.getTimeSinceLastBrew());
    }

    @Test
    public void testThereAreFiveCupsRemaining() {
        maker.setCupsRemaining(5);
        assertTrue(maker.areCupsRemaining());
    }

    @Test
    public void testThereIsOneCupRemaining() {
        maker.setCupsRemaining(1);
        assertTrue(maker.areCupsRemaining());
    }

    @Test
    public void testThereAreNoCupsRemaining() {
        assertFalse(maker.areCupsRemaining());
    }

    @Test
    public void testBrewCorrectBeansAndCorrectWater() {
        // Expecting to run completely, cups == 20, timeSinceBrewed == 0
        try {
            maker.brew(2.5, 15);
        } catch (BeansAmountException e) {
            System.out.println(e.getMessage());
            fail("Caught BeansAmountException, should not have");
        } catch (WaterException e) {
            System.out.println(e.getMessage());
            fail("Caught WaterException, should not have");
        }

        assertEquals(20, maker.getCupsRemaining());
        assertEquals(0, maker.getTimeSinceLastBrew());
    }

    @Test
    public void testBrewTooFewBeansAndCorrectWater() {
        // Expecting NotEnoughBeansException, cups == 0, timeSinceBrewed == 61
        try {
            maker.brew(2, 15);
        } catch (TooManyBeansException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (NotEnoughBeansException e) {
            // Do nothing, expecting this
        } catch (WaterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        testThatCupsAndTimeAreDefault();
    }


    @Test
    public void testBrewTooManyBeansAndCorrectWater() {
        // Expecting TooManyBeansException, cups == 0, timeSinceBrewed == 61
        try {
            maker.brew(1, 15);
        } catch (NotEnoughBeansException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (TooManyBeansException e) {
            // Do nothing, expecting this
        } catch (WaterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        testThatCupsAndTimeAreDefault();
    }

    @Test
    public void testBrewCorrectBeansAndNotEnoughWater() {
        // Expecting WaterException, cups == 0, timeSinceBrewed = 61
        try {
            maker.brew(2.5, 10);
        } catch (NotEnoughBeansException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (TooManyBeansException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (WaterException e) {
            // Do nothing, expecting this
        }

        testThatCupsAndTimeAreDefault();
    }

    @Test
    public void testBrewNotEnoughBeansAndNotEnoughWater() {
        // Expecting NotEnoughBeansException, cups == 0, timeSinceBrewed == 61
        try {
            maker.brew(2, 10);
        } catch (NotEnoughBeansException e) {
            // Do nothing, expecting this
        } catch (TooManyBeansException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (WaterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        testThatCupsAndTimeAreDefault();
    }

    @Test
    public void testBrewTooManyBeansAndNotEnoughWater() {
        // Expecting TooManyBeansException, cups == 0, timeSinceBrewed == 61
        try {
            maker.brew(3, 10);
        } catch (NotEnoughBeansException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (TooManyBeansException e) {
            // Do nothing, expecting this
        } catch (WaterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        testThatCupsAndTimeAreDefault();
    }

    @Test
    public void testPourHaveCupsCoffeeNotStale() {
        // Expecting pour to run completely, cups == 14, timeSinceBrewed == 30
        maker.setCupsRemaining(15);
        maker.setTimeSinceLastBrew(30);
        try {
            maker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (StaleCoffeeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        assertEquals(14, maker.getCupsRemaining());
        assertEquals(30, maker.getTimeSinceLastBrew());
    }

    @Test
    public void testPourNoCupsRemainingCoffeeNotStale() {
        // Expecting NoCupsRemainingException, cups == 0, timeSinceBrewed == 30
        maker.setTimeSinceLastBrew(30);
        try {
            maker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            // Do nothing, expecting this
        } catch (StaleCoffeeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        assertEquals(0, maker.getCupsRemaining());
        assertEquals(30, maker.getTimeSinceLastBrew());
    }

    @Test
    public void testPourHaveCupsCoffeeStale() {
        // Expecting StaleCoffeeException, cups == 15, timeSinceBrewed == 61
        maker.setCupsRemaining(15);
        try {
            maker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (StaleCoffeeException e) {
            // Do nothing, expecting this
        }

        assertEquals(15, maker.getCupsRemaining());
        assertEquals(61, maker.getTimeSinceLastBrew());
    }

    @Test
    public void testPourNoCupsCoffeeStale() {
        // Expecting NoCupsRemainingException, cups == 0, timeSinceBrewed == 61
        try {
            maker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            // Do nothing, expecting this
        } catch (StaleCoffeeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        assertEquals(0, maker.getCupsRemaining());
        assertEquals(61, maker.getTimeSinceLastBrew());
    }

    // HELPERS
    private void testThatCupsAndTimeAreDefault() {
        assertEquals(0, maker.getCupsRemaining());
        assertEquals(61, maker.getTimeSinceLastBrew());
    }
}
