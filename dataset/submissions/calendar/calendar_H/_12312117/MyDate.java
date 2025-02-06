import java.util.Calendar;
public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int _year,int _month,int _day){
        year=_year;
        month=_month;
        day=_day;
    }
    public void addDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }
    public static int difference(MyDate date1, MyDate date2) {
        Calendar example1 = Calendar.getInstance();
        example1.set(date1.year, date1.month - 1, date1.day);
        Calendar example2 = Calendar.getInstance();
        example2.set(date2.year, date2.month - 1, date2.day);
        long shijianchuo1 = example1.getTimeInMillis();
        long shijianchuo2 = example2.getTimeInMillis();
        long dif = (shijianchuo2 - shijianchuo1) / 86400000;
        return (int) dif;
    }
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
