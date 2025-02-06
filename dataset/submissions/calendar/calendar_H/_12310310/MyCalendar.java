
import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    public static class MyEvents implements Comparable<MyEvents> {
        private MyDate date;
        private String event;

        public MyEvents(MyDate date, String event) {
            this.date = date;
            this.event = event;
        }

        public MyDate getDate() {
            return date;
        }

        public void setDate(MyDate date) {
            this.date = date;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        @Override
        public int compareTo(MyEvents o) {
            if (this.date == o.date) {
                if (this.event.compareTo(o.event) == 0) {
                    return 0;
                } else if (this.event.compareTo(o.event) < 0) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (MyDate.difference(this.date, o.date) < 0) {
                return -1;
            } else {
                return 1;
            }

        }
    }

    public int capacity;
    private ArrayList<MyEvents> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();

    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < capacity) {
            events.add(new MyEvents(date, eventName));
            Collections.sort(events);
            return true;
        } else
            return false;

    }

    public String finishNextEvent() {
        if (this.events.isEmpty()) {
            return "NONE";
        } else {
            MyEvents e = this.events.remove(0);
            return e.getEvent();
        }
    }
}

