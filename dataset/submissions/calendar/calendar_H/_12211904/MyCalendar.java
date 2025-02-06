public class MyCalendar {
    private int capacity, num = 0;
    private static String[] event;
    private static MyDate[] dates;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        event = new String[capacity];
        dates = new MyDate[capacity];
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (num >= capacity) {
            return false;
        } else {
            dates[num] = date;
            event[num] = eventName;
            num++;
            for (int i = 0; i < num; i++) {
                for (int j = 1; j < num; j++) {
                    if (MyDate.Compare(dates[j - 1], dates[j])) {
                        MyDate a = dates[j];
                        dates[j] = dates[j - 1];
                        dates[j - 1] = a;
                        String b = event[j];
                        event[j] = event[j - 1];
                        event[j - 1] = b;
                    }
                }
            }
            for (int i = 1; i < num; i++){
                if(dates[i-1]==dates[i]){
                    if(event[i-1].compareTo(event[i])>0){
                        String b = event[i];
                        event[i] = event[i - 1];
                        event[i - 1] = b;
                    }
                }
            }
            return true;
        }
    }

    public String finishNextEvent() {
        if (event[0] == null) {
            return "NONE";
        } else {
            String a = event[0];
            if (num > 1) {
                for (int i = 1; i < num; i++) {
                    event[i - 1] = event[i];
                    dates[i - 1] = dates[i];
                }
            }
            event[num-1]=null;
            dates[num-1]=null;
            num--;
            return a;
        }

    }
}
