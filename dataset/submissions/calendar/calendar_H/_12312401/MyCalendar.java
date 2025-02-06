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
        events.add(new Event(date, eventName));
        return true;
    }

    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        }
        Collections.sort(events);
        Event nextEvent = events.remove(0);
        return nextEvent.getEventName();
    }

    private static class Event implements Comparable<Event> {
        private MyDate date;
        private String eventName;

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }

        public String getEventName() {
            return eventName;
        }

        @Override
        public int compareTo(Event other) {
            int dateComparison = date.compareTo(other.date);
            if (dateComparison != 0) {
                return dateComparison;
            }
            return eventName.compareTo(other.eventName);
        }
    }
}
