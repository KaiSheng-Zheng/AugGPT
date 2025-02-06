import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days){
        int[] md = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] md1 = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        this.day += days;
        boolean isTrue = true;
        while (isTrue){
            if(year%4==0&&year%100!=0||year%400==0){
                if (day > md1[month]){
                    day -= md1[month];
                    month += 1;
                    if(month>12){
                        month-=12;
                        year+=1;
                    }
                }if(day < md[month]){
                    isTrue = false;
                }
            }else {
                if (day > md[month]){
                    day -= md[month];
                    month += 1;
                    if(month>12){
                        month-=12;
                        year+=1;
                    }
                }if(day < md[month]){
                    isTrue = false;
                }
            }
        }

    }
@Override
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }

    public static int difference(MyDate date1, MyDate date2){
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date11 = LocalDate.parse(date1.toString(),dft);
        LocalDate date22 = LocalDate.parse(date2.toString(),dft);

        long dif = ChronoUnit.DAYS.between(date22,date11);
        int diff = Long.valueOf(dif).intValue();
        if(diff > 0){
            return diff-2;
        }else if(diff < 0){
            return diff+2;
        }else {
            return diff;
        }
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
