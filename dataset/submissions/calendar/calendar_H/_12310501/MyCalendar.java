import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;

public class MyCalendar{
    private int capacity;
    private TreeSet<String> eventList = new TreeSet<>(Comparator.naturalOrder());
    private ArrayList<String> eventList2 = new ArrayList<>();

    public MyCalendar(int capacity){
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        if(this.capacity == 0){
            return false;
        }
        String dateAndEventName = date.toString() + eventName;
        this.eventList2.add(dateAndEventName);
        this.capacity--;
        return true;
    }

    public String finishNextEvent(){
        if(this.eventList2.isEmpty()){
            return "NONE";
        }
        eventList2.sort(Comparator.naturalOrder());

        String currentEvent = this.eventList2.get(0).substring(10);
        eventList2.remove(0);
        this.capacity++;
        return currentEvent;
    } 
}