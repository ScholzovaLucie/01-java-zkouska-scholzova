/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author rodi0878
 */
public class Calendar implements Iterable<ESet>{

    private Tree<ESet> calendar;

    public Calendar() {
        calendar = new Tree<>();
    }

    @Override
    public Iterator<ESet> iterator() {
        return calendar.iterator();
    }
    
    public void addEv(Event event) {
        ESet eventESet = new ESet(event.getDate());
        if (calendar.contaix(eventESet)) {
            eventESet = calendar.get(eventESet);
        } else {
            calendar.add(eventESet);
        }
        
        eventESet.eventSet.add(event);
    }
    
    public ESet eventsList(Date date) {
        return calendar.get(new ESet(date));
    }
    
    public void deleteAll(Date date) {
        calendar.erase(new ESet(date));
    }
    
    
}
