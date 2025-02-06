import java.time.LocalDate;
import java.time.LocalDateTime;
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addDays(int days) {
        LocalDate date=LocalDate.of(year,month,day);
        date=date.plusDays(days);
        year=date.getYear();
        month=date.getMonthValue();
        day=date.getDayOfMonth();
    }
    public String toString() {
        if(month<10){
            if(day<10){
                return year+"-"+"0"+month+"-"+"0"+day;
            }else{
                return year+"-"+"0"+month+"-"+day;
            }
        }else{
            if(day<10){
                return year+"-"+month+"-"+"0"+day;
            }else{
                return year+"-"+month+"-"+day;
            }
        }
    }
    public static int difference(MyDate date1,MyDate date2){
        int d=0;
        if(date1.year<date2.year){
            for (int i = date1.year; i < date2.year; i++) {
                if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0){
                    d-=366;
                }else{
                    d-=365;
                }
            }
            for (int i = 1; i < date1.month; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 ||
                        i == 8 || i == 10 || i == 12) {
                    d+= 31;
                } else if (i == 2) {
                    if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0) {
                        d+=29;
                    }else{
                        d+=28;
                    }
                }else{
                    d+=30;
                }
            }
            for (int i = 1; i < date2.month; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 ||
                        i == 8 || i == 10 || i == 12) {
                    d -= 31;
                } else if (i == 2) {
                    if ((date2.year % 4 == 0 && date2.year % 100 != 0) || date2.year % 400 == 0) {
                        d-=29;
                    }else{
                        d-=28;
                    }
                }else{
                    d-=30;
                }
            }
            d+=(date1.day-date2.day);
        }else if(date1.year>date2.year){
            for (int i = date2.year; i < date1.year; i++) {
                if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0){
                    d+=366;
                }else{
                    d+=365;
                }
            }
            for (int i = 1; i < date2.month; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 ||
                        i == 8 || i == 10 || i == 12) {
                    d-= 31;
                } else if (i == 2) {
                    if ((date2.year % 4 == 0 && date2.year % 100 != 0) || date2.year % 400 == 0) {
                        d-=29;
                    }else{
                        d-=28;
                    }
                }else{
                    d-=30;
                }
            }for (int i = 1; i < date1.month; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 ||
                        i == 8 || i == 10 || i == 12) {
                    d += 31;
                } else if (i == 2) {
                    if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0) {
                        d+=29;
                    }else{
                        d+=28;
                    }
                }else{
                    d+=30;
                }
            }
            d+=(date1.day-date2.day);
        }else{
            if(date1.month<date2.month){
                for (int i = date1.month; i < date2.month; i++) {
                    if (i == 1 || i == 3 || i == 5 || i == 7 ||
                            i == 8 || i == 10 || i == 12) {
                        d-= 31;
                    } else if (i == 2) {
                        if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0) {
                            d-=29;
                        }else{
                            d-=28;
                        }
                    }else{
                        d-=30;
                    }
                }
            }else {
                for (int i = date2.month; i < date1.month; i++) {
                    if (i == 1 || i == 3 || i == 5 || i == 7 ||
                            i == 8 || i == 10 || i == 12) {
                        d+= 31;
                    } else if (i == 2) {
                        if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0) {
                            d+=29;
                        }else{
                            d+=28;
                        }
                    }else{
                        d+=30;
                    }
                }
            }
            d+=(date1.day-date2.day);
        }
        return d;
    }
}