import java.util.*;

public class MyCalendar {
    private int capacity;
    private List<String> events;
    private  List<MyDate> calendar;
    public MyCalendar(){
    }

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = new ArrayList<>();
        this.calendar = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() < capacity) {
            events.add(eventName);
            calendar.add(date);
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        if(events.size() == 1){
            String c = events.get(0);
            this.events.remove(0);
            this.capacity --;
            return c;
        }
        if (events.isEmpty()) {
            return "NONE";
        }
        boolean swapped;
       for(int i = 0; i < capacity; i++) {
           swapped = false;
           for (int j = 1; j < capacity - i; j++) {
               if (MyDate.difference(calendar.get(j - 1), calendar.get(j)) > 0) {
                   MyDate temp1 = calendar.get(j - 1);
                   calendar.set(j - 1, calendar.get(j));
                   calendar.set(j, temp1);
                   String temp2 = events.get(j - 1);
                   events.set(j - 1, events.get(j));
                   events.set(j, temp2);
                   swapped = true;
               }
           }
           if (!swapped) {
               break;
           }
       }
       if(MyDate.difference(calendar.get(0),calendar.get(1)) != 0){
           String a = events.get(0);
           this.events.remove(0);
           this.calendar.remove(0);
           this.capacity --;
           return a;
       }else {
           List<String> eventcol = new ArrayList<>();
           eventcol.add(events.get(0));
           for(int k = 1; k < capacity; k++){
               if(MyDate.difference(calendar.get(k-1),calendar.get(k)) == 0){
                   eventcol.add(events.get(k));
               }else {
                   break;
               }
           }
           Collections.sort(eventcol);
           String b = eventcol.get(0);
           this.events.remove(b);
           this.calendar.remove(0);
           this.capacity --;
           return b;
       }


    }
}
