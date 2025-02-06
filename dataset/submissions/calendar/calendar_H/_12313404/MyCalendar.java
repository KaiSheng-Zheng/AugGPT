import java.util.Objects;
import java.util.PriorityQueue;

public class MyCalendar {

    static class Event implements Comparable<Event> {

        private final MyDate date;
        private final String event;

        public Event(MyDate date, String event) {
            this.date = date;
            this.event = event;
        }

        @Override
        public int compareTo(Event o) {
            return date.compareTo(o.date) == 0 ? event.compareTo(o.event) : date.compareTo(o.date);
        }

    }

    private final PriorityQueue<Event> queue;
    private int count = 0;
    private final int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.queue = new PriorityQueue<>(capacity);
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (count == capacity) {
            return false;
        }
        count++;
        queue.add(new Event(date, eventName));
        return true;
    }

    public String finishNextEvent() {
        if (count == 0) {
            return "NONE";
        }
        count--;
        return Objects.requireNonNull(queue.poll()).event;
    }

}
