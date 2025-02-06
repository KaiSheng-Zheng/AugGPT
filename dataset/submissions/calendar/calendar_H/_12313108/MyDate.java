public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isLeapYear() {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public int getDay() {
        return day;
    }

    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            day++;
            if (day > 30 + month%2 && month <= 7 && month != 2 ||
                    day > 30 + (month - 1) % 2 && month >= 8 ||
                    day > (this.isLeapYear() ? 29 : 28) && month == 2) {
                month++;
                day = 1;
            }
            if (month > 12) {
                year++;
                month = 1;
            }
        }
    }

    public String toString() {
        return String.format("%04d-%02d-%02d",year,month,day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int day1 = date1.getDay();
        day1 += date1.MonthToDay();
        day1 += date1.YearToDay();
        int day2 = date2.getDay();
        day2 += date2.MonthToDay();
        day2 += date2.YearToDay();
        return day1 - day2;
    }
    
    public int MonthToDay() {
        int day = 0;
        switch (month) {
            case 12 : day += 30;
            case 11 : day += 31;
            case 10 : day += 30;
            case 9 : day += 31;
            case 8 : day += 31;
            case 7 : day += 30;
            case 6 : day += 31;
            case 5 : day += 30;
            case 4 : day += 31;
            case 3 : day += this.isLeapYear() ? 29 : 28;
            case 2 : day += 31;
            default: break;
        }
        return day;
    }
    
    public int YearToDay() {
        int day = 0;
        if (year > 1970) {
            int year = this.year;
            do {
                year--;
                day += (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 366 : 365;
            } while (year != 1970);
        } else if (year < 1970) {
            int year = this.year;
            do {
                day -= (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 366 : 365;
                year++;
            } while (year != 1970);
        }
        return day;
    }
}
