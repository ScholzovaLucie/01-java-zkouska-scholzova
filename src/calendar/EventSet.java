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

    @Override
    public int compareTo(EventSet comperedESet) {
        return date.compareTo(comperedESet.date);
    }
    
}
