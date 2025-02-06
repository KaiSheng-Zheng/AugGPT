import java.util.ArrayList;

public class MyCalendar {
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<MyEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<MyEvent> events) {
        this.events = events;
    }

    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < capacity) {
            events.add(new MyEvent(date, eventName));
            return true;
        } else {
            return false;
        }
    }


    public String finishNextEvent() {
        if (this.events.isEmpty()) {
            return "NONE";
        } else {
            ArrayList<MyEvent> minDate = new ArrayList<>(events);
            minDate.clear();
            minDate.add(events.get(0));
            for (int i = 1; i < events.size(); i++) {
                if (MyDate.difference(events.get(i).getDate(), minDate.get(0).getDate()) < 0) {
                    minDate.clear();
                    minDate.add(events.get(i));
                } else if (MyDate.difference(events.get(i).getDate(), minDate.get(0).getDate()) == 0) {
                    minDate.add(events.get(i));
                }
            }
            if (minDate.size() > 1) {
                for (int i = minDate.size() - 1; i > 0; i--) {
                    if (minDate.get(i - 1).getEventName().compareTo(minDate.get(i).getEventName()) > 0) {
                        MyEvent a = minDate.get(i - 1);
                        minDate.set(i - 1, minDate.get(i));
                        minDate.set(i, a);
                    }
                }
                String eventName = minDate.get(0).getEventName();
                for (MyEvent event : events) {
                    if (event.getEventName().equals(minDate.get(0).getEventName())) {
                        events.remove(event);
                        break;
                    }
                }
                minDate.remove(0);
                return eventName;
            } else {
                String eventName = minDate.get(0).getEventName();
                for (MyEvent event : events) {
                    if (event.getEventName().equals(minDate.get(0).getEventName())) {
                        events.remove(event);
                        break;
                    }
                }
                minDate.remove(0);
                return eventName;
            }
        }
    }
}
