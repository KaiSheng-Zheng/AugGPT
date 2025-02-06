import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    private int eventCount;
    private final int capacity;

    private final List<String> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.eventCount = 0;
        this.events = new ArrayList<>(capacity);
    }

    public boolean addEvent(MyDate date, String eventName) {
        // add event to calendar
        // return true if successful, false if event capacity exceeded
        if (eventCount < capacity) {
            events.add(String.format("%s %s", date.toString(), eventName));
            eventCount++;
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        events.sort(String::compareTo);
        if (eventCount > 0) {
            eventCount--;
            return events.remove(0).substring(11);
        } else {
            return "NONE";
        }
    }
}