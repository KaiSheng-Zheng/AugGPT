import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCalendar {
    private List<String> myevents = new ArrayList<>();
    private int capacity;
    public MyCalendar(int capacity){
        this.capacity = capacity;
    }
    public boolean addEvent(MyDate date,String eventName){
        boolean year = true;
        if(myevents.size() < capacity){
            int x = 8;
            StringBuilder zero = new StringBuilder();
            MyDate date0 = new MyDate(0,1,1);
            String number = String.valueOf(MyDate.difference(date,date0));
            int length = number.length();
            for(int i = 1;i <= x - number.length();i++){
                zero.append("0");
            }
            myevents.add(zero.toString() + number + eventName);
            Collections.sort(myevents);
        }
        else{
            year = false;
        }
        return year;
    }

    public String finishNextEvent(){
        String event = null;
        if(myevents.size() > 0){
            event = myevents.get(0).toString().substring(8);
            myevents.remove(0);
        }
        else if(myevents.size() == 0){
            event = "NONE";
        }
        return event;
    }
}