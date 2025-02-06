import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() >= capacity) return false;
        else {
            events.add(new MyEvent(date, eventName));
            return true;
        }
    }

    public String finishNextEvent() {
        if (events.isEmpty()) return "NONE";
        else {
            int index = 0;
            for (int i = 1; i < events.size(); i++) {
                if (MyDate.difference(events.get(index).getDate(), events.get(i).getDate()) > 0) index = i;
            }
            ArrayList<MyEvent> events1 = new ArrayList<>();
            ArrayList<Integer> indexes=new ArrayList<>();
            for (int i = 0; i < events.size(); i++) {
                if (events.get(i).getDate().getYear() == events.get(index).getDate().getYear() && events.get(i).getDate().getMonth() == events.get(index).getDate().getMonth() && events.get(i).getDate().getDay() == events.get(index).getDate().getDay()) {
                    events1.add(events.get(i));
                    indexes.add(i);
                }
            }
            if (events1.size() == 1) {
                String nextEvent = events.get(index).getEventName();
                events.remove(index);
                return nextEvent;
            } else {
                int index1 = 0;
                for (int i = 1; i < events1.size(); i++) {
                    if (events1.get(index1).getEventName().compareTo(events1.get(i).getEventName()) > 0) index1 = i;
                }
                String nextEvent = events1.get(index1).getEventName();
                events.remove(indexes.get(index1).intValue());
                return nextEvent;
            }
        }
    }
}
