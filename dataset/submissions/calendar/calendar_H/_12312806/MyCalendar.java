import java.util.*;
public class MyCalendar {
    private int capacity;
    private TreeMap<MyDate, PriorityQueue<String>> events;
    public MyCalendar(int capacity){
        this.capacity = capacity;
        this.events = new TreeMap<>();
    }
    public int getTotalEventsSize() {
        int totalSize = 0;
        for (PriorityQueue<String> eventList : events.values()) {
            totalSize += eventList.size();
        }
        return totalSize;
    }
    public boolean addEvent(MyDate date, String eventName) {
        if (events.containsKey(date)) {
            PriorityQueue<String> eventList = events.get(date);
            if (getTotalEventsSize() >= capacity) {
                return false;
            }
            eventList.offer(eventName);
        } else {
            if (getTotalEventsSize() >= capacity) {
                return false;
            }
            PriorityQueue<String> eventList = new PriorityQueue<>();
            eventList.offer(eventName);
            events.put(date, eventList);
        }return true;
    }
    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        }
        Map.Entry<MyDate, PriorityQueue<String>> firstEntry = events.firstEntry();
        MyDate date = firstEntry.getKey();
        PriorityQueue<String> eventList = firstEntry.getValue();

        String nextEvent = eventList.poll();
        if (eventList.isEmpty()) {
            events.remove(date);
        }
        return nextEvent;
    }
}
