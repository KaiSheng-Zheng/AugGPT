import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days){
        LocalDate ansdate=LocalDate.of(getYear(),getMonth(),getDay()).plusDays((long) days);
        setYear(ansdate.getYear());
        setMonth(ansdate.getMonthValue());
        setDay(ansdate.getDayOfMonth());
    }
    public String toString(){
        return String.format("%d-%02d-%02d",getYear(),getMonth(),getDay());
    }
    public static int difference(MyDate date1, MyDate date2){
        LocalDate date01=LocalDate.of(date1.getYear(), date1.getMonth(),date1.getDay());
        LocalDate date02=LocalDate.of(date2.getYear(), date2.getMonth(),date2.getDay());
        int days= (int) ChronoUnit.DAYS.between(date01,date02);
        return days*(-1);
    }
}