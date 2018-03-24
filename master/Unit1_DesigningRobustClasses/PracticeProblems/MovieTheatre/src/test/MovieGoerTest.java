package test;

import exceptions.ShowingFullException;
import exceptions.UnderAgeException;
import model.Movie;
import model.MovieGoer;
import model.Ticket;
import model.TicketKiosk;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieGoerTest {

    private Movie m1, m2;
    private MovieGoer mg1, mg2;
    private Ticket t1, t2;
    private TicketKiosk tk;

    @Before
    public void setUp() {
        tk = new TicketKiosk("Scotiabank Theatre");
        mg1 = new MovieGoer("Tom Hanks", 28, tk);
        mg2 = new MovieGoer("Sarah Johnson", 17, tk);
        m1 = new Movie("Arrival", 19, 50);
        m2 = new Movie("Ratatouille", 0, 100);
        t1 = new Ticket(m1);
        t2 = new Ticket(m2);
    }

    @Test
    public void testGetters() {
        assertEquals(mg1.getName(),"Tom Hanks");
        assertEquals(mg2.getName(),"Sarah Johnson");
        assertEquals(mg1.getAge(),28);
        assertEquals(mg2.getAge(),17);
        assertEquals(mg1.getTicketKiosk(), tk);
        assertEquals(mg2.getTicketKiosk(), tk);
    }

    @Test
    public void testBuyTicketNoExceptionsThrown() {
        // Should not catch any errors, movie's current seating should be 1
        try {
            mg1.buyTicket(m1);
        } catch (ShowingFullException e) {
            fail("Caught ShowingFullException, should not have");
            e.printStackTrace();
        } catch (UnderAgeException e) {
            fail("Caught UnderAgeException, should not have");
            e.printStackTrace();
        }

        assertEquals(1, m1.getCurrentSeating());
    }

    @Test
    public void testBuyTicketUnderAgeException() {
        // Should catch UnderAgeException, movie's current seating should be 0
        try {
            mg2.buyTicket(m1);
        } catch (ShowingFullException e) {
            fail("Caught ShowingFullException, should not have");
            e.printStackTrace();
        } catch (UnderAgeException e) {
            // Do nothing, expecting this
        }

        assertEquals(0, m1.getCurrentSeating());
    }

    @Test
    public void testBuyTicketShowingFullException() {
        // Should catch ShowingFullException, movie's current seating should be 100
        for(int i = 0; i < 100; i++) {
            try {
                mg2.buyTicket(m2);
            } catch (ShowingFullException e) {
                fail("Caught ShowingFullException, should not have");
                e.printStackTrace();
            } catch (UnderAgeException e) {
                fail("Caught UnderAgeException, should not have");
                e.printStackTrace();
            }

        }

        try {
            mg2.buyTicket(m2);
        } catch (ShowingFullException e) {
            // Do nothing, expecting this
        } catch (UnderAgeException e) {
            fail("Caught UnderAgeException, should not have");
            e.printStackTrace();
        }

        assertEquals(100, m2.getCurrentSeating());
    }


}