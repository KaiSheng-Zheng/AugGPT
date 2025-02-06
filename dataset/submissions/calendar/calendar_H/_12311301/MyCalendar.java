import java.util.ArrayList;

public class MyCalendar {

    class Event{
        public int getDate() {
            return date;
        }

        private int date;

        public String getEvent() {
            return event;
        }

        private String event;

        public Event(int date,String event) {
            this.date = date;
            this.event = event;
        }
    }
    private int capacity;
    private ArrayList<Event> event;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.event = new ArrayList<>(capacity);
    }

    public boolean addEvent(MyDate date, String eventName) {
        if(event.size() >= capacity) {
            return false;
        }else{
            event.add(new Event(date.getTotal(),eventName));
            return true;
        }

    }

    public String finishNextEvent() {
        if(event.isEmpty()) return "NONE";
        int minDate = event.get(0).getDate();
        for(int i = 1; i < event.size(); i++) {
            if(event.get(i).getDate() < minDate) {
                minDate = event.get(i).getDate();
            }
        }
        ArrayList<Event> choice=  new ArrayList<>();
        for(int i = 0; i < event.size(); i++) {
            if(event.get(i).getDate() == minDate) {
                choice.add(event.get(i));
            }
        }
        String minEvent = choice.get(0).getEvent();
        for(int i = 1; i < choice.size(); i++) {
            if(choice.get(i).getEvent().compareTo(minEvent) < 0) {
                minEvent = choice.get(i).getEvent();
            }
        }
        for(int i = 0; i < event.size(); i++) {
            if(event.get(i).getEvent().equals(minEvent)) {
                String temp = event.get(i).getEvent();
                event.remove(event.get(i));
                return temp;
            }
        }
        return "NONE";



    }







}