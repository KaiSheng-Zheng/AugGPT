import java.util.Calendar;
public class MyDate {
    private  int year;
    private int month;
    private int day;
    public  MyDate(int year, int month, int day) {
        this.year = year;
        this.month=month;
        this.day=day;
    }
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    public int getDays() {
        int days = 0;
        
        for (int i = 0; i < year; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }
        
        for (int i = 1; i < month; i++) {
            days += getDaysFromMonth(i);
        }
        days += day;
        return days;
    }

    private int getDaysFromMonth(int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 30;
        }
    }

    public void addDays(int extra) {
        Calendar calendar=Calendar.getInstance();
        int days = 0;
        calendar.set(year,month-1,day);
        calendar.add(Calendar.DATE,extra);
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH)+1;
        day=calendar.get(Calendar.DAY_OF_MONTH);
    }

    public String toString() {
        String str;
        str = String.format("%04d",year) + "-" + String.format("%02d",month) + "-" + String.format("%02d",day);
        return str;
    }

    public static int difference(MyDate date1, MyDate date2) {
        int dif;
        dif = date1.getDays() - date2.getDays();
        return dif;
    }

}