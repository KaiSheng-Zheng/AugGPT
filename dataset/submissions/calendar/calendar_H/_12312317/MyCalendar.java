import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar {

    int capacity;
    int occupaidCapacity = 0;
    ArrayList<MyDate> someDate = new ArrayList<>();




    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }


    public boolean addEvent(MyDate date, String eventName) {
        boolean a = true;
        if (date.eventCounter == 0 && occupaidCapacity + 1 <= capacity) {
            someDate.add(date);
            date.someEvent.add(eventName);
            occupaidCapacity++;
            date.eventCounter++;
        } else if (date.eventCounter != 0 && occupaidCapacity + 1 <= capacity) {
            date.someEvent.add(eventName);
            occupaidCapacity++;
            date.eventCounter++;
        } else {
            a = false;
        }
        return a;
    }

    public String finishNextEvent() {
        for (int m = 0; m < someDate.size() - 1; m++) {
            for (int i = 0; i < someDate.size() - 1; i++) {
                if (i + 1 != someDate.size() && MyDate.difference(someDate.get(i), someDate.get(i + 1)) > 0) {//i>i+1
                    Collections.swap(someDate, i, someDate.size() - 1);
                }
            }
        }
        for (int i = 0; i < someDate.size(); i++) {//choose each date
            for (int m = 0; m < someDate.get(i).someEvent.size() - 1; m++) {
                for (int j = 0; j < someDate.get(i).someEvent.size() - 1; j++) {
                    if ( someDate.get(i).someEvent.get(j).compareTo(someDate.get(i).someEvent.get(j + 1)) > 0) {
                        Collections.swap(someDate.get(i).someEvent, j, j+1);
                    }
                }
            }
        }
        for (int i = 0; i < someDate.size(); i++) {
            if(someDate.get(i).someEvent.size() != 0){
                String stringReturn = someDate.get(i).someEvent.get(0);
                someDate.get(i).someEvent.remove(0);
                occupaidCapacity--;
                return stringReturn;
            }
        }
        return "NONE";
    }
}
