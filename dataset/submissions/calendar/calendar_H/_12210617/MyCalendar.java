import java.util.PriorityQueue;
public class MyCalendar {
    private final PriorityQueue<MyDate> events;
    private final int capacity;
    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new PriorityQueue<>();
    }
    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() >= capacity) {
            return false;
        }
        events.add(date);
        return true;
    }
    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        }
        MyDate firstEvent = events.poll();
        return firstEvent.getEventName();
    }
}