import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {
    private int capacity;

    public ArrayList<Event> getMyEvents() {
        return myEvents;
    }

    public void setMyEvents(ArrayList<Event> myEvents) {
        this.myEvents = myEvents;
    }

    private ArrayList<Event> myEvents;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.myEvents = new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        boolean isEmpty;
        if(myEvents.size() < capacity){
            isEmpty = true;
            Event e = new Event(date,eventName);
            myEvents.add(e);
        }else isEmpty = false;
        return isEmpty;
    }
    public String finishNextEvent(){
        String a = "";
        eventNameOrder(myEvents);
        dateOrder(myEvents);
        if (myEvents.isEmpty()){
            a = "NONE";
        }else {
            a = myEvents.get(0).getEventName();
            myEvents.remove(0);
        }
        return a;
    }
    public void dateOrder(ArrayList<Event> myEvents){
        for (int i = 0; i < myEvents.size(); i++) {
            for (int j = 0; j < myEvents.size()-1; j++) {
                if (MyDate.date2IsEarly(myEvents.get(j).getDate(),myEvents.get(j+1).getDate())){
                    Event a = new Event();
                    a = myEvents.get(j+1);
                    myEvents.set(j+1,myEvents.get(j));
                    myEvents.set(j,a);
                }
            }
        }
    }
    public void eventNameOrder(ArrayList<Event> myEvents){
        ArrayList<String> eventName = new ArrayList<>();
        for (int i = 0; i < myEvents.size(); i++) {
            eventName.add(myEvents.get(i).getEventName());
        }
        Collections.sort(eventName);
        for (int i = 0; i < myEvents.size(); i++) {
            for (int j = 0; j < myEvents.size(); j++) {
                if (eventName.get(i).equals(myEvents.get(j).getEventName())){
                    Event a = new Event();
                    a = myEvents.get(j);
                    myEvents.set(j,myEvents.get(i));
                    myEvents.set(i,a);
                }
            }
        }
    }
    class Event {
        private MyDate date;
        private String eventName;

        public Event(MyDate date, String eventName) {
            this.date = date;
            this.eventName = eventName;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "date=" + date +
                    ", eventName='" + eventName + '\'' +
                    '}';
        }

        public Event() {
        }

        public MyDate getDate() {
            return date;
        }

        public void setDate(MyDate date) {
            this.date = date;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }
    }
}