import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity){
        this.capacity=capacity;
        this.events=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if (events.size()<capacity){
            events.add(new MyEvent(date,eventName));
            return true;
        }else {
            return false;
        }
    }
    public String finishNextEvent(){
        if (events.isEmpty()){
            return "NONE";
        }else {
            MyDate minDate=dateSort(events);
            String finishEventName=eventSort(events,minDate);
            int n=0;
            for (int i = 0; i < events.size(); i++){
                if (MyDate.difference(events.get(i).getDate(),minDate)==0
                &&events.get(i).getEventName().equals(finishEventName)){
                    n=i;
                }
            }
            events.remove(n);
            return finishEventName;
        }
    }
    public static MyDate dateSort(ArrayList<MyEvent> events){
        MyDate date=events.get(0).getDate();
        for (int i = 0; i < events.size()-1; i++) {
            for (int j = i; j < events.size()-1; j++) {
                date=MyDate.difference(date,events.get(j+1).getDate())<0?
                        date:events.get(j+1).getDate();
            }
        }
        return date;
    }
    public static String eventSort(ArrayList<MyEvent> events,MyDate minDate){
        ArrayList<String> eventNames=new ArrayList<>();
        for (int i = 0; i < events.size(); i++){
            if (MyDate.difference(events.get(i).getDate(),minDate)==0){
                eventNames.add(events.get(i).getEventName());
            }
        }
        String event=eventNames.get(0);
        for (int i = 0; i < eventNames.size()-1; i++) {
            for (int j = i; j < eventNames.size()-1; j++) {
                event=event.compareTo(eventNames.get(j+1))<0?
                        event:eventNames.get(j+1);
            }
        }
        return event;
    }
}
