package calendar;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Roman
 */
public class Event implements Comparable<Event>, Serializable {

    private Date date;
    private String title;
  

    @Override
    public int compareTo(Event o) {
        return date.compareTo(o.date);
    }

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
    private String text;
  
    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.date);
        return hash;
    }
    @Override
    public String toString() {
        return "Event{" + "date=" + date + ", title=" + title + ", text=" + text + '}';
    }

}
