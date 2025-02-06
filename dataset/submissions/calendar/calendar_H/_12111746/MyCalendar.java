public class MyCalendar {
    private int eventCount = 0;
    private int capacity;
    private String[] events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new String[capacity];
    }
    public boolean addEvent(MyDate date, String eventName) {
        if(eventCount < capacity) {
            events[eventCount++] = date + " " + eventName;
            return true;
        }
        return false;
    }
    public String finishNextEvent() {
        if(eventCount > 0) {
            String earliestEvent = events[0];
            int earliestIndex = 0;
            for(int i = 1; i < eventCount; i++) {
                if(events[i].compareTo(earliestEvent) < 0) {
                    earliestEvent = events[i];
                    earliestIndex = i;
                }
            }
            events[earliestIndex] = events[--eventCount];
            return earliestEvent.substring(11);
        }
        return "NONE";
    }
}
