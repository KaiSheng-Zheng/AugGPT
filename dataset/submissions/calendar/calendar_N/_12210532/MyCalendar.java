import java.util.PriorityQueue;

public class MyCalendar {
    private int capacity;
    private PriorityQueue<Event> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new PriorityQueue<>();
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
        return events.poll().eventName;
    }

    private static class Event implements Comparable<Event> {
        private MyDate date;
        private String eventName;

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }

        @Override
        public int compareTo(Event o) {
            int dateComparison = MyDate.difference(this.date, o.date);
            if (dateComparison == 0) {
                return this.eventName.compareTo(o.eventName);
            }
            return dateComparison;
        }
    }
}
