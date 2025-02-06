public class MyDate {

    private int year;
    private int month;
    private int day;


    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            day++;
            if (day > getDaysByMonth(month)) {
                day = 1;
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
        }
    }


    public String toString() {
       String Month;
       String Day;
       if(month<10){
           Month="0"+month;

       }else{
           Month=""+month;
       }
     if(day<10){
           Day="0"+day;

       }else{
           Day=""+day;
       }
    return year+"-"+Month+"-"+Day;
    }


    public static int difference(MyDate date1, MyDate date2) {
        int days1 = date1.calculateTotalDays();
        int days2 = date2.calculateTotalDays();
        return days1 - days2;
    }


    public int calculateTotalDays() {
        int totalDays = 0;
        for (int i = 1; i < year; i++) {
            totalDays += WhetherLeapYear(i) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            totalDays += getDaysByMonth(m);
        }

        totalDays += day;

        return totalDays;
    }


    public boolean WhetherLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


    public int getDaysByMonth(int month) {
        if (month == 2) {
            return WhetherLeapYear(year) ? 29 : 28;
        } else if (month <= 7) {
            return (month % 2 == 1) ? 31 : 30;
        } else {
            return (month % 2 == 0) ? 31 : 30;
        }
    }
}