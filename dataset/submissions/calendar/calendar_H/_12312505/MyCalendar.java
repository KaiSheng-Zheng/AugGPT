import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MyCalendar {
    private int capacity,total=0;
    MyEvent[] events;
    public MyCalendar(int capacity) {
        this.capacity=capacity;
        events = new MyEvent[capacity];
    }
    public boolean addEvent(MyDate date, String eventName) {
        if (total==capacity) return false;
        events[total++]=new MyEvent(date, eventName);
        for (int i=total-1;i>=1;i--) {
            if (events[i].compareTo(events[i-1])>0) {
                MyEvent tmp = events[i];
                events[i]=events[i-1];
                events[i-1]=tmp;
            } else break;
        }
        return true;
        //for (int i=events.to)
    }
    public String finishNextEvent() {
        if (total==0) return "NONE";
        total--;
        return events[total].toString();
    }

}
class MyEvent {
    private MyDate date;
    private String eventName;
    public MyEvent(MyDate date, String eventName) {
        this.date=date;
        this.eventName=eventName;
    }
    int compareTo(MyEvent otherEvent) {
        return MyDate.difference(date,otherEvent.date)!=0?
                MyDate.difference(date,otherEvent.date):eventName.compareTo(otherEvent.eventName);
    }
    public String toString() {
        return eventName;
    }
}
