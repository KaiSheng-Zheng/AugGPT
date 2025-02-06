import java.util.ArrayList;
public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        this.events=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if(capacity>events.size()){
            events.add(new MyEvent(date,eventName));
            return true;
        }
        else {
            return false;
        }
    }
    public String finishNextEvent(){
        MyEvent cuttedEvent;
        if(this.events.isEmpty())
            return "NONE";
        else {
            ArrayList<MyDate> dates = new ArrayList<>();
            for (MyEvent i : events) {
                dates.add(i.getDate());
            }
            MyDate mindate = dates.get(0);
            for (MyDate i : dates) {
                if (MyDate.difference(i, mindate) < 0) {
                    mindate = i;
                }
            }
            ArrayList<MyEvent> sameDateEvent = new ArrayList<>();
            for (MyEvent i : events) {
                if (i.getDate() == mindate) {
                    sameDateEvent.add(i);
                }
            }
            MyEvent cutEvent=sameDateEvent.get(0);
            for (MyEvent i : sameDateEvent) {
                if(cutEvent.getEventName().compareTo(i.getEventName())>0){
                    cutEvent=i;
                }
            }
            cuttedEvent=cutEvent;
            events.remove(cutEvent);
        }return cuttedEvent.getEventName();
    }

}
