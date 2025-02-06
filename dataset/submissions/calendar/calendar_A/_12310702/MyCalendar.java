
import java.util.ArrayList;
public class MyCalendar{
    private int capacity;
    private ArrayList<Event> events;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        events=new ArrayList<Event>();
    }
    public boolean addEvent(MyDate date,String eventName){
        if(events.size()==capacity)
            return false;
        events.add(new Event(date,eventName));
        return true;
    }
    public String finishNextEvent(){
        if(events.isEmpty())
            return "NONE";
        int first=0;
        for(int i=0;i<events.size();i++)
            if(events.get(i).precedes(events.get(first)))
                first=i;
        String s=events.get(first).getEventName();
        events.remove(first);
        return s;
    }
}
class Event {
    private MyDate date;
    private String eventName;
    public Event(MyDate date,String eventName){
        this.date=new MyDate(date);
        this.eventName=eventName;
    }
    private MyDate getDate(){
        return date;
    }
    public String getEventName(){
        return eventName;
    }
    public boolean precedes(Event event){
        int dateDifference=MyDate.difference(this.getDate(),event.getDate());
        if(dateDifference<0)
            return true;
        else if(dateDifference>0)
            return false;
        else{
            int eventNameDifference=this.getEventName().compareTo(event.getEventName());
            if(eventNameDifference<=0)
                return true;
            else if(eventNameDifference>0)
                return false;
        }
        return false;
    }
}