import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCalendar {
    private int capacity;
    public ArrayList<Event> events;
    private int eventNum=0;
    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date,String eventName){
        if(eventNum>=capacity){
            return false;
        }else{
            eventNum++;
            Event e=new Event(date,eventName);
            events.add(e);
            return true;
        }
    }

    public String finishNextEvent(){
        if(eventNum==0){
            return "NONE";
        }else{
            Collections.sort(events, cmp);
            ArrayList<String> Str = AlohaOder(events);
            String A=Str.get(0);
            for(int i=0;i< events.size();i++){
                if(events.get(i).eventName.equals(A)){
                    events.remove(i);
                    break;
                }
            }
            eventNum--;
            return A;
        }
    }
    Comparator<Event> cmp = new Comparator<Event>() {
        public int compare(Event s1, Event s2) {
            int A = (s1.date.getYear() - s2.date.getYear()) * 10000 + (s1.date.getMonth() - s2.date.getMonth()) * 100 + (s1.date.getDay() - s2.date.getDay());
            return A;
        }
    };
    public ArrayList<String> AlohaOder(ArrayList<Event> events) {
        ArrayList<String> Str = new ArrayList<>();
        if(events.size()==1){
            Str.add(events.get(0).eventName);
            return Str;
        }
        else {
            for (int i = 0; i < events.size()-1; i++) {
                if (events.get(i).getDate() != events.get(i + 1).getDate()) {
                    if(i!=events.size()-2) {
                        Str.add(i, events.get(i).getEventName());
                    }else {
                        Str.add(i, events.get(i).getEventName());
                        Str.add(i+1, events.get(i+1).getEventName());
                    }
                } else {
                    int n = i;
                    while (n+1<events.size()&&events.get(n).getDate() == events.get(n + 1).getDate()) {
                        n++;
                    }
                    List<String> In = new ArrayList<>();
                    for (int k = i; k < n + 1; k++) {
                        In.add(events.get(k).getEventName());
                    }
                    Collections.sort(In);
                    for (int k = 0; k < In.size(); k++) {
                        Str.add(In.get(k));
                    }
                    if (n < events.size()- 1) {
                        i = n;
                    } else return Str;
                }
            }
            return Str;
        }
    }
    class Event{
        private MyDate date;
        private String eventName;
        public Event(MyDate date,String eventName){
            this.date=date;
            this.eventName=eventName;
        }
        public String getEventName(){
            return eventName;
        }
        public MyDate getDate(){
            return date;
        }
    }
}