import java.time.LocalDate;
import java.util.stream.StreamSupport;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private int countdate;
    private int reduce;
    public MyDate (int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
        countdate++;
        if(month == 1 || month == 3 || month == 5 || month ==7 || month == 8 || month ==10 || month ==12){
            this.reduce = 31;
        }
        else if (month == 2) {
            if (year % 4 == 0 && year % 100 > 0 || year % 400 == 0) {
                if (day > 29) {
                    this.reduce = 29;
                }
            }
            else{
                this.reduce = 28;
            }
        }
        else{
            this.reduce = 30;
        }
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setDay(int day){
        this.day = day;
    }
    public void setCountdate(int countdate){
        this.countdate = countdate;
    }
    public int getCountdate(){
        return countdate;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public void addDays (int day){
        this.day += day;
        while (this.day > reduce) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day > 31) {
                    this.day -= 31;
                    this.month += 1;
                    if (month > 12) {
                        this.year += 1;
                        this.month = 1;
                    }
                }
            } else if (month == 2) {
                if (year % 4 == 0 && year % 100 > 0 || year % 400 == 0) {
                    if (day > 29) {
                        this.day -= 29;
                        this.month += 1;
                    }
                } else {
                    this.day -= 28;
                    this.month += 1;
                }
            } else {
                if (day > 30) {
                    this.day -= 30;
                    this.month += 1;
                }
            }
        }
    }
    public String toString(){
        String string = "";
        if (this.month < 10){
            string = String.format("%d-0%d-%d", year, month, day);
        }
        if (this.day < 10){
            string = String.format("%s-%s-0%s", year, month, day);
        }
        if(this.month > 9 && this.day > 9){
            string = String.format("%s-%s-%s", year, month, day);
        }
        if (this.day <10 && this.month < 10){
            string = String.format("%s-0%s-0%s", year, month, day);
        }


        return string;
    }
    public static int difference(MyDate date1, MyDate date2){
        LocalDate local1 = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDay());
        LocalDate local2 = LocalDate.of(date2.getYear(), date2.getMonth(), date2.getDay());
        long diff = (local1.toEpochDay() - local2.toEpochDay());
        return (int) diff;
    }
}
