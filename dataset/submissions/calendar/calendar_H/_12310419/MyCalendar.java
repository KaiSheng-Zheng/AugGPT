import java.util.ArrayList;
import java.util.Date;

public class MyCalendar {
    private ArrayList<MyDate> dates=new ArrayList<>();
    private ArrayList<String> events=new ArrayList<>();
    private int id=-1;
    private int capacity;
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }

    public ArrayList<MyDate> getDates() {
        return dates;
    }

    public void setDates(ArrayList<MyDate> dates) {
        this.dates = dates;
    }

    public ArrayList<String> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<String> events) {
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        id++;
        if (id+1 <= capacity){
            this.dates.add(date);
            this.events.add(eventName);
        }
        return id+1 <= capacity;
    }
    public String finishNextEvent(){
        for (int i = 0; i <dates.size()-1 ; i++) {
            if (MyDate.difference(dates.get(i),dates.get(i+1))<0){
                MyDate c1=dates.get(i+1);
                String c2=events.get(i+1);
                dates.set(i+1,dates.get(i));
                events.set(i+1,events.get(i));
                dates.set(i,c1);
                events.set(i,c2);
            } else if (MyDate.difference(dates.get(i),dates.get(i+1))==0) {
                if (events.get(i).compareTo(events.get(i+1))<0){
                    MyDate c1=dates.get(i+1);
                    String c2=events.get(i+1);
                    dates.set(i+1,dates.get(i));
                    events.set(i+1,events.get(i));
                    dates.set(i,c1);
                    events.set(i,c2);
                }
            }

        }
        String c="NONE";
        if (!dates.isEmpty()){
            c=events.get(events.size()-1);
            dates.remove(dates.size()-1);
            events.remove(events.size()-1);
        }
        this.id--;
        return c;
    }
}
