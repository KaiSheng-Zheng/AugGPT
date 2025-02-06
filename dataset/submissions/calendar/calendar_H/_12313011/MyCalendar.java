import java.util.ArrayList;
import java.util.Comparator;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < capacity) {
            MyEvent event = new MyEvent(date,eventName);
            events.add(event);
            events.sort(new Comparator<>() {
                @Override
                public int compare(MyEvent o1, MyEvent o2) {
                    if (o1.getDate() != o2.getDate()) {
                        return MyDate.difference(o1.getDate(), o2.getDate());
                    } else {
                        return o1.getEventName().compareTo(o2.getEventName());
                    }
                }
            });
            return true;
        } else {
            return false;
        }
    }
    public String finishNextEvent(){
        if(this.events.isEmpty())
            return "NONE";
        else {
            String s = this.events.get(0).getEventName();
            this.events.remove(0);
            return s;
        }
    }
}
