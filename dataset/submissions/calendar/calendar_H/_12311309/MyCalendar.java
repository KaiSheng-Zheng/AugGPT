import java.util.ArrayList;
public class MyCalendar {
    public class MyEvent {
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
    }

    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }


    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < capacity) {
            MyEvent event = new MyEvent(date, eventName);
            events.add(event);
            return true;
        } else
            return false;
    }

    public String finishNextEvent() {
        if (this.events.isEmpty())
            return "NONE";
        else if(events.size()==1){
            String x = events.get(0).getEventName();
            events.remove(0);
            return x;
        }
        else {
            for (int j = 0; j < events.size(); j++) {
                for (int i = 0; i < events.size() - 1; i++) {
                    if (events.get(i).getDate().getTotal() > events.get(i + 1).getDate().getTotal()) {
                        MyEvent o1 = events.get(i);
                        MyEvent o2 = events.get(i + 1);
                        events.remove(i);
                        events.remove(i);
                        events.add(i, o2);
                        events.add(i + 1, o1);
                    }
                }
            }
            if (events.get(0).getDate().getTotal() < events.get(1).getDate().getTotal()) {
                String x = events.get(0).getEventName();
                events.remove(0);
                return x;
            } else {
                int n = 0;
                for (int i = 0; i < events.size() - 1; i++) {
                    if (events.get(i).getDate().getTotal() == events.get(i + 1).getDate().getTotal()) {
                        n += 1;
                    } else break;
                }
                for (int j=0;j<n;j++) {
                    for (int i = 0; i < n; i++) {
                        if (events.get(i).getEventName().compareTo(events.get(i + 1).getEventName()) > 0) {
                            MyEvent o1 = events.get(i);
                            MyEvent o2 = events.get(i + 1);
                            events.remove(i);
                            events.remove(i);
                            events.add(i, o2);
                            events.add(i + 1, o1);
                        }
                    }
                }
                String x = events.get(0).getEventName();
                events.remove(0);
                return x;
            }
        }
    }
}
