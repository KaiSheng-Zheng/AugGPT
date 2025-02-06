
import java.util.*;


public class MyCalendar {
    private int capacity;
    private ArrayList<MyCalendar> event;
    private String eventName;
    private MyDate date;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.event = new ArrayList<>();

    }

    public MyCalendar(MyDate date, String eventName) {
        this.eventName = eventName;
        this.date = date;
    }

    public ArrayList<MyCalendar> getEvent() {
        return event;
    }

    public MyDate getDate() {
        return date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public void setEvent(ArrayList<MyCalendar> event) {
        this.event = event;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (event.size() <capacity) {
            event.add(new MyCalendar(date, eventName));
            return true;
        } else
            return false;

    }


    public int compareTo(MyCalendar one) {
        date=event.get(0).date;
        int e = MyDate.difference(date, one.date);
        if (e != 0) {
            if (e > 0)
                return 1;
            else
                return -1;
        } else
            return event.get(0).eventName.compareTo(one.eventName);
    }

    public String finishNextEvent(){
        if (this.event.isEmpty()) {
            return "NONE";
        } else{
            for (int i = 0; i< event.size(); i++) {
                int m = compareTo(event.get(i));
                if (m>0) {
                    MyCalendar temp= event.get(i);
                    event.set(i, event.get(0));
                    event.set(0, temp);
                }
            }
             MyCalendar e = this.event.get(0);
            this.event.remove(0);
            return e.getEventName();
        }
    }
}

