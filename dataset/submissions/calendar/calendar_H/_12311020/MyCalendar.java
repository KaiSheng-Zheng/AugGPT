import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    public int eventNum = 0;
    private ArrayList<MyDate> arrayTime;
    private ArrayList<String> arrayEvent;


    public MyCalendar(int capacity) {
        arrayEvent = new ArrayList<>();
        arrayTime = new ArrayList<>();
        this.capacity = capacity;
    }


    public boolean addEvent(MyDate date, String eventName) {
        eventNum += 1;
        if (eventNum > this.capacity) {
            eventNum -= 1;
            return false;
        }
        boolean flag = true;
        for (int i = 0; i < eventNum; i++) {
            try {
                if (arrayTime.get(i).compare() > date.compare() || (MyDate.difference(arrayTime.get(i), date) == 0 && arrayEvent.get(i).compareTo(eventName) > 0)) {
                    arrayTime.add(i, date);
                    arrayEvent.add(i, eventName);
                    flag = false;
                    break;
                }
            } catch (IndexOutOfBoundsException e) {

            }
        }
        if (flag) {
            arrayTime.add(date);
            arrayEvent.add(eventName);
        }
        return true;
    }

    public String finishNextEvent() {
        if (eventNum > 0) {
            eventNum--;
            String output = arrayEvent.get(0);
            arrayEvent.remove(0);
            arrayTime.remove(0);
            return output;

        } else
            return "NONE";

    }
}
