import java.util.ArrayList;

public class MyCalendar {

    private int capacity;
    private ArrayList<MyDate> myCalendar = new ArrayList<>();
    private  int cnt = 0;
    private ArrayList<String> myList = new ArrayList<>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (cnt < capacity) {

            String formedEvent = eventName;

            if (myList.isEmpty()) {
                myList.add(formedEvent);
                myCalendar.add(date);
            } else {
                int dateNode = 0;
                int temp = 0;
                while (dateNode < myList.size()) {
                    int diff = MyDate.difference(date, myCalendar.get(dateNode));
                    if (diff > 0 || (diff == 0 && formedEvent.compareTo(myList.get(dateNode)) > 0)) {
                        temp ++;
                    }
                    dateNode++;

                }
                if (temp != myList.size()) {
                    myList.add(temp, formedEvent);
                    myCalendar.add(temp, date);
                }
                if (temp == myList.size() && (MyDate.difference(date, myCalendar.get(dateNode-1)) > 0
                        || (MyDate.difference(date, myCalendar.get(dateNode-1)) == 0 && formedEvent.compareTo(myList.get(dateNode-1)) >= 0)))
                {
                    myList.add(formedEvent);
                    myCalendar.add((date));
                }
                if (temp == myList.size() && (MyDate.difference(date, myCalendar.get(dateNode-1)) > 0
                        || !(MyDate.difference(date, myCalendar.get(dateNode-1)) == 0 && formedEvent.compareTo(myList.get(dateNode-1)) >=0)))
                {
                    myList.add(temp-1, formedEvent);
                    myCalendar.add(temp-1, date);
                }
            }
            cnt++;
            return true;
        }
        return false;
    }

    public String finishNextEvent() {
        String finishEvent = "";
        if (myList.isEmpty()) {
            return "NONE";
        } else {
            finishEvent = myList.get(0);
            myList.remove(0);
            myCalendar.remove(0);
            cnt--;
        }

        return finishEvent;
    }




}