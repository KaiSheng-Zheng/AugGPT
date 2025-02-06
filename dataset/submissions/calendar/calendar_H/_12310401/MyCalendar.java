import java.util.*;
import java.util.TreeMap;


public class MyCalendar {

    private TreeMap<MyDate, ArrayList<String>> maps;
    private int capacity;
    private int now_cap;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        now_cap=0;
        this.maps=new TreeMap<>(new Comparator<MyDate>(){
            @Override
            public int compare(MyDate o1, MyDate o2) {
                Integer d1=o1.getPureday();
                Integer d2=o2.getPureday();
                return d1.compareTo(d2);
            }
        });
    }
    public boolean addEvent(MyDate date, String eventName) {
        if(now_cap==capacity)return false;
        else{
            ArrayList<String> events = maps.get(date);
            if(events!=null){
                maps.get(date).add(eventName);
                Collections.sort(maps.get(date));
            }
            else{
                ArrayList<String> temp=new ArrayList<>();
                temp.add(eventName);
                maps.put(date,temp);
                Collections.sort(maps.get(date));
            }
            now_cap++;
            return true;
        }
    }

    public String finishNextEvent(){
        if(maps.isEmpty())return "NONE";
        else{
            now_cap--;
            MyDate nextDate = maps.firstKey();
            ArrayList<String> nextEvents = maps.get(nextDate);
            String nextEventName = nextEvents.remove(0);
            if (nextEvents.isEmpty()) {
                maps.remove(nextDate);
            }
            if(!maps.isEmpty()) nextDate = maps.firstKey();
            if((!maps.isEmpty())&&(!maps.get(nextDate).isEmpty()))Collections.sort(maps.get(nextDate));
            return nextEventName;
        }
    }
}
