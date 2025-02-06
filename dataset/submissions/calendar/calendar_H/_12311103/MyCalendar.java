public class MyCalendar {
    public int count = 0;
    public int[][] dates;
    public String[] events;
    boolean x;
    public int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        dates = new int[capacity][3];
        events = new String[capacity];
    }

    public boolean addEvent(MyDate date, String eventName) {
        count++;
        if (count > capacity) {
            x = false;
            count--;
        } else x = true;
        if (x) {
            dates[count - 1][0] = date.getYear();
            dates[count - 1][1] = date.getMonth();
            dates[count - 1][2] = date.getDay();
            events[count - 1] = eventName;
            return true;
        } else return false;
    }

    public String finishNextEvent() {
        String event;
        int[][] date = new int[1][3];
        date[0][0] = dates[0][0];
        date[0][1] = dates[0][1];
        date[0][2] = dates[0][2];
        int a = 0;
        for (int i = 1; i < count; i++) {
            if (date[0][0] > dates[i][0]) {
                date[0][0] = dates[i][0];
                date[0][1] = dates[i][1];
                date[0][2] = dates[i][2];
                a = i;
            } else {
                if (date[0][0] == dates[i][0] && date[0][1] > dates[i][1]) {
                    date[0][0] = dates[i][0];
                    date[0][1] = dates[i][1];
                    date[0][2] = dates[i][2];
                    a = i;
                } else {
                    if (date[0][0] == dates[i][0] && date[0][1] == dates[i][1] && date[0][2] > dates[i][2]) {
                        date[0][0] = dates[i][0];
                        date[0][1] = dates[i][1];
                        date[0][2] = dates[i][2];
                        a = i;
                    } else {
                        if (events[a]!=null) {
                            if (date[0][0] == dates[i][0] && date[0][1] == dates[i][1]
                                    && date[0][2] == dates[i][2] && events[a].compareTo(events[i]) > 0) {
                                date[0][0] = dates[i][0];
                                date[0][1] = dates[i][1];
                                date[0][2] = dates[i][2];
                                a = i;
                            }
                        }
                    }
                }
            }
        }
        event = events[a];
        for (int i = a; i < events.length - 1; i++) {
            events[i] = events[i + 1];
            dates[i][0] = dates[i+1][0];
            dates[i][1] = dates[i+1][1];
            dates[i][2] = dates[i+1][2];
        }
        events[capacity - 1] = null;
        dates[capacity - 1][0] = 9999999;
        count --;
        if (event != null)
            return event;
        else return "NONE";
    }
}