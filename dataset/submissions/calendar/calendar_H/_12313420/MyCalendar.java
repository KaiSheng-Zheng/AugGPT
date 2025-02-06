import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < this.capacity) {
            events.add(new MyEvent(date, eventName));
            Collections.sort(events);
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        } else {
            MyEvent event = this.events.remove(0);
            return event.getEventName();
        }
    }
}