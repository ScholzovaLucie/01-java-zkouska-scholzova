/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author rodi0878
 */
public class Calendar implements Iterable<EventSet>{

    private final Tree<EventSet> calendar;

    public Calendar() {
        calendar = new Tree<>();
    }

    /**
     * Method returns an iterator to iterate over all EventSets in the calendar.
     *
     * @return Iterator to iterate over EventSets in the calendar.
     */
    @Override
    public Iterator<EventSet> iterator() {
        return calendar.iterator();
    }
    
    /**
     * Method adds an event to the calendar. It creates a new EventSet for the given date,
     * adds it to the tree, and adds the given event to the corresponding EventSet.
     *
     * @param event Event to be added to the calendar.
     */
    public void addEvent(Event event) {
        EventSet eventSet = new EventSet(event.getDate());
        if (calendar.contains(eventSet)) {
            eventSet = calendar.get(eventSet);
        } else {
            calendar.add(eventSet);
        }
        
        eventSet.eventSet.add(event);
    }
    
    /**
     * Method returns the EventSet containing all events for the given date.
     *
     * @param date Date to search for events.
     * @return EventSet containing events for the given date.
     */
    public EventSet getEvents(Date date) {
        return calendar.get(new EventSet(date));
    }
    
    /**
     * Method removes all events for the given date from the calendar.
     *
     * @param date Date to remove events for.
     */
    public void deleteAllEvents(Date date) {
        calendar.erase(new EventSet(date));
    }
    
    
}
