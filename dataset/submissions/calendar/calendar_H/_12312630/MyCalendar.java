import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MyCalendar {
    private int capacity;
    private List<Event> events;
    private PriorityQueue<Event> eventQueue;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
        this.eventQueue = new PriorityQueue<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() >= capacity) {
            return false;
        }

        Event event = new Event(date, eventName);
        events.add(event);
        eventQueue.add(event);
        return true;
    }

    public String finishNextEvent() {
        if (eventQueue.isEmpty()) {
            return "NONE";
        }

        Event event = eventQueue.poll();
        events.remove(event);
        return event.getEventName();
    }

    private class Event implements Comparable<Event> {
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
            if (dateComparison == 0) {
                return eventName.compareTo(other.eventName);
            }
            return dateComparison;
        }
    }
}
