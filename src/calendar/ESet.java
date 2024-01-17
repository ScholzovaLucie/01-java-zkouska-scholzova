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
    public Set<Event> evset;

    public ESet() {
        evset = new HashSet<>();
    }

    public ESet(Date date) {
        this.date = date;
        this.evset = new HashSet<>();
    }

    @Override
    public int compareTo(ESet o) {
        return date.compareTo(o.date);
    }
    
}
