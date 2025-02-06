import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MyCalendar {
    private int capacity;
    private Map<MyDate, List<String>> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new HashMap<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() >= capacity) {
            return false;
        }

        events.computeIfAbsent(date, k -> new ArrayList<>()).add(eventName);
        return true;
    }


    public String finishNextEvent() {

        for (MyDate date : events.keySet()) {
            List<String> eventList = events.get(date);


            if (!eventList.isEmpty()) {
                String nextEvent = eventList.remove(0);

                if (eventList.isEmpty()) {
                    events.remove(date);
                }
                return nextEvent;
            }
        }


        return "NONE";
    }
}

