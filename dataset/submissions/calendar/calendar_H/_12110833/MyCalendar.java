import java.util.ArrayList;
public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity){ //constructor method;
        this.capacity = capacity;
        this.events = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName){ //addEvent method;
        MyEvent addevent = new MyEvent(date, eventName);
        events.add(addevent);
        if(events.size() <= capacity){
            return true;
        } else {
            events.remove(addevent);
            return false;
        }

    }

    public String finishNextEvent(){ //finishNextEvent method;
        ArrayList<MyEvent> lastarray = new ArrayList<>(); //new ArrayList;
        if(this.events.isEmpty()){
            return "NONE";
        }

        else {
            MyEvent f = null;
            String last = null;
            int eyear = 999999;
            int emonth = 12;
            int eday = 31;

            for(MyEvent e : events) {
                if (e.getDate().getYear() * 10000 + e.getDate().getMonth() * 100 + e.getDate().getDay() <= eyear * 10000 + emonth * 100 + eday) {
                    eyear = e.getDate().getYear();
                    emonth = e.getDate().getMonth();
                    eday = e.getDate().getDay();
                }
            }
            for(MyEvent e : events){
                if(e.getDate().getYear()==eyear && e.getDate().getMonth()==emonth && e.getDate().getDay()==eday){
                    last = e.getEventName();
                    lastarray.add(e);
                }
            }

            for(MyEvent g: lastarray){
                if((g.getEventName().compareToIgnoreCase(last)) < 0){
                    last = g.getEventName();
                }
                f = g;
            }

            for(MyEvent e : events){
                if(e.getEventName() == last){
                    events.remove(e);
                    break;
                }
            }
            //events.remove(f);
            return last;
        }
    }
}