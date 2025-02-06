public class MyCalendar {
    int cap;
    int n;

    static class Event {
        MyDate date;
        String eventName;

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

    Event[] events;

    public MyCalendar(int capacity) {
        cap = capacity;
        n = 0;
        events = new Event[capacity];
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (n == cap)
            return false;
        events[n++] = new Event(date, eventName);
        return true;
    }

    public String finishNextEvent() {
        if (n == 0)
            return "NONE";
        Event nextEvent = events[0];
        for (int i = 1; i < n; i++) {
            int diffDate = MyDate.difference(nextEvent.getDate(), events[i].getDate());
            int diffName = nextEvent.getEventName().compareTo(events[i].getEventName());
            if (diffDate != 0 ? diffDate > 0 : diffName > 0)
                nextEvent = events[i];
        }
        for (int i = 0; i < n; i++)
            if (nextEvent == events[i]) {
                --n;
                for (int j = i; j < n; j++)
                    events[j] = events[j + 1];
                break;
            }
        return nextEvent.eventName;
    }
}
