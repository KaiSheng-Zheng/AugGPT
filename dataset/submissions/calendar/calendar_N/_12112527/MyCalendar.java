
import java.util.ArrayList;
import java.util.Comparator;


public class MyCalendar {
    private int capacity;
    private int cnt;
    ArrayList<Event> events = new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity = capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        cnt++;
        if (cnt<=capacity){
            events.add(new Event(date,eventName));
            return true;
        }
        return false;
    }
    public String finishNextEvent(){
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.compareName(o2);
            }
        });
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.compareDate(o2);
            }
        });
        String a = "NONE";
        if(!events.isEmpty()){
            a = events.get(0).name;
            events.remove(0);
            cnt--;
        }

        return a;
    }

    public class Event{
        MyDate date;
        String name;
        public Event(MyDate date,String name){
            this.date = date;
            this.name = name;
        }
        public int compareDate(Event event){
            return MyDate.difference(this.date,event.date);
        }
        public int compareName(Event event){
            return this.name.compareTo(event.name);
        }

    }
}

