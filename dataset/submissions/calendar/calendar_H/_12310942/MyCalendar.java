import java.util.*;

public class MyCalendar {

    
    private int capacity=10;

    List<DateItem> events = new ArrayList<>();

    public MyCalendar(int capacity){
        this.capacity=capacity;
    }

    public boolean addEvent(MyDate date,String eventName){
        if(events.size()==capacity){
            return false;
        }
        DateItem item = new DateItem(eventName,date);
        events.add(item);
        events.sort(new EventCompare());
        return true;
    }

    public String finishNextEvent(){
        if (!events.isEmpty()) {
            DateItem nextEvent = events.get(0);
            String eventName = nextEvent.getName();
            events.remove(0);
            return eventName;
        } else {
            return "NONE";
        }
    }


    
}

class DateItem{
    private String name;
    private MyDate date;

    public String getName() {
        return name;
    }

    public MyDate getDate() {
        return date;
    }

    public DateItem(String name, MyDate date) {
        this.name = name;
        this.date = date;
    }
}
class EventCompare implements Comparator<DateItem> {

    @Override
    public int compare(DateItem o1, DateItem o2) {
        int ret;
        
        long flag = o1.getDate().getMill()-o2.getDate().getMill();
        if (flag == 0) {
            ret = o1.getName().compareTo(o2.getName());
            
        }else if(flag>0){
            ret = 1;
        }else{
            ret = -1;
        }
        return ret;
    }
}
