/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.Date;
import java.util.List;
import persistence.Storage;

/**
 *
 * @author Roman
 */
public class INPTP_Clean00 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* TODO:
         0) vytvořit git repozitář a COMMITovat každou dílčí ucelenou změnu!
         1) vyčistit kód (clean code)
         2) unit testy
         ---- je nutné důkladně otestovat binární strom
         ---- přidání do prázdného, neprázdného stromu (levá/pravá větev)
         ---- mazání - kořene, listu, vnitřních prvků
         ---- iterování přes prázdný/plný strom
         ---- testy kalendáře, skupiny událostí
         3) celý repozitář odevzdat na stag - semestrální práce
         */

        Storage s = new Storage();
        s.store(new Event(new Date(117, 6, 1), "1-4"));
        s.store(new Event(new Date(117, 7, 1), "1-4"));
        s.unstore(new Event(new Date(117, 6, 1), "1-4"));

        List<Event> ll = s.load(Event.class);
        System.out.println(ll);
        System.out.println("");

        //////////////////////////////////
        
        Calendar c = new Calendar();
        c.addEv(new Event(new Date(117, 6, 1), "1-1"));
        c.addEv(new Event(new Date(117, 6, 2), "2-1"));
        c.addEv(new Event(new Date(117, 6, 3), "3-1"));
        c.addEv(new Event(new Date(117, 6, 1), "1-2"));
        c.addEv(new Event(new Date(117, 6, 1), "1-3"));
        c.addEv(new Event(new Date(117, 6, 1), "1-4"));

        for (ESet c1 : c) {
            System.out.println(c1.date);
            System.out.println(c1.evset);
        }

        c.DeleteAll(new Date(117, 6, 1));
        System.out.println("");

        for (ESet c1 : c) {
            System.out.println(c1.date);
            System.out.println(c1.evset);
        }

    }

}
