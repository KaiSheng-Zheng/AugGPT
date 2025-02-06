import java.util.*;

class MyCalendar {
    private  int capacity;
    private  TreeMap<MyDate, List<String>>events=new TreeMap<>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;

    }

    public boolean addEvent(MyDate date, String eventName) {

            if (events.size() >= capacity) {
                return false; // Capacity exceeded
            } else {
                List<String> eventSet = new ArrayList<>();
                eventSet.add(eventName);
                events.put(date,eventSet);
                return true;
            }
        }


    public String finishNextEvent() {
        for (Map.Entry<MyDate, List<String>> entry : events.entrySet()) {
            List<String> eventList = entry.getValue();
            if (!eventList.isEmpty()) {
                String nextEvent = eventList.stream().min(String::compareTo).get();
                eventList.remove(nextEvent);
                if (eventList.isEmpty()) {
                    events.remove(entry.getKey());
                }
                return nextEvent;
            }
        }
        return "NONE";
    }
}
