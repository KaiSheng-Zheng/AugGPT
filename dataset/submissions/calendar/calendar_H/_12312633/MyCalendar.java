import java.util.*;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;
    public MyCalendar(int capacity){
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if (capacity <=0)
            return false;
        else{
            MyEvent newevent = new MyEvent(date,eventName);
            events.add(newevent);
            capacity--;
            return true;}
    }

    public String finishNextEvent(){
        if (events.isEmpty())
            return "NONE";
        else {
            MyEvent earlistevent = null;
            for (MyEvent event :events){
                if ((earlistevent == null) || (event.getlocalDate(event.getDate()).isBefore(earlistevent.getlocalDate(earlistevent.getDate())))){
                    earlistevent = event;}
                if (earlistevent.getlocalDate(earlistevent.getDate()).isEqual(event.getlocalDate(event.getDate()))) {
                    if (earlistevent.getName().compareTo(event.getName())>0)
                        earlistevent = event;
                }
            }
            String outname = earlistevent.getName();
            events.remove(earlistevent);
            capacity++;
            return outname;
        }
    }
}
