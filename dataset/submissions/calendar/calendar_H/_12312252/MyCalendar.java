import java.util.ArrayList;
import java.util.Collections;
public class MyCalendar
{
    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity)
    {
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName)
    {
        if (events.size() < capacity){
            events.add(new MyEvent(date, eventName));
            Collections.sort(events);
            return true;}
        Collections.sort(events);
        return false;
    }

    public String finishNextEvent()
    {
        if (this.events.isEmpty())
            return "NONE";
        else {
            String s = events.get(0).getEventName();
            events.remove(0);
            return s;
        }
    }
}

class MyEvent implements Comparable<MyEvent>
{
    MyDate date;
    String eventName;
    public MyEvent(MyDate date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }

    @Override
    public int compareTo(MyEvent o) {
        if (MyDate.difference(date, o.date) != 0)
            return MyDate.difference(date, o.date);
        else{
            return eventName.compareTo(o.eventName);
        }
    }

    public String getEventName() {
        return eventName;
    }
}