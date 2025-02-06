import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        Collections.sort(events);

        Event nextEvent = events.remove(0);
        return nextEvent.getName();
    }

    private static class Event implements Comparable<Event> {
        private MyDate date;
        private String name;

        public Event(MyDate date, String name) {
            this.date = date;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int compareTo(Event other) {
            int dateComparison = date.compareTo(other.date);
            if (dateComparison != 0) {
                return dateComparison;
            }
            return name.compareTo(other.name);
        }
    }
}