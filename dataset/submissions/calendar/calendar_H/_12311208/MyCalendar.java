import java.util.*;

public class MyCalendar {
    private int capacity;
    private TreeMap<MyDate, List<String>> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new TreeMap<>(Comparator.comparing(MyDate::toString));
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.values().stream().mapToInt(List::size).sum() >= capacity) {
            return false;
        }

        events.computeIfAbsent(date, k -> new ArrayList<>()).add(eventName);
        return true;
    }

    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        }

        MyDate firstDate = events.firstKey();
        List<String> eventList = events.get(firstDate);

        String nextEvent = eventList.remove(0);
        if (eventList.isEmpty()) {
            events.remove(firstDate);
        }

        return nextEvent;
    }
}