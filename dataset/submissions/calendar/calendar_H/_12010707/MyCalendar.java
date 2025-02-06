import java.text.ParseException;
import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    ArrayList<event> events=new ArrayList<>();


    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        event h=new event(date,eventName);
        if(events.size()<capacity){
            events.add(h);
            return true;
        }else {
            return false;
        }

    }
    public String finishNextEvent() {
        if(events.size()!=0){
        event min=events.get(0);
        for(int i=1;i<events.size();i++){
            if(MyDate.difference(min.date,events.get(i).date)>0){
                min=events.get(i);
            } else if (MyDate.difference(min.date,events.get(i).date)==0) {
                if(min.name.compareTo(events.get(i).name)>0){
                    min=events.get(i);
                }
            }
        }
        events.remove(min);
        return min.name;
    }else {
            return "NONE";
        }
}
}
class event{
    MyDate date;
    String name;
    public event(MyDate date,String name){
        this.date=date;
        this.name=name;
    }
}