import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.events=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if(events.size()<capacity){
            MyEvent event=new MyEvent(date,eventName);
            events.add(event);
            return true;
        }else{
            return false;
        }
    }
    public String finishNextEvent(){
        if(events.isEmpty()){
            return "NONE";
        }else{
            for (int i = 0; i < events.size()-1; i++) {
                for (int j = 0; j < events.size() - 1-i; j++) {
                    if (MyDate.difference(events.get(j).getDate(), events.get(j + 1).getDate()) > 0) {
                        MyEvent event0=events.get(j);
                        events.set(j,events.get(j+1));
                        events.set(j+1,event0);
                    } else if (MyDate.difference(events.get(j).getDate(), events.get(j+ 1).getDate()) == 0) {
                        if (events.get(j).getEventName().compareTo(events.get(j + 1).getEventName()) > 0) {
                            MyEvent event0=events.get(j);
                            events.set(j,events.get(j+1));
                            events.set(j+1,event0);
                        }
                    }
                }
            }
            String kao=events.get(0).getEventName();
            events.remove(0);

            return kao;
        }
    }
}
