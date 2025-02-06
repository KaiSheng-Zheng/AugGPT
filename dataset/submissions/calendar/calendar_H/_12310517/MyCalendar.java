public class MyCalendar {
    private final MyDate[] Dates;
    private final String[] Names;
    private int NowAt1, NowAt2;
    private final int capacity;

    public MyCalendar (int capacity) {
        Dates = new MyDate[capacity * 10];
        Names = new String[capacity * 10];
        NowAt1 = NowAt2 = 0;
        this.capacity = capacity;
    }

    public boolean addEvent (MyDate date, String eventName) {
        if (NowAt1 - NowAt2 == capacity) {
            return false;
        }
        Dates[NowAt1] = new MyDate(date.getYear(), date.getMonth(), date.getDay());
        Names[NowAt1] = eventName;
        NowAt1++;
        for (int i = NowAt1 - 1; i > NowAt2; --i) {
            if (MyDate.difference(Dates[i], Dates[i - 1]) > 0) {
                break;
            } else if (MyDate.difference(Dates[i], Dates[i - 1]) == 0) {
                if (Names[i].compareTo(Names[i - 1]) >= 0) {
                    break;
                } else {
                    MyDate a = Dates[i];
                    Dates[i] = Dates[i - 1];
                    Dates[i - 1] = a;
                    String s = Names[i];
                    Names[i] = Names[i - 1];
                    Names[i - 1] = s;
                }
            } else {
                MyDate a = Dates[i];
                Dates[i] = Dates[i - 1];
                Dates[i - 1] = a;
                String s = Names[i];
                Names[i] = Names[i - 1];
                Names[i - 1] = s;
            }
        }
        return true;
    }

    public String finishNextEvent () {
        if (NowAt2 < NowAt1) {
            return Names[NowAt2++];
        } else {
            return "NONE";
        }
    }
}
