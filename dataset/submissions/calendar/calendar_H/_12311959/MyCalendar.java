import java.util.TreeMap;
import java.util.PriorityQueue;

public class MyCalendar {
    private TreeMap<MyDate, PriorityQueue<String>> events; // TreeMap to store events
    private int capacity; // Maximum capacity of events

    // Constructor
    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new TreeMap<>(); // TreeMap for automatic sorting by date
    }

    // Add an event
    public boolean addEvent(MyDate date, String eventName) {
        // Check if the capacity is exceeded
        if (events.values().stream().mapToInt(PriorityQueue::size).sum() >= capacity) {
            return false;
        }

        // Get or create a queue of events for the given date
        PriorityQueue<String> eventQueue = events.computeIfAbsent(date, k -> new PriorityQueue<>());
        eventQueue.add(eventName); // Add the event
        return true;
    }

    // Finish the next event
    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE"; // Return "NONE" if no events left
        }

        MyDate nextDate = events.firstKey(); // Get the earliest date
        PriorityQueue<String> eventQueue = events.get(nextDate); // Get the queue for this date

        String nextEvent = eventQueue.poll(); // Remove and return the next event
        if (eventQueue.isEmpty()) {
            events.remove(nextDate); // Remove the date if no more events
        }
        return nextEvent;
    }
}
