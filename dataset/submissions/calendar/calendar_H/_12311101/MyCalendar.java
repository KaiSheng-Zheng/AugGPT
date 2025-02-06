import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events = new ArrayList<>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events = events;
    }

    public boolean addEvent(MyDate date, String eventName){
        if (events.size() < capacity){
            events.add(new MyEvent(date, eventName));
            return true;
        }
        else {
            return false;
        }
    }

    public String finishNextEvent(){
        if (events.isEmpty()){
            return "NONE";
        }
            for (int j = events.size()-1; j >=1; j--) {
                int num2 = MyDate.difference(events.get(j).getDate(),events.get(j-1).getDate());
                if (num2 <0){
                    Collections.swap(events,j,j-1);
                }
                else if(num2 ==0){
                    if(events.get(j).getEventname().compareTo(events.get(j-1).getEventname())<0){
                        Collections.swap(events,j,j-1);
                    }
                }
            }
        MyEvent nextevent = events.remove(0);
        return nextevent.getEventname();
    }
}