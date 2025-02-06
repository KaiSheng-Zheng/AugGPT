import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCalendar {
    private int capacity;
    private List<Event> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() >= capacity) {
            return false; 
        }

        Event newEvent = new Event(date, eventName);
        events.add(newEvent);

        Collections.sort(events, new EventComparator()); 

        return true;
    }

    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE"; 
        }

        Event nextEvent = events.remove(0);
        return nextEvent.getEventName();
    }

    private static class Event {
        private MyDate date;
        private String eventName;

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }

        public String getEventName() {
            return eventName;
        }

        public MyDate getDate() {
            return date;
        }
    }

    private static class EventComparator implements Comparator<Event> {
        @Override
        public int compare(Event event1, Event event2) {
            MyDate date1 = event1.getDate();
            MyDate date2 = event2.getDate();

            int dateComparison = compareDates(date1, date2);
            if (dateComparison != 0) {
                return dateComparison;
            }

            return event1.getEventName().compareTo(event2.getEventName());
        }

        private int compareDates(MyDate date1, MyDate date2) {
            int yearComparison = Integer.compare(date1.getYear(), date2.getYear());
            if (yearComparison != 0) {
                return yearComparison;
            }

            int monthComparison = Integer.compare(date1.getMonth(), date2.getMonth());
            if (monthComparison != 0) {
                return monthComparison;
            }

            return Integer.compare(date1.getDay(), date2.getDay());
        }
    }
}