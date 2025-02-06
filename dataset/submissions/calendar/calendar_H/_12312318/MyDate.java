import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(toString()));
            cal.add(Calendar.DAY_OF_MONTH, days);
            this.year = cal.get(Calendar.YEAR);
            this.month = cal.get(Calendar.MONTH) + 1;
            this.day = cal.get(Calendar.DAY_OF_MONTH);
        }catch (Exception e) {
        }
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        try {
            String beginDate = date1.toString();
            String endDate = date2.toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(beginDate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(endDate));
            long time2 = cal.getTimeInMillis();
            long betweenSeconds = (time1 - time2) / (1000 * 60 * 60 * 24);
            return Integer.parseInt(String.valueOf(betweenSeconds));
        } catch (Exception e) {
        }
        return 0;
    }
}