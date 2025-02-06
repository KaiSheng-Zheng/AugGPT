import java.util.Calendar;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int difference(MyDate date1, MyDate date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.set(date1.year, date1.month - 1, date1.day);
        cal2.set(date2.year, date2.month - 1, date2.day);

        long millis1 = cal1.getTimeInMillis();
        long millis2 = cal2.getTimeInMillis();
        long diffMillis = millis1 - millis2;
        return (int) (diffMillis / (24 * 60 * 60 * 1000));
    }


    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    @Override
    public int compareTo(MyDate other) {
        if (this.year != other.year) {
            return this.year - other.year;
        }
        if (this.month != other.month) {
            return this.month - other.month;
        }
        return this.day - other.day;
    }
}

