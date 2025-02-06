import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    private int capacity;
    private List<Event> events;
    public MyCalendar (int capacity){
        this.capacity = capacity;
        this.events= new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() >= capacity) {
            // Capacity exceeded
            return false;
        }

        Event newEvent = new Event(date, eventName);
        int insertIndex = 0;
        for (Event event : events) {
            if (newEvent.compareTo(event) > 0) {
                insertIndex++;
            } else {
                break;
            }
        }
        events.add(insertIndex, newEvent);

        return true;
    }

    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        }

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

       
        public int compareTo(Event other) {
            if (this.date.equals(other.date)) {
                return this.eventName.compareTo(other.eventName);
            }
            return this.date.toString().compareTo(other.date.toString());
        }
    }
}