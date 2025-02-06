import java.time.LocalDate;

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
        LocalDate localDate = LocalDate.of(year, month, day).plusDays(days);
        this.year = localDate.getYear();
        this.month = localDate.getMonthValue();
        this.day = localDate.getDayOfMonth();
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

   
   
    
    public static int difference(MyDate date1, MyDate date2) {
        LocalDate localDate1 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate localDate2 = LocalDate.of(date2.year, date2.month, date2.day);
        return (int) java.time.temporal.ChronoUnit.DAYS.between(localDate2, localDate1);
    }

   


    
    @Override
    public int compareTo(MyDate other) {
        LocalDate thisDate = LocalDate.of(this.year, this.month, this.day);
        LocalDate otherDate = LocalDate.of(other.year, other.month, other.day);
        return thisDate.compareTo(otherDate);
    }
}
