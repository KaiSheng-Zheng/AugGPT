import java.util.Arrays;

public class MyCalendar {
    private int capacity;
    private Event[] events;
    private int count;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new Event[capacity];
        count = 0;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (count >= capacity) {
            return false;
        }

        Event event = new Event(date, eventName);
        events[count] = event;
        count++;

        return true;
    }

    public String finishNextEvent() {
        if (count == 0) {
            return "NONE";
        }

        Arrays.sort(events, 0, count);

        String nextEvent = events[0].eventName;

        for (int i = 0; i < count - 1; i++) {
            events[i] = events[i + 1];
        }

        count--;

        return nextEvent;
    }

    private class Event implements Comparable<Event> {
        private MyDate date;
        private String eventName;

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
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

