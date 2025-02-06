import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<Event> events;
    private Event event;

    public MyCalendar(int capacity){
        this.capacity=capacity;
        this.events=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if (events.size()<capacity){
            this.event=new Event(eventName,date);
            events.add(event);
            return true;
        }
        else {
            return false;
        }
    }
    public String finishNextEvent(){
        if (!(events.isEmpty())){
            MyDate min=new MyDate(events.get(0).getDate());
            for (Event e:events) {
                if (MyDate.difference(e.getDate(),min)<0){
                    min=e.getDate();
                }
            }
            ArrayList<Event> latest=new ArrayList<>();
            for (Event e:events) {
                if (MyDate.difference(e.getDate(),min)==0){
                    latest.add(e);
                }
            }
            String name=latest.get(0).getEventName();
            for (Event e:latest) {
                if (e.getEventName().compareTo(name)<0){
                    name=e.getEventName();
                }
            }
            for (Event e:events) {
                if (e.getEventName().equals(name)){
                    events.remove(e);
                    return e.getEventName();
                }
            }
        }
        return "NONE";
    }
}
 class Event{
    private String eventName;
    private MyDate date;

     public Event(String eventName, MyDate date) {
         this.eventName = eventName;
         this.date = date;
     }

     public String getEventName() {
         return eventName;
     }

     public MyDate getDate() {
         return date;
     }
 }
