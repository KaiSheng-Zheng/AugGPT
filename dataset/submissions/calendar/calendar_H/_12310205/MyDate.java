public class MyDate {
    private int year;
    private int month;
    private int day;
    public int totals;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
        this.totals = total(year,month,day);
    }
    public void addDays(int days){
        for (int i = 0; i < days; i++) {
            int y=year,m=month,d=day;
            d += 1;
            boolean run = y % 4 == 0 && y % 100 != 0;
            if (y%400 == 0) run = true;
            int totaldays;
            switch (m) {
                case 1, 3, 5, 7, 8, 10, 12 -> totaldays = 31;
                case 4, 6, 9, 11 -> totaldays = 30;
                default -> {
                    if (run) totaldays = 29;
                    else totaldays = 28;
                }
            }
            if (d > totaldays){
                d -= totaldays;
                m++;
            }
            if (m > 12){
                y++;
                m -= 12;
            }
            year = y;month = m;day = d;
            totals = total(year,month,day);
        }
    }
    public String toString(){
        String a = String.valueOf(year);
        String b;
        String c;
        if (month >= 10){
            b = String.valueOf(month);
        }
        else {
            b = "0"+String.valueOf(month);
        }
        if (day >= 10){
            c = String.valueOf(day);
        }
        else {
            c = "0"+String.valueOf(day);
        }
        return a+"-"+b+"-"+c;
    }
    public static int difference(MyDate date1,MyDate date2){
        int a = date1.totals;
        int b = date2.totals;
        return a - b;
    }
    public int total(int year, int month, int day){
        int a = 0;
        for (int i = 1; i < year; i++) {
            boolean run= i % 4 == 0 && i % 100 != 0;
            if (i%400 == 0) run = true;
            if (run) a += 366;
            else a += 365;
        }
        boolean run= year % 4 == 0 && year % 100 != 0;
        if (year%400 == 0) run = true;
        for (int i = 1; i < month; i++) {
            int totaldays;
            switch (i) {
                case 1, 3, 5, 7, 8, 10, 12 -> totaldays = 31;
                case 4, 6, 9, 11 -> totaldays = 30;
                default -> {
                    if (run) totaldays = 29;
                    else totaldays = 28;
                }
            }
            a += totaldays;
        }
        a += day;
        return a;
    }
}
