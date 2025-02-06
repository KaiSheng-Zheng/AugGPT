import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity;
    private int NumberOfEvents;

    ArrayList<Event> EventList = new ArrayList<Event>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
        NumberOfEvents=0;
    }
    public boolean addEvent(MyDate date, String eventName){
        NumberOfEvents++;
        if(NumberOfEvents<=capacity){
            Event event= new Event(date,eventName);
            EventList.add(event);
            for(int i=1;i<EventList.size();i++){
                    if (event.getDate().isBefore(EventList.get(EventList.size()-1-i).getDate().localDate)) {
                        Collections.swap(EventList, EventList.size()-1-i, EventList.size()-i);
                    } else {
                        if (event.getDate().isEqual(EventList.get(EventList.size()-1-i).getDate().localDate)) {
                            if (event.getEventName().compareTo(EventList.get(EventList.size()-1-i).getEventName()) <0) {
                                Collections.swap(EventList, EventList.size()-1-i, EventList.size()-i);
                            }
                        }
                    }
            }
            return true;
        }else{
            return false;
        }
    }
    public String finishNextEvent(){
        NumberOfEvents--;
        if(!EventList.isEmpty()) {
            String temp=EventList.get(0).getEventName();
            EventList.remove(0);
            return temp;
        }else{
            return "NONE";
        }
    }
}
class Event{
    private MyDate date;
    private String eventName;
    public Event(MyDate date, String eventName){
        this.date=date;
        this.eventName=eventName;
    }
    public MyDate getDate(){
        return date;
    }
    public String getEventName(){
        return eventName;
    }
}
