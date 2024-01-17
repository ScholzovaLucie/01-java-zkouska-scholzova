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
public class ESet implements Comparable<ESet> {
    public Date date;
    public Set<Event> eventSet;

    public ESet() {
        eventSet = new HashSet<>();
    }

    public ESet(Date date) {
        this.date = date;
        this.eventSet = new HashSet<>();
    }

    @Override
    public int compareTo(ESet comperedESet) {
        return date.compareTo(comperedESet.date);
    }
    
}
