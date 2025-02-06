import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCalendar {
    private int capacity;
    private List<Event> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() >= capacity) {
            return false;
        }
        else{
            Event event = new Event(date, eventName);
            events.add(event);
            Collections.sort(events);
            return true;
         }
    }

    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        }
        else{
            Event event = events.get(0);
            events.remove(0);
            return event.eventName;
         }
    }

    private class Event implements Comparable<Event> {
        private MyDate date;
        private String eventName;

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }

        @Override
        public int compareTo(Event another) {
            int dateDifference = MyDate.difference(date, another.date);
            if (dateDifference != 0) {
                return dateDifference;
            }
            else{
                return eventName.compareTo(another.eventName);
            }
        }
    }
}