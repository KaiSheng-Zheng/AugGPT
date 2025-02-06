import java.util.*;
public class MyCalendar {
    private int capacity;
    private TreeMap<String, List<String>> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new TreeMap<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        String dateString = date.toString();

        if (!events.containsKey(dateString)) {
            events.put(dateString, new ArrayList<>());
        }

        List<String> eventsOnDate = events.get(dateString);
        if (capacity <= 0) {
            return false;
        }

        eventsOnDate.add(eventName);
        Collections.sort(eventsOnDate);
        this.capacity--;
        return true;
    }

    public String finishNextEvent() {
        for (Map.Entry<String, List<String>> entry : events.entrySet()) {
            List<String> eventsOnDate = entry.getValue();
            if (!eventsOnDate.isEmpty()) {
                String nextEvent = eventsOnDate.remove(0);
                if (eventsOnDate.isEmpty()) {
                    events.remove(entry.getKey());
                }
                this.capacity++;
                return nextEvent;
            }
        }
        return "NONE";
    }
}
