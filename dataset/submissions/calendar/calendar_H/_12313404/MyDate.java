import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyDate implements Comparable<MyDate> {

    private final int year = 0;
    private final int month = 0;
    private final int day = 0;

    private final Calendar calendar;
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

     public MyDate(int year, int month, int day) {
         calendar = Calendar.getInstance();
         calendar.set(year, month - 1, day);
     }

     public void addDays(int days) {
         calendar.add(Calendar.DATE, days);
     }

    @Override
    public String toString() {
        return FORMAT.format(calendar.getTime());
    }

    @Override
    public int compareTo(MyDate o) {
        return calendar.compareTo(o.calendar);
    }

    public static int difference(MyDate date1, MyDate date2) {
        var dif = date1.calendar.getTime().getTime() - date2.calendar.getTime().getTime();
        return (int) (dif / 24 / 60 / 60 / 1000);
    }
}
