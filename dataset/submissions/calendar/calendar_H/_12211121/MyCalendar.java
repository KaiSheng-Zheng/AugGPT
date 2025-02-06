
import java.util.*;

public class MyCalendar {
    private final int capacity;
    private int size;
    TreeMap<MyDate, ArrayList<String>> events;

    // Create a new calendar with the maximum number of events specified by capacity
    // i.e., the number of events in this calendar cannot exceed capacity.
    public MyCalendar(int capacity){
        this.capacity = capacity;
        events = new TreeMap<>();
        size = 0;
    }
    // This method adds an event with name eventName to a given date.
    // If the calendar's capacity has been exceeded, return false; otherwise return true.
    public boolean addEvent(MyDate date, String eventName){
        if (size >= capacity) {
            return false;
        } else {
            if (events.containsKey(date)) {
                events.get(date).add(eventName);
            } else {
                ArrayList<String> eventList = new ArrayList<>();
                eventList.add(eventName);
                events.put(date, eventList);
            }
            size++;
            return true;
        }
    }
    // A calendar may have several events. Whenever we call finishNextEvent()
    // The return value of this method is the name of the next event.
    // For example, the first time finishNextEvent() is called, it returns the earliest event's name; the second time finishNextEvent() is called, it returns the second-earliest event's name, and so on.
    // If there are multiple events on the same date, these events should be returned by their alphabetical order (lexicographically). For example, "laundry" should be returned before "meeting", because "laundry" precedes "meeting" in alphabetical order (You may check the String.compareTo method for comparing strings lexicographically).
    // If all events have already been returned (finished), this method should return "NONE".
    // Note that, capacity refer to only unfinished events; finished events do not count for the capacity.
    public String finishNextEvent() {
        if (size == 0) {
            return "NONE";
        } else {
            ArrayList<String> eventList = events.get(events.firstKey());
            Collections.sort(eventList);
            String result = eventList.get(0);
            events.get(events.firstKey()).remove(result);
            size--;
            if (eventList.isEmpty()) {
                events.remove(events.firstKey());
            }
            return result;
        }

    }


}
