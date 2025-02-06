import java.util.ArrayList;

public class MyCalendar {
    int t = 0;
    private int capacity;

    public MyCalendar(final int capacity) {
        this.capacity = capacity;
    }

    private ArrayList<Event> eventArrayList = new ArrayList<>();

    public boolean addEvent(MyDate date, String eventName) {
        if (t < capacity) {
            Event event = new Event(date, eventName);
            eventArrayList.add(event);
            t++;
            return true;
        } else {
            return false;
        }
    }

    private int g = 0;
    private int f = 0;

    public String finishNextEvent() {
        if (g != 0 || (g == 0 && f != 0)) {
            eventArrayList.remove(g);
            g = 0;
        }
        if (eventArrayList.isEmpty()) {
            return "NONE";
        }
        if (eventArrayList.size() == 1) {
            g = 0;
            t--;
            return eventArrayList.get(g).getEventName();
        } else {
            for (int i = 0; i < eventArrayList.size(); i++) {
                if (MyDate.difference(eventArrayList.get(i).getDate(), eventArrayList.get(g).getDate()) < 0) {
                    g = i;
                }
                for (int j = 0; j < eventArrayList.size(); j++) {
                    if (MyDate.difference(eventArrayList.get(j).getDate(), eventArrayList.get(i).getDate()) == 0 && j != i) {
                        if (eventArrayList.get(j).getEventName().compareTo(eventArrayList.get(i).getEventName()) < 0) {
                            g = j;
                        }
                    }
                }
            }
            f++;
            t--;
            return eventArrayList.get(g).getEventName();
        }
    }
    static class Event {
        private final MyDate date;
        private final String eventName;

        public String getEventName() {
            return eventName;
        }

        public MyDate getDate() {
            return date;
        }

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }
    }
}