public class MyCalendar {
    private String[] event;
    private MyDate[] dates;
    private int capacity;
    private int count = 0;

    public MyCalendar(int capacity) {
        this.event = new String[capacity];
        this.dates = new MyDate[capacity];
        this.capacity = capacity;
        for (int i = 0; i < capacity; i++) {
            event[i] = "WTF";
            dates[i] = new MyDate(9999, 12, 31);
        }
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (count == capacity)
            return false;
        else {
            event[count] = eventName;
            dates[count].setDay(date.getDay());
            dates[count].setMonth(date.getMonth());
            dates[count].setYear(date.getYear());
            count++;
            return true;
        }
    }

    public String finishNextEvent() {
        if (count == 0) {
            return "NONE";
        } else {
            int Edate = 0;
            int tempdate = Integer.MAX_VALUE;
            String Str="ZZZZZZZZZZZZZZZZZZZZZZZZ";
            for (int i = 0; i < count; i++) {
                if (MyDate.Date2Str(dates[i]) < tempdate) {
                    Edate = i;
                    tempdate = MyDate.Date2Str(dates[i]);
                    Str =event[i];
                } else if (MyDate.Date2Str(dates[i]) == tempdate) {
                    if (event[i].compareTo(Str)<0) {
                        Edate = i;
                        Str=event[i];
                    }

                }
            }
            String a = event[Edate];
            for (int i = Edate; i < count - 1; i++) {
                dates[i].setYear(dates[i + 1].getYear());
                dates[i].setMonth(dates[i + 1].getMonth());
                dates[i].setDay(dates[i + 1].getDay());
                event[i] = event[i + 1];
            }
            Edate = 0;
            tempdate = Integer.MAX_VALUE;
            dates[count - 1].setYear(9999);
            for (int i = 0; i < count; i++) {
                if (MyDate.Date2Str(dates[i]) < tempdate) {
                    Edate = i;
                    tempdate = MyDate.Date2Str(dates[i]);
                }
            }
            count--;

            return a;
        }
    }
}
