import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    public int event=0;

    public ArrayList<Event> events=new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        if(events.size()<capacity){
        events.add(new Event(date,eventName));
        return true;
        }
        else  return false;
    }
    public String finishNextEvent(){
        if (events.isEmpty())
            return "NONE";
        Event date0=events.get(0);


        for (Event event1:events){
            if (MyDate.difference(event1.getMyDate(),date0.getMyDate())<0){
                date0=event1;
                //events.remove();
            }else if(MyDate.difference(event1.getMyDate(),date0.getMyDate())==0){
                if(date0.getEventname().compareTo(event1.getEventname())>0){
                    date0=event1;
                }
            }
        }
        events.remove(date0);
        return date0.getEventname();
    }


}
class Event{
    private MyDate myDate;
    private String Eventname;
    public Event(MyDate myDate,String Eventname){
        this.myDate=myDate;
        this.Eventname=Eventname;
    }
    public MyDate getMyDate(){
        return this.myDate;
    }
    public String getEventname(){
        return this.Eventname;
    }
}
