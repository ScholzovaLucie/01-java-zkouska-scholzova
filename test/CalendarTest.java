/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import calendar.Calendar;
import calendar.Event;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author st64176
 */
public class CalendarTest {
    private Calendar calendar;
    
    public CalendarTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        calendar = new Calendar();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
     @Test
    void testAddEventToEmptyCalendar() {
        Event event = new Event(new Date(), "Test Event");
        calendar.addEvent(event);
        assertNotNull(calendar.getEvents(event.getDate()));
        assertEquals(1, calendar.getEvents(event.getDate()).eventSet.size());
    }

    @Test
    void testAddEventToNonEmptyCalendar() {
        Date date = new Date();
        Event event1 = new Event(date, "Event 1");
        Event event2 = new Event(date, "Event 2");

        calendar.addEvent(event1);
        calendar.addEvent(event2);

        assertEquals(1, calendar.getEvents(date).eventSet.size());
    }

    @Test
    void testDeleteEventFromCalendar() {
        Date date = new Date();
        Event event = new Event(date, "Test Event");
        calendar.addEvent(event);

        calendar.deleteAllEvents(date);

        assertNull(calendar.getEvents(date));
    }

    @Test
    void testDeleteAllEventsOnDate() {
        Date date = new Date();
        Event event1 = new Event(date, "Event 1");
        Event event2 = new Event(date, "Event 2");

        calendar.addEvent(event1);
        calendar.addEvent(event2);

        calendar.deleteAllEvents(date);

        assertNull(calendar.getEvents(date));
    }


}
