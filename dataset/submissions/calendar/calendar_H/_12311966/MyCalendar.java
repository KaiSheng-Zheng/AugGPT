import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyEvent> events =  new ArrayList<>();

    public MyCalendar(int capacity){
        this.capacity = capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if (events.size() < capacity){
            MyEvent e = new MyEvent(date,eventName);
            events.add(e);
            return true;
        }
        else {return false;}
    }

    public String finishNextEvent() {
        if (this.events.isEmpty()){
            return "NONE";
        }
        else {
            int minIndex = findMinDate(events);
            ArrayList<MyEvent> sameDayEvents = new ArrayList<>();
            MyDate minDate = events.get(minIndex).getDate();
             for (int i = 0; i < events.size(); i++) {
                 MyDate currentDate = events.get(i).getDate();
                if (minDate.getYear() == currentDate.getYear() && minDate.getMonth() == currentDate.getMonth() && minDate.getDay() == currentDate.getDay()){
                    sameDayEvents.add(events.get(i));
                }
             }
             if (sameDayEvents.size() > 0){
                 String s = sameDayEvents.get(findMinName(sameDayEvents)).getEvent();
                 for (int i = 0; i < events.size(); i++) {
                     if (events.get(i).getEvent().equals(s)){events.remove(i);}
                 }
                 return s;
             }else {
                 String s = events.get(minIndex).getEvent();
                 events.remove(minIndex);
                 return s;
             }
        }
    }

    public int findMinDate(ArrayList<MyEvent> events){
        int index = 0;
        MyDate minDate = events.get(0).getDate();
        for (int i = 1; i < events.size(); i++) {
            MyDate currentDate = events.get(i).getDate();
            if ((currentDate.getYear() < minDate.getYear()) ||
                    (currentDate.getYear() == minDate.getYear() && currentDate.getMonth() < minDate.getMonth()) ||
                    (currentDate.getYear() == minDate.getYear() && currentDate.getMonth() == minDate.getMonth() && currentDate.getDay() < minDate.getDay())){
                minDate = currentDate;
                index = i ;
            }
        }
        return index;
    }

    public int findMinName(ArrayList<MyEvent> sameDayEvents){
        int index = 0;
        String minName = sameDayEvents.get(0).getEvent();
        for (int i = 1; i < sameDayEvents.size(); i++) {
            String temp = sameDayEvents.get(i).getEvent();
            if (temp.compareTo(minName) < 0){minName = temp;
                index = i;
            }
        }
        return index;
    }
}

class MyEvent {
    private MyDate date;
    private String event;

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public MyEvent(MyDate date, String event) {
        this.date = date;
        this.event = event;
    }
}