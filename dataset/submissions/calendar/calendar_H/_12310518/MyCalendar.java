import java.util.ArrayList;

public class MyCalendar {
    int numberOfEvents = 0;
    int capacity;
    ArrayList<MyDate> events=new ArrayList<>();
    ArrayList<String> eventsName=new ArrayList<>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        if (numberOfEvents >= capacity){
            return false;
        }else {
            events.add(date);
            eventsName.add(eventName);
            numberOfEvents++;
            return true;
        }
    }

    public String finishNextEvent(){
        for (int i = events.size() - 1; i > 0; i--) {
            if (MyDate.difference(events.get(i),events.get(i-1))<0){
                MyDate middleDate=events.get(i);
                String middleEvent=eventsName.get(i);
                events.set(i,events.get(i-1));
                events.set(i-1,middleDate);
                eventsName.set(i,eventsName.get(i-1));
                eventsName.set(i-1,middleEvent);
            }
            if (MyDate.difference(events.get(i),events.get(i-1))==0){
                if (eventsName.get(i).compareTo(eventsName.get(i-1))<0){
                    String middleEvent=eventsName.get(i);
                    eventsName.set(i,eventsName.get(i-1));
                    eventsName.set(i-1,middleEvent);
                }
            }
        }
        numberOfEvents--;
        if (eventsName.isEmpty()){
            numberOfEvents++;
            eventsName.add("NONE");
            events.add(new MyDate(1,1,1));
        }
        String result=eventsName.get(0);
        eventsName.remove(0);
        events.remove(0);
        return result;
    }
}
