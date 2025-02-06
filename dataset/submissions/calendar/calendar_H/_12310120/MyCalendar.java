import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;
    public MyCalendar(int capacity){
        this.capacity = capacity;
        this.events = new ArrayList<MyEvent>();
    }
    public boolean addEvent(MyDate date, String eventName){
        boolean add = true;
        if(events.size() < capacity){
            MyEvent event = new MyEvent(date, eventName);
            events.add(event);
            add = true;
        }
        else
            add = false;
        return add;
    }
    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE";
        } else {
            MyEvent earliest = events.get(0);
            for (int i = 1; i < events.size(); i++) {
                if (earliest.getDate().compareTo(events.get(i).getDate()) > 0
                        || (earliest.getDate().compareTo(events.get(i).getDate()) == 0
                        && earliest.getEventName().compareTo(events.get(i).getEventName()) > 0)) {
                    earliest = events.get(i);
                }
            }
            events.remove(earliest);
            return earliest.getEventName();
        }
    }
}
