import java.util.ArrayList;
import java.util.Collections;
public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;
    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < capacity) {
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
            return events.remove(0).eventName;
        }
    }
}
class MyEvent implements Comparable<MyEvent> {
    MyDate date;
    String eventName;

    @Override
    public int compareTo(MyEvent o) {
        if (MyDate.difference(date, o.date) != 0) {
            return MyDate.difference(date, o.date);
        } else {
            return eventName.compareTo(o.eventName);
        }
    }
    public MyEvent(MyDate date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }
}

