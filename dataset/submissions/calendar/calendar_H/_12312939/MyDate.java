import java.util.List;
public class MyDate {
    private int year;
    private int month;
    private int day;
    private List<String> Events;
    public MyDate(int year, int month, int day){
        this.year=year;this.month=month;this.day=day;
    }
    public int getDay() {
        return day;
    }
    public void addEvent(String eventName) {
        this.Events.add(eventName);
    }

    public List<String> getEvents() {
        return this.Events;
    }
    public int daysOfMonth(int month){
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 9 || month == 11) {
            return 31;
        }else if (month == 4 || month == 6 || month == 8 || month == 10 || month == 12){
            return 30;
        } else if (month == 2){
            if (year%400==0 || (year%4==0 && year%100!=0)){
                return 29;
            }else {return 28;
            }
        }
        return 0;
    }
    public void addDays(int days){
        int differ = 0;while (days>0) {
            differ = daysOfMonth(month)-day;if (days > differ) {
                day = 0;
                month++;
            } else {
                day += days;
            }if (month>12){
                year++;month = 1;
            }days -= differ;
        }
    }
    public String toString(){
        return year+"-"+String.format("%02d",month)+"-"+String.format("%02d",day);
    }
    public static int difference(MyDate date1, MyDate date2) {
        int days = 0;
        MyDate bigger = date2;
        MyDate smaller = date1;
        int flag = 0;
        if (date1.year > date2.year) {
            bigger = date1;
            smaller = date2;
            flag = 1;
        } else if (date1.year == date2.year && date1.month > date2.month) {
            bigger = date1;
            smaller = date2;
            flag = 1;
        } else if (date1.year == date2.year && date1.month == date2.month && date1.day > date2.day) {
            bigger = date1;
            smaller = date2;
            flag = 1;
        }
        if (bigger.year == smaller.year) {
            if (bigger.month == smaller.month) {


                days += bigger.day - smaller.day;
            } else {
                for (int m = smaller.month; m < bigger.month; m++) {
                    if (m == smaller.month) {
                        days += smaller.daysOfMonth(m) - smaller.day;
                    } else {
                        days += smaller.daysOfMonth(m);
                    }
                }
                days += bigger.day;
            }
        } else {
            for (int y = smaller.year + 1; y < bigger.year; y++) {
                if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
                    days += 366;
                } else {
                    days += 365;


                }
            }
            int y = smaller.year;
            if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
                days += 366;
            } else {
                days += 365;
            }
            for (int i = 1; i < smaller.month; i++) {
                days -= smaller.daysOfMonth(i);
            }
            days -= smaller.day;
            for (int i = 1; i < bigger.month; i++) {
                days += bigger.daysOfMonth(i);
            }
            days += bigger.day;
        }
        if (flag == 0) {
            days = 0 - days;
        }
        return days;
    }}
