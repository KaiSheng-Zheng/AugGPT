

import java.util.*;

public class MyCalendar {
    private int capacity;
    private List<Event> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() >= capacity) {
            return false;
        }
        Event event = new Event(date, eventName);
        events.add(event);
        return true;
    }

    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        }
        Collections.sort(events, new EventComparator());
        Event nextEvent = events.remove(0);
        return nextEvent.getEventName();
    }

    private static class Event {
        private MyDate date;
        private String eventName;

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }
        public MyDate getDate() {
            return date;
        }
        public String getEventName() {
            return eventName;
        }
    }
    private static class EventComparator implements Comparator<Event> {
        public int compare(Event event1, Event event2) {
            int dateComparison = event1.getDate().compareTo(event2.getDate());
            if (dateComparison != 0) {
                return dateComparison;
            }
            return event1.getEventName().compareTo(event2.getEventName());
        }
    }
}
