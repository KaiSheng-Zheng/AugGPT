import java.util.*;

public class MyCalendar {
    private int capacity;
    private int currentEventCount = 0;
    private TreeMap<MyDate, List<String>> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new TreeMap<>();
    }


    public boolean addEvent(MyDate date, String eventName) {
        if (currentEventCount >= capacity) {
            return false;
        }

        List<String> eventList;
        if (events.containsKey(date)) {
            eventList = events.get(date);
        } else {
            eventList = new ArrayList<String>();
            events.put(date, eventList);
        }
        eventList.add(eventName);
        Collections.sort(eventList);

        currentEventCount++;
        return true;
    }


    public String finishNextEvent() {
        if (currentEventCount == 0) {
            return "NONE";
        }

        Map.Entry<MyDate, List<String>> firstEntry = events.firstEntry();
        List<String> eventList = firstEntry.getValue();
        String nextEvent = eventList.remove(0);

        currentEventCount--;

        if (eventList.isEmpty()) {
            events.pollFirstEntry();
        }

        return nextEvent;
    }
}
