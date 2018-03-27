package tests;

import model.Animal;
import exceptions.AllergyException;
import exceptions.NotHungry;


import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

public class AnimalTest {

	@Test
	public void eatIsHungryNotAllergic() {
		// expecting eatenTimes to be 1, and no exceptions to be thrown
		Animal animal = new Animal(true, false);
		int eatenTimes = 0;
		try {
			eatenTimes = animal.eat();
		} catch(AllergyException ae) {
			fail("Got AllergyException, should not have");
		} catch(NotHungry nh) {
			fail("Got NotHungry, should not have");
		}
		assertTrue(eatenTimes == 1);
	}

	@Test
    public void eatNotHungryNotAllergic() {
	    // expecting a notHungry to be thrown, eatenTimes should be 0
        Animal animal = new Animal(false, false);
        int eatenTimes = 0;

        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Got AllergyException, should not have");
        } catch (NotHungry notHungry) {
            // Do nothing, this should be caught
        }
        assertTrue(eatenTimes == 0);
    }

    @Test
    public void eatIsHungryIsAllergic() {
	    // expecting an AllergicException to be thrown, eatenTimes should be 0
        Animal animal = new Animal(true, true);
        int eatenTimes = 0;

        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            // Do nothing, this should be caught
        } catch (NotHungry notHungry) {
            fail("Got NotHungry, should not have");
        }
        assertTrue(eatenTimes == 0);
    }

    @Test
    public void eatNotHungryIsAllergic() {
        // expecting a NotHungry to be thrown, eatenTimes should be 0
        Animal animal = new Animal(false, true);
        int eatenTimes = 0;

        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Got AllergyException, should not have");
        } catch (NotHungry notHungry) {
            // Do nothing, this should be caught
        }
    }
}

