import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private ArrayList<MyEvent> events = new ArrayList<MyEvent>();
    private int capacity;

    public MyCalendar(int capacity){
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        MyEvent event = new MyEvent(date, eventName);
        events.add(event);
        if(events.size() <= capacity){
            return true;
        }else{
            events.remove(event);
            return false;
        }
    }

    public String finishNextEvent(){
        if(events.isEmpty()){
            return  "NONE";
        }else{
            Collections.sort(events);
            String name = events.get(0).getEventName();
            events.remove(0);
            return name;
        }
    }

}
