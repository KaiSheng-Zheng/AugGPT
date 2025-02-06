import java.util.ArrayList;

public class MyCalendar {
    private final int capacity;
    private ArrayList<Event> events = new ArrayList<>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    private int countevent = 0;

    public boolean addEvent(MyDate date, String eventName) {
        countevent++;
        if (countevent <= capacity) {
            Event event = new Event(eventName, date);
            this.events.add(event);
            return true;
        } else return false;
    }

    public String finishNextEvent() {
        int event0index = 0;
        MyDate date0 = new MyDate(1000000000, 1, 1);
        if (this.events.isEmpty()) {
            return "NONE";
        }
        String event0 = this.events.get(0).getEventname();
        for (int i = 0; i < this.events.size(); i++) {
            if (MyDate.compare(date0, this.events.get(i).getDate())) {
                date0 = this.events.get(i).getDate();
                event0 = this.events.get(i).getEventname();
                event0index = i;
            } else if (date0.getDay() == this.events.get(i).getDate().getDay() && date0.getMonth() == this.events.get(i).getDate().getMonth() && date0.getYear() == this.events.get(i).getDate().getYear()) {
                if (event0.compareTo(this.events.get(i).getEventname()) > 0) {
                    event0 = this.events.get(i).getEventname();
                    event0index = i;
                }
            }
        }
        this.events.remove(event0index);
        countevent--;
        return event0;
    }

    public class Event {
        private String eventname;
        private MyDate date;

        public Event(String eventname, MyDate date) {
            this.eventname = eventname;
            this.date = date;
        }

        public String getEventname() {
            return eventname;
        }

        public MyDate getDate() {
            return date;
        }
    }
}