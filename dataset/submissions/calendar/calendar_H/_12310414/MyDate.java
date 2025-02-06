import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
    }
    public void addDays(int days) {
        LocalDate currentDate = toLocalDate();
        LocalDate newDate = currentDate.plusDays(days);
        this.year = newDate.getYear();
        this.month = newDate.getMonthValue();
        this.day = newDate.getDayOfMonth();
    }
    public String toString(){
        if (month < 10 && day < 10){
            return year +"-"+ "0" + month +"-"+ "0" + day;
        }
        else if (month > 10 && day > 10){
            return year + "-" + month + "-" + day;
        }
        else if (month > 10 && day < 10){
            return year + "-" + month + "-" +"0"+ day;
        }
        else {
            return year + "-" +"0"+ month + "-" + day;
        }
    }


    public static int difference(MyDate date1, MyDate date2){
        LocalDate localDate1 = date1.toLocalDate();
        LocalDate localDate2 = date2.toLocalDate();

        
        long daysDifference = calculateDaysDifference(localDate1, localDate2);
        return (int) (daysDifference*(-1));
    }
    private static long calculateDaysDifference(LocalDate date1, LocalDate date2) {
        
        return ChronoUnit.DAYS.between(date1, date2);
    }


    
    public int getYear() {
        return year;
    }

    
    public void setYear(int year) {
        this.year = year;
    }

    
    public int getMonth() {
        return month;
    }

    
    public void setMonth(int month) {
        this.month = month;
    }

    
    public int getDay() {
        return day;
    }

    
    public void setDay(int day) {
        this.day = day;
    }
}
