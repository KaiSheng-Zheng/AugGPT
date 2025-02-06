import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capcity;
    private  ArrayList<MyEvent> events;


    public MyCalendar(int capacity) {
        this.capcity = capacity;
        this.events=new ArrayList<>();
    }

    public int getCapcity() {
        return capcity;
    }

    public void setCapcity(int capcity) {
        this.capcity = capcity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size()<capcity){
            events.add(new MyEvent(date,eventName));
            Collections.sort(events);
            return true;
        }
        else {
            return false;
        }

    }
    public String finishNextEvent(){
        if (this.events.isEmpty()){
            return "NONE";
        }
        else {
        MyEvent e=this.events.remove(0);
        return e.getEventName();
        }
    }
}