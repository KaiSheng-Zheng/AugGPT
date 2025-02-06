import java.util.ArrayList;
import java.util.Objects;

public class MyCalendar {
    private int capacity;

    private ArrayList <MyEvent> events = new ArrayList<>();

    public MyCalendar(int capacity){
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date,String eventName){
        if (events.size()<capacity){
            MyEvent event =new MyEvent(date,eventName);
            events.add(event);
            return true;
        }else return false;
    }

    public String finishNextEvent(){
        if (events.isEmpty()){
            return "NONE";
        }else {
            String name1 = events.get(0).getName();
            MyDate dateMin = events.get(0).getDay();
            for (MyEvent event : events) {
                if (MyDate.difference(dateMin, event.getDay()) > 0) {
                    name1 = event.getName();
                    dateMin = event.getDay();
                } else if (MyDate.difference(dateMin, event.getDay()) == 0 && name1.compareTo(event.getName()) > 0) {
                    name1 = event.getName();
                    dateMin = event.getDay();
                }
            }
            int flag = 0;
            for (int i=0;i<events.size();i++) {
                if (Objects.equals(events.get(i).getName(), name1)) {
                    flag = i;
                }
            }
            events.remove(flag);
            return name1;
        }
    }

}
