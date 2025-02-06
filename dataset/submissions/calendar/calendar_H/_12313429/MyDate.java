import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] diff=new int[1];

    public MyDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }public void addDays(int days) {
        LocalDate chushidate = LocalDate.of(year, month, day);
        LocalDate gengxin = chushidate.plusDays(days);
        this.year = gengxin.getYear();
        this.month = gengxin.getMonthValue();
        this.day = gengxin.getDayOfMonth();
    }

    public String toString() {
        String DATE = String.format("%04d-%02d-%02d", year, month, day);
        return DATE;
    }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDate b = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate e = LocalDate.of(date2.year, date2.month, date2.day);

        long D = ChronoUnit.DAYS.between(b, e);
int Z=(int)D*(-1);
        return Z;
    }
}
