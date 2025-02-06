

import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity;
    private ArrayList<String>events;

    public MyCalendar(int capacity){
        this.capacity=capacity;
        this.events=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if (events.size()<capacity){
            events.add(String.valueOf(date)+eventName);return true;
        }else{return false;}
    }
    public String finishNextEvent(){
         if (this.events.isEmpty()){return "NONE";}
         else {
             Collections.sort(events);
             String s1=events.get(0);
             StringBuilder sb=new StringBuilder(s1);
             sb.delete(0,10);
             events.remove(0);
             return String.valueOf(sb);
         }
    }


}
