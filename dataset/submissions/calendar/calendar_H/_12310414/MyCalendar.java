import java.time.LocalDate;
import java.util.ArrayList;
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

        events.add(new Event(date, eventName));
        return true;
    }

    public String finishNextEvent() {
        if (events.isEmpty()) {
            return "NONE"; 
        }

        Event minEvent = events.get(0);
        for (Event event : events) {
            LocalDate eventDate = event.getDate().toLocalDate();
            LocalDate minEventDate = minEvent.getDate().toLocalDate();

            
            if (eventDate.compareTo(minEventDate) < 0 ||
                    (((LocalDate) eventDate).compareTo(minEventDate) == 0 && event.getEventName().compareTo(minEvent.getEventName()) < 0)) {
                minEvent = event;
            }
        }

        
        String nextEventName = minEvent.getEventName();
        events.remove(minEvent);
        return nextEventName;
    }


    
    private static class Event {
        private MyDate date;
        private String eventName;

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }

        public MyDate getDate() {
            return date;
        }

        public String getEventName() {
            return eventName;
        }
    }
}