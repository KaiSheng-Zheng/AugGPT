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
        // Check if the calendar's capacity has been exceeded
        if (events.size() >= capacity) {
            return false;
        }

        // Add the event to the list
        events.add(new Event(date, eventName));

        // Sort the events by date and then by name
        Collections.sort(events);

        return true;
    }

    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        }

        // Remove and return the name of the next event
        Event nextEvent = events.remove(0);
        return nextEvent.eventName;
    }

    private static class Event implements Comparable<Event> {
        private MyDate date;
        private String eventName;

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }

        @Override
        public int compareTo(Event other) {
            // Compare events first by date, then by name
            int dateComparison = MyDate.difference(this.date, other.date);
            if (dateComparison != 0) {
                return dateComparison;
            }
            return this.eventName.compareTo(other.eventName);
        }
    }
}