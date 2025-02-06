import java.util.ArrayList;

public class MyCalendar {
    int capacity;
    ArrayList<Event> events=new ArrayList<>();

    public MyCalendar(int capacity){
        this.capacity=capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        if(events.size()>=capacity) return false;
        events.add(new Event(date,eventName));
        return true;
    }

    public String finishNextEvent(){
        if(events.size()==0) return "NONE";
        for (int i = 0; i < events.size(); i++) {
            for (int j = 0; j < events.size()-1; j++) {
                if(Event.compare(events.get(j),events.get(j+1))){
                    Event t=events.get(j);
                    events.set(j,events.get(j+1));
                    events.set(j+1,t);
                }

            }

        }
        Event S=events.get(0);
        events.remove(0);
        return S.Event;
    }





}
class Event{
    MyDate date;
    String Event;
    public Event(MyDate date, String Event){
        this.date=date;
        this.Event=Event;
    }
    static boolean compare(Event E1,Event E2){
        if(MyDate.compare(E1.date,E2.date)==1) return false;
        else if(MyDate.compare(E1.date,E2.date)==0){
            if(E1.Event.compareTo(E2.Event)<=0)return false;
        }
        return true;
    }
}
