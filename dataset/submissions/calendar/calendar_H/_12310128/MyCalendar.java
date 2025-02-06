public class MyCalendar {
    private final int capacity;
    private int count = 0;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new String[capacity];
        dates = new MyDate[capacity];
        datesInt = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            datesInt[i] = 99999999;
            dates[i] = new MyDate(9999,99,99);
            events[i] = "Blank";
        }
    }

    private final String[] events;
    private final MyDate[] dates;

    public boolean addEvent(MyDate date, String eventName) {
        int count2 = count;
        if (count < capacity) {
            count++;
            for (int i = 0; i < capacity; i++) {
                if (datesInt[i] == 99999999) {
                    events[i] = eventName;
                    dates[i] = date;
                    datesInt[i] = dates[i].getYear() * 10000 + dates[i].getMonth() * 100 + dates[i].getDay();
                    break;
                }
            }
        }
        return count2 < capacity;
    }

    private final int[] datesInt;
    public String finishNextEvent() {
        if (count > 0) {
            int minDates = datesInt[0];
            int[] temp = new int[capacity];
            int a = 0;
            for (int i = 0; i < capacity; i++) {
                if (datesInt[i] < minDates) {
                    minDates = datesInt[i];
                }
            }
            for (int i = 0; i < capacity; i++) {
                if (datesInt[i] == minDates) {
                    temp[a] = i;
                    a++;
                }
            }
            String nextEvent = events[temp[0]];
            int b = temp[0];
            for (int i = 0; i < a; i++) {
                if (events[temp[i]].compareTo(nextEvent) < 0) {
                    nextEvent = events[temp[i]];
                    b = temp[i];
                }
            }
            dates[b] = new MyDate(9999, 99, 99);
            datesInt[b] = 99999999;
            count--;
            return nextEvent;
        } else {
            return "NONE";
        }

    }
}
