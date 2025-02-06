import java.util.*;
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        Calendar calendar = new GregorianCalendar(this.year, this.month - 1, this.day);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }


    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        Calendar cal1 = new GregorianCalendar(date1.year, date1.month - 1, date1.day);
        Calendar cal2 = new GregorianCalendar(date2.year, date2.month - 1, date2.day);

        long diffInMillis = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        return (int) ((-1) * diffInMillis / (24 * 60 * 60 * 1000));
    }
}


