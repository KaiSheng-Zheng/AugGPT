import java.util.ArrayList;

public class MyCalendar {
    ArrayList<String> Calendar;
    ArrayList<MyDate> dateOfCalendar;
    private final int capacity;

    public MyCalendar (int capacity) {
        this.capacity = capacity;
        this.Calendar = new ArrayList<String>();
        this.dateOfCalendar = new ArrayList<>();
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (Calendar!=null&&Calendar.size() >= capacity) {
            return false;
        } else {
            Calendar.add(eventName);
            dateOfCalendar.add(date);
            return true;
        }
    }

    public String finishNextEvent() {
        if(Calendar.isEmpty()){
            return "NONE";
        }
        MyDate DateOfNextEvent = dateOfCalendar.get(0);
        int Index = 0;
        for (MyDate a : dateOfCalendar) {
            if (MyDate.difference(a, DateOfNextEvent) < 0) {
                DateOfNextEvent = a;
                Index = dateOfCalendar.indexOf(a);
            } else if (MyDate.difference(a, DateOfNextEvent) == 0) {
                DateOfNextEvent = Calendar.get(dateOfCalendar.indexOf(a)).compareTo(Calendar.get(Index)) > 0 ? a : DateOfNextEvent;
                Index = Calendar.get(dateOfCalendar.indexOf(a)).compareTo(Calendar.get(Index)) < 0 ? dateOfCalendar.indexOf(a) : Index;
            }
        }
        String EventName = Calendar.get(Index);
        Calendar.remove(Index);
        dateOfCalendar.remove(Index);
        return EventName;
    }
}
