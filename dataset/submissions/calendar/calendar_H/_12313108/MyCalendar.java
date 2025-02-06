import java.util.ArrayList;

public class MyCalendar {
    int capacity;
    ArrayList<Event> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (capacity == events.toArray().length) return false;
        events.add(new Event(date,eventName));
        return true;
    }

    public String finishNextEvent() {
        if (events.toArray().length == 0) return "NONE";
        Event e = events.get(0);
        for (int i = 0; i < events.toArray().length; i++) {
            if (MyDate.difference(e.getDate(),events.get(i).getDate()) == 0) {
                if (e.toString().compareTo(events.get(i).toString()) > 0) {
                    e = events.get(i);
                }
            } else if(MyDate.difference(e.getDate(),events.get(i).getDate()) > 0) {
                e = events.get(i);
            }
        }
        String name = e.toString();
        events.remove(e);
        return name;
    }
}

class Event {
    private final MyDate date;
    private final String eventName;

    public Event(MyDate date,String eventName) {
        this.eventName = eventName;
        this.date = date;
    }

    public MyDate getDate() {
        return date;
    }

    public String toString() {
        return eventName;
    }
}