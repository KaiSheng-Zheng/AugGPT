import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MyCalendar {
    private int capacity;
    private TreeMap<MyDate, List<String>> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new TreeMap<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        removeFinishedEvents();

        if (getRemainingCapacity() <= 0) {
            return false;
        }

        events.computeIfAbsent(date, k -> new ArrayList<>()).add(eventName);
        return true;
    }
    public String finishNextEvent() {
        removeFinishedEvents();
        if (events.isEmpty()) {
            return "NONE";
        }
        MyDate nextDate = events.firstKey();
        List<String> eventsOnDate = events.get(nextDate);
        if (eventsOnDate.isEmpty()) {
            events.remove(nextDate);
            return finishNextEvent();
        }
       
        eventsOnDate.sort(String::compareTo);
        String nextEvent = eventsOnDate.get(0);
        eventsOnDate.remove(0);
        return nextEvent;
    }


    public int getRemainingCapacity() {
        int usedCapacity = events.values().stream().mapToInt(List::size).sum();
        return capacity - usedCapacity;
    }

    private void removeFinishedEvents() {
        for (List<String> eventsOnDate : events.values()) {
            eventsOnDate.removeIf(event -> event.endsWith(" (finished)"));
        }
        events.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }

}