import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MyCalendar{
    private int capacity;
    private ArrayList<String>ms=new ArrayList<String>();
    private int now=0;
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(capacity==0)return false;
        --capacity;
        ms.add(date.toString()+eventName);
        Collections.sort(ms);
        return true;
    }
    public String finishNextEvent(){
        if(ms.size()>0){
            String s=ms.get(0).substring(10);
            ms.remove(0);
            ++capacity;
            return s;
        }
        return "NONE";
    }
}