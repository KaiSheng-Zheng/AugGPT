import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    ArrayList<MyDate> event = new ArrayList<>();

    public boolean addEvent(MyDate date,String eventname) {
        if (event.size() >= capacity) {
            return false;
        }
       MyDate eventdate = new MyDate(date.getEventYear(),date.getNameMonth(),date.getEventDay());
        eventdate.addEventname(eventname);
        event.add(eventdate);
        return true;
    }

    public String finishNextEvent() {
        if (event.isEmpty()) {
            return "NONE";
        }

        Collections.sort(event);
        MyDate temp = event.get(0);
        event.remove(0);
        return temp.getEventName();
    }
}