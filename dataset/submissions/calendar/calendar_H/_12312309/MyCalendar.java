import java.util.ArrayList;

public class MyCalendar {

    private int capacity;
    ArrayList<MyDate> dateList;
    ArrayList<String> eventList;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        dateList = new ArrayList<>();
        eventList = new ArrayList<>();

    }

    int count = 0;


    public boolean addEvent(MyDate date, String eventName) {
        if (count > capacity - 1) {
            return false;
        } else {
            if (dateList.isEmpty()) {
                dateList.add(date);
                eventList.add(eventName);
            } else {
                int time = 0;
                for (int i = 0; i < dateList.size(); i++) {
                    if (MyDate.difference(date,dateList.get(i)) < 0) {
                        dateList.add(i,date);
                        eventList.add(i,eventName);
                        time++;
                        break;
                    } else if (MyDate.difference(date,dateList.get(i)) == 0) {
                        if (eventName.compareTo(eventList.get(i)) <= 0) {
                            dateList.add(i,date);
                            eventList.add(i,eventName);
                            time++;
                            break;
                        } else {
                            continue;
                        }
                    }
                }
                if (time == 0) {
                    dateList.add(date);
                    eventList.add(eventName);
                } else {
                    time = 0;
                }

            }
            count++;
            return true;
        }

    }

    int order = 0;


    public String finishNextEvent() {
        if(count == 0) {
            return "NONE";
        }
        String nextEvent;
        nextEvent = eventList.get(0).toString();
        eventList.remove(0);
        dateList.remove(0);
        count--;
        return nextEvent;

    }

}
