import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;


    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < capacity) {
            events.add(new MyEvent(date, eventName));
            Collections.sort(events);
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        if (this.events.isEmpty()) {
            return "NONE";
        } else {
            MyEvent e = this.events.remove(0);
            return e.getEventName();
        }
    }

    public class MyEvent implements Comparable<MyEvent>{
        private MyDate date;
        private String eventName;

        public MyEvent(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }

        public MyDate getDate() {
            return date;
        }

        public void setDate(MyDate date) {
            this.date = date;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        @Override
        public int compareTo(MyEvent o) {
            if (MyDate.difference(date,o.date) == 0) {
                return this.eventName.compareTo(o.eventName);
            } else {
                return MyDate.difference(date,o.date);
            }
        }

    }

}