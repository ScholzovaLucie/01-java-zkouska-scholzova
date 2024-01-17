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

    @Override
    public Iterator<ESet> iterator() {
        return calendar.iterator();
    }
    
    
    private Tree<ESet> calendar;

    public Calendar() {
        calendar = new Tree<>();
    }
    
    
    
    public void addEv(Event ev) {
        ESet es = new ESet(ev.getDate());
        if (calendar.contaix(es)) {
            es = calendar.get(es);
        } else {
            calendar.add(es);
        }
        
        es.evset.add(ev);
    }
    
    public ESet eventsList(Date date) {
        return calendar.get(new ESet(date));
    }
    
    public void DeleteAll(Date date) {
        calendar.erase(new ESet(date));
    }
    
    
}
