import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return this.year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return this.month;
    }

    public void setDay() {
        this.day = day;
    }

    public int getDay() {
        return this.day;
    }

    public void addDays(int days) {
        if (day+days<dayOfMonth()){
            day = day+days;
        }else {
        while (day+days>dayOfMonth()){
            day = day+days-dayOfMonth();
            month++;
            days = 0;
        if (month<=12){
            }
        else {
            month=1;
            year++;
        }
        }
    }}

    public String toString() {
        if (month>=10&&day>=10){
        return String.format(year + "-" + month + "-" + day);
    }else if(month>=10&&day<10){return String.format(year+"-"+month+"-0"+day);
    }else if (month<10&&day>=10){
            return String.format(year+"-"+"0"+month+"-"+day);
        }else{
            return String.format(year+"-0"+month+"-0"+day);
        }
    }

    public int dayOfMonth() {
        int da = 0;
        if (getYear() % 4 == 0 && getYear() % 100 != 0 || getYear() % 400 == 0) {
            switch (month) {
                case 1:
                    da += 31;
                    break;
                case 3:
                    da += 31;
                    break;
                case 5:
                    da += 31;
                    break;
                case 7:
                    da += 31;
                    break;
                case 8:
                    da += 31;
                    break;
                case 10:
                    da += 31;
                    break;
                case 12:
                    da += 31;
                    break;
                case 2:
                    da += 29;
                    break;
                case 4:
                    da += 30;
                    break;
                case 6:
                    da += 30;
                    break;
                case 9:
                    da += 30;
                    break;
                case 11:
                    da += 30;
                    break;
            }
        } else {
            switch (month) {
                case 1:
                    da += 31;
                    break;
                case 3:
                    da += 31;
                    break;
                case 5:
                    da += 31;
                    break;
                case 7:
                    da += 31;
                    break;
                case 8:
                    da += 31;

                    break;
                case 10:
                    da += 31;
                    break;
                case 12:
                    da += 31;
                    break;
                case 2:
                    da += 28;
                    break;
                case 4:
                    da += 30;
                    break;
                case 6:
                    da += 30;
                 break;
                case 9:
                    da += 30;
                    break;
                case 11:
                    da += 30;
                    break;

            }
        }return da;
    }
    public static int difference(MyDate date1, MyDate date2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lo1 = LocalDate.parse(date1.toString(),formatter);
        LocalDate lo2 = LocalDate.parse(date2.toString(),formatter);
        long daysdifference= ChronoUnit.DAYS.between(lo1,lo2);
        int intvalue = -(int)daysdifference;
        return intvalue;

        }

}
