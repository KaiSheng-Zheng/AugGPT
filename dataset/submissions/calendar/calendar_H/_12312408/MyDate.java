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
    public void addDays(int days){
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = days; i > 0; i--){
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                daysInMonth[1] = 29;
            } else {
                daysInMonth[1] = 28;
            }
            if (month == 12 && day == 31) {
                year++;
                month = 1;
                day = 1;
            } else if (day == daysInMonth[month - 1]) {
                month++;
                day = 1;
            } else {
                day++;
            }
        }
    }
    public String toString(){
        switch (month / 10){
            case 0:
                switch (day / 10){
                    case 0:
                        return year +  "-0" + month + "-0" + day;
                    default:
                        return year +  "-0" + month + "-" + day;
                }
            case 1:
                switch (day / 10) {
                    case 0:
                        return year + "-" + month + "-0" + day;
                    default:
                        return year + "-" + month + "-" + day;
                }
            default:
                return year + "-" + month + "-" + day;
        }
    }
    public static int difference(MyDate date1, MyDate date2){
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days1 = 0;
        int days2 = 0;
        for (int i = 1; i < date1.year; i++){
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)){
                days1 += 366;
            }
            else days1 += 365;
        }
        for (int i = 1; i < date1.month; i++){
            days1 += daysInMonth[i - 1];
            if (i == 2 && ((date1.year % 4 == 0 && date1.year % 100 != 0) || (date1.year % 400 == 0))){
                days1 ++;
            }
        }
        days1 += date1.day;
        for (int i = 1; i < date2.year; i++){
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)){
                days2 += 366;
            }
            else days2 += 365;
        }
        for (int i = 1; i < date2.month; i++){
            days2 += daysInMonth[i - 1];
            if (i == 2 && ((date2.year % 4 == 0 && date2.year % 100 != 0) || (date2.year % 400 == 0))){
                days2 ++;
            }
        }
        days2 += date2.day;
        return days1 - days2;
    }
}
