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

    private final Date date;
    private final String title;
    private String text;

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }

    /**
     * Compares this event with another event based on their dates.
     *
     * @param o The other event to compare to.
     * @return A negative integer, zero, or a positive integer as this event is
     *         before, at the same time, or after the specified event.
     */
    @Override
    public int compareTo(Event o) {
        return date.compareTo(o.date);
    }


    /**
     * Checks if this event is equal to another object.
     *
     * @param obj The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
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

    /**
     * Generates a hash code for this event based on its date.
     *
     * @return The hash code for this event.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.date);
        return hash;
    }
    
    /**
     * Returns a string representation of the event.
     *
     * @return A string containing the date, title, and text of the event.
     */
    @Override
    public String toString() {
        return "Event{" + "date=" + date + ", title=" + title + ", text=" + text + '}';
    }
  
    /**
     * Gets the date of the event.
     *
     * @return The date of the event.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the title of the event.
     *
     * @return The title of the event.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the additional text of the event.
     *
     * @return The text of the event.
     */
    public String getText() {
        return text;
    }

}
