import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MyCalendar{
    int capacity =0;
    static private int count= 0;
    public static int getCount() {
        return count;
    }

    //ArrayList<MyDate> datelist = new ArrayList<>();
    ArrayList<String> eventname = new ArrayList<>();
    ArrayList<Integer> datenum = new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity =capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if (datenum.size()<capacity){
            int datenum = Integer.valueOf(String.format("%04d"+"%02d"+"%02d",date.getYear(),date.getMonth(),date.getDay())) ;
            //date.eventName.add(eventName);
            //date.datenum=datenum;
            //datelist.add(date);
            this.datenum.add(datenum);
            this.eventname.add(eventName);
            count++;
            return true;
        }
        else return false;
    }
    public String finishNextEvent(){
        
        if (datenum.size()>0) {
            
            int mindatenum = 0;
            int mini = 0;
            String minEventName = "null";
            for (int i = 0; i < datenum.size(); i++) {
                if (datenum.get(i) < mindatenum || mindatenum == 0) {
                    mindatenum = datenum.get(i);
                    minEventName = eventname.get(i);
                    mini = i;
                } else if (datenum.get(i) == mindatenum && mindatenum != 0) {
                    int n = eventname.get(i).compareTo(minEventName);
                    
                    if (n < 0) {
                        minEventName = eventname.get(i);
                        mini = i;
                    }
                }
            }
           
            eventname.remove(mini);
            datenum.remove(mini);
            count--;
            return minEventName;
        }
        else return "NONE";

    
    }
}
