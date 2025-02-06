import java.util.ArrayList;

public class MyCalendar {
    int capacity;
    int eventNumbers;
    ArrayList<MyDate> eventdates=new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
        this.eventNumbers=0;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(eventNumbers>=capacity) return false;
        eventdates.add(date);
        eventNumbers++;
        date.events.add(eventName);
        return true;
    }
    public String finishNextEvent(){
        if(eventNumbers==0) return "NONE";
        eventNumbers--;
        int pd1=0;
        int pd2=0;
        MyDate x=eventdates.get(0);
        for(int i=1;i<eventdates.size();i++){
            if(MyDate.difference(x,eventdates.get(i))>0) {
                x=eventdates.get(i);
                pd1=i;
            }
        }

        String a=x.events.get(0);
        for(int i=1;i<x.events.size();i++){
            if(a.compareTo(x.events.get(i))>0) {
                a=x.events.get(i);
                pd2=i;
            }
         }
        eventdates.remove(pd1);
        x.events.remove(pd2);
        return a;
    }
}
