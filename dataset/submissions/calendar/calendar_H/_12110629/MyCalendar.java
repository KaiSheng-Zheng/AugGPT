import java.util.*;

class MyCalendar {
    private Map<String,MyDate> events=new HashMap<>();
    private int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (events.size() >= capacity) {
            return false;
        }
        events.put(eventName,date);
        return true;
    }

    public String finishNextEvent() {

        for (int i = 0; i < events.entrySet().size(); i++) {
            for (int j = 0; j<events.entrySet().size()-i-1;j++) {

                if(MyDate.difference(events.get(j),events.get(j+1))>=0){
                    MyDate temp=events.get(j);
                }


            }
        }

        events.entrySet().forEach(e->{
            System.out.println(e.getKey());
        });
        return "";
    }
}