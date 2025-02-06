import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MyCalendar {
    private int capacity;
    private int count;
    private Map<MyDate, List> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.events = new HashMap<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (count >= capacity) {
            return false;
        }

        List<String> eventList = events.getOrDefault(date, new ArrayList<>());
        eventList.add(eventName);
        Collections.sort(eventList);
        events.put(date, eventList);
        count++;

        return true;
    }

    public String finishNextEvent() {
        if (count == 0) {
            return "NONE";
        }

        MyDate earliestDate = null;
        for (MyDate date : events.keySet()) {
            if (earliestDate == null || date.compareTo(earliestDate) < 0) {
                earliestDate = date;
            }
        }

        List<String> eventList = events.get(earliestDate);
        String nextEvent = eventList.remove(0);
        count--;

        if (eventList.isEmpty()) {
            events.remove(earliestDate);
        }

        return nextEvent;
    }
}
