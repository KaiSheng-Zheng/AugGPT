import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> event=new ArrayList<MyEvent>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if (event.size()>=capacity){
            return false;
        }else {
            event.add(new MyEvent(date,eventName));
            Collections.sort(event);
            return true;
        }

    }
    public String finishNextEvent(){
        if (this.event.isEmpty()){
            return "NONE";
        }
        else {
            MyEvent e=this.event.remove(0);
            return e.getEvent();
        }
    }
}
