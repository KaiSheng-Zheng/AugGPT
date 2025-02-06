import java.util.ArrayList;

public class MyCalendar {
    private final int maxUnfinishedEvents;
    public int totalUnfinishedEvents;

    public MyCalendar(int capacity) {
        this.maxUnfinishedEvents = capacity;
    }

    public boolean addEvent(MyDate date, String event1) {
        if (this.totalUnfinishedEvents < maxUnfinishedEvents) {
            //date.UnfinishedEventsOfThisDate++;
            this.totalUnfinishedEvents++;
            event newEvent = new event(this, date, event1);
            event.events.add(newEvent);
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        MyDate optDate = getOptDate();
        if (MyDate.getNumUnEventsOfThisDateInThisCalendar(optDate, this) == 0) {
            return "NONE";
        } else {
            this.totalUnfinishedEvents--;
            //find the alphabetically first unfinished event of that date
            int indexOfTheOptimalEvent = getIndexOfTheOptimalEvent(optDate);
            //return optDate.events[1].toString();
            String result = event.events.get(indexOfTheOptimalEvent).name;
            event.events.get(indexOfTheOptimalEvent).isFinished = true;
            return result;
        }
    }

    private static int getIndexOfTheOptimalEvent(MyDate optDate) {
        int indexOfTheOptimalEvent = 0;
        for (int i = 0; i < event.events.size(); i++) { // iterate through all the events
            if (event.events.get(i).date == optDate && !event.events.get(i).isFinished) { // ensure the event is at the optDate and is not finished
                if (event.events.get(i).name.compareTo
                        (event.events.get(indexOfTheOptimalEvent).name) < 0
                        || event.events.get(indexOfTheOptimalEvent).isFinished) { // ensure the event alphabetically precedes the optEvent or the optEvent is finished
                    indexOfTheOptimalEvent = i;
                }
            }
        }
        return indexOfTheOptimalEvent;
    }

    private MyDate getOptDate() {
        MyDate optDate = new MyDate(9999,1,1);
            for (int j = 0; j < event.events.size(); j++) { // iterate through all the events
                if (event.events.get(j).calendar == this && !event.events.get(j).isFinished) { // ensure the event is at the current calendar and is not finished
                    if (MyDate.formerIsEarlier(event.events.get(j).date, optDate)) { // ensure the event is earlier than the previous optDate
                        optDate = event.events.get(j).date; // change the optDate to this event
                    }
                }
            }
        return optDate;
    }
}
class event {
    MyDate date;
    String name;
    MyCalendar calendar;

    public static ArrayList<event> events = new ArrayList<>();
    boolean isFinished = false;

    public event(MyCalendar calendar, MyDate date, String name) {
        this.date = date;
        this.name = name;
        this.calendar = calendar;
    }
}
