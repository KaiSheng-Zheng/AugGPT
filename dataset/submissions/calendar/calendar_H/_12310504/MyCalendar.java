import jdk.jfr.Event;

import java.time.LocalDate;
import java.util.*;

public class MyCalendar {
    private int capacity;
    private ArrayList<String> events;

    public MyCalendar(int capacity){
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if (events.size() < capacity) {
            events.add(date + "-" + eventName);
            return true;
        }
        else {
            return false;
        }

    }
    public String finishNextEvent(){
        if (events.isEmpty()) {
            return "NONE";
        }
        events.sort(Comparator.naturalOrder());
        String event1 = events.get(0);
        events.remove(0);
        return event1.substring(11);
    }
}

