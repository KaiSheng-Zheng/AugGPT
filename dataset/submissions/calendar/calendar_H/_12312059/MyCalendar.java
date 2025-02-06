import java.util.ArrayList;
import java.util.Calendar;

public class MyCalendar {
    private ArrayList<String> events = new ArrayList<>();
    private ArrayList<MyDate> dates = new ArrayList<>();
    private int capacity;
    public MyCalendar(int capacity){
        this.capacity = capacity;;
    }
    public boolean addEvent(MyDate date, String eventName){
        if (events.size()<capacity){
            dates.add(date);
            events.add(eventName);
            return true;
        }
        else{
            return false;
        }
    }
    public String finishNextEvent(){
        for (int e =0;e<events.size()-1;e++){
            for (int i =0;i<events.size()-1;i++){
                if (dates.get(i) == dates.get(i+1) && events.get(i).compareTo(events.get(i+1))>0){
                    MyDate temp1 = dates.get(i);
                    String temp2 = events.get(i);
                    dates.set(i,dates.get(i+1));
                    events.set(i,events.get(i+1));
                    dates.set(i+1,temp1);
                    events.set(i+1,temp2);
                }
                if (dates.get(i).c1.after(dates.get(i+1).c1)){
                    MyDate temp1 = dates.get(i);
                    String temp2 = events.get(i);
                    dates.set(i,dates.get(i+1));
                    events.set(i,events.get(i+1));
                    dates.set(i+1,temp1);
                    events.set(i+1,temp2);
                }
            }
        }
        if (dates.isEmpty()){
            return "NONE";
        }
        else{
            String output = events.get(0);
            dates.remove(0);
            events.remove(0);
            return output;
        }
    }
}
