import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class MyCalendar {
    int eventAmount = 0;
    int capacity;


    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    ArrayList<MyDate> datelist = new ArrayList<>(capacity);
    ArrayList<String> eventlist = new ArrayList<>(capacity);

    public boolean addEvent(MyDate date, String eventName) {
        eventAmount++;
        if (eventAmount > capacity) {
            eventAmount--;
            return false;
        } else {
            if (eventAmount == 1) {
                datelist.add(date);
                eventlist.add(eventName);
            } else {
                datelist.add(date);
                for (int j = 0; j < eventAmount; j++) {
                    for (int i = eventAmount - 1; i > 0; i--) {
                        if (MyDate.difference(datelist.get(i), datelist.get(i - 1)) < 0) {
                            MyDate datex = datelist.get(i - 1);
                            datelist.remove(i - 1);
                            datelist.add(i, datex);
                        }
                    }
                }
                eventlist.add(datelist.lastIndexOf(date), eventName);
                for (int i = datelist.lastIndexOf(date); i > 0; i--) {
                    if (MyDate.difference(datelist.get(i), datelist.get(i-1)) == 0) {
                        if (eventlist.get(i).compareTo(eventlist.get(i - 1)) < 0) {
                            String str = eventlist.get(i - 1);
                            eventlist.remove(i - 1);
                            eventlist.add(i, str);
                        }
                    }
                }
            }
            //System.out.println(eventlist);
            return true;
        }
    }

    public String finishNextEvent() {
        if (eventAmount == 0) return "NONE";
        else {
            String x = eventlist.get(0);
            eventlist.remove(0);
            datelist.remove(0);
            eventAmount--;
           return x;
        }
    }

}
