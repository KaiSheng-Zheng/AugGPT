

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.zip.ZipFile;
import java.util.Collections;

public class MyCalendar {
    private int capacity;
    PriorityQueue<MyEvent> calendar = new PriorityQueue<>();

    public MyCalendar(int capacity){
        this.capacity = capacity;
//        this.calendar = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName){
        boolean success = true;
        MyEvent myEvent = new MyEvent(date, eventName);
        if (calendar.size()>=capacity){
            success = false;
            return success;
        }
        else{
            calendar.add(myEvent);
            return  success;
        }
    }

    public String finishNextEvent(){
        if (!this.calendar.isEmpty())
            return this.calendar.poll().eventname;
        else return "NONE";
    }

}
