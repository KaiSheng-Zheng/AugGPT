import java.util.*;
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
        //incorrect sort
                /*
                MyCalendar calendar = new MyCalendar(3);

                // Add an event on a specific date
                MyDate date1 = new MyDate(2024, 2, 9);
                calendar.addEvent(date1, "meeting");
                calendar.addEvent(date1, "laundry");
                
                MyDate date2 = new MyDate(2024, 2, 10);
                calendar.addEvent(date2, "grocery");
        
                String finishedEvent = calendar.finishNextEvent();
                Assertions.assertEquals("laundry", finishedEvent, "Next event should be 'laundry'."); failed
                 */
        Collections.sort(events, (event1, event2) -> {
            int compareResult;
            String y1=Integer.toString(event1.getDate().year);
            String y2=Integer.toString(event2.getDate().year);
            String m1=Integer.toString(event1.getDate().month);
            String m2=Integer.toString(event2.getDate().month);
            String d1=Integer.toString(event1.getDate().day);
            String d2=Integer.toString(event2.getDate().day);
            String n1=y1+m1+d1;
            String n2=y2+m2+d2;
            compareResult=n1.compareTo(n2);
            if (event1.getDate().year==event2.getDate().year&&event1.getDate().month==event2.getDate().month&&event1.getDate().day==event2.getDate().day) {
                compareResult = event1.getName().compareTo(event2.getName());
            }
            return compareResult;
        });
        Event nextEvent = events.get(0);
        events.remove(0);
        return nextEvent.getName();
    }
    private class Event {
        private MyDate date;
        private String name;

        public Event(MyDate date, String name) {
            this.date = date;
            this.name = name;
        }
        public MyDate getDate() {
            return date;
        }
        public String getName() {
            return name;
        }
    }
}
