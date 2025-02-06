import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity,volumn;
    private ArrayList<MyDate> all_dates=new ArrayList<>();

    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(volumn>=capacity){
            return false;
        }else {
            date.add_event(eventName);
            all_dates.add(date);
            volumn++;
            return true;
        }
    }
    public String finishNextEvent(){
        if(all_dates.isEmpty()){
            return "NONE";
        }
        MyDate date_0= all_dates.get(0);
        for (MyDate date : all_dates) {
            if(MyDate.difference(date,date_0)<0){
                date_0=date;
            }
        }
        Collections.sort(date_0.event);
        String str=date_0.event.get(0);
        date_0.event.remove(0);
        all_dates.remove(date_0);
        return str;
    }


}
