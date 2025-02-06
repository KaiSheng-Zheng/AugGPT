import org.w3c.dom.events.Event;

import java.util.ArrayList;

public class MyCalendar {
    int count = 0;
    ArrayList<event> events=new ArrayList<>();
    int capacity;
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){

        if(count>=capacity){
            return false;
        }else {
            event e=new event(eventName,date);
            events.add(e);
            count++;
            return true;
        }
    }
    public String finishNextEvent(){
        if(events.size()>0){
            event min=events.get(0);
            for (int i = 0; i < events.size(); i++) {
                if(MyDate.difference(min.date,events.get(i).date)>0){
                    min=events.get(i);
                }else if(MyDate.difference(min.date,events.get(i).date)==0){
                    if(min.eventName.compareTo(events.get(i).eventName)>0){
                        min=events.get(i);
                    }
                }
            }
            events.remove(min);
            return min.eventName;
        } else {
            return "NONE";
        }
    }
}
class event{
    public String eventName;
    public MyDate date;
    public event(String eventName,MyDate date){
        this.date=date;
        this.eventName=eventName;
    }
}