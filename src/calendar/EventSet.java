/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rodi0878
 */
public class EventSet implements Comparable<EventSet> {
    public Date date;
    public Set<Event> eventSet;

    public EventSet() {
        eventSet = new HashSet<>();
    }

    public EventSet(Date date) {
        this.date = date;
        this.eventSet = new HashSet<>();
    }

    /**
     * Compares two EventSet objects based on their dates.
     * 
     * @param comparedEventSet The EventSet to compare with.
     * @return A negative integer, zero, or a positive integer as this EventSet
     *         is less than, equal to, or greater than the compared EventSet.
     */
    @Override
    public int compareTo(EventSet comparedEventSet) {
        return date.compareTo(comparedEventSet.date);
    }
    
}
