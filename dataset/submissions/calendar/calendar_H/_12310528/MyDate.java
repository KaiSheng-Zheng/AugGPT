public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDay(int day) {this.day = day;}
    public int getDay() {return day;}

    public void setMonth(int month) {this.month = month;}
    public int getMonth() {return month;}

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {return year;}

    public void addDays(int days){
        int days1 = days + day;
        if (days1 > judgeTheMonth(getMonth() , getYear())){
            while (days1 > judgeTheMonth(getMonth() , getYear())) {
                days1 -= judgeTheMonth(getMonth() , getYear());
                month++;
            }
        }
        if (month > 12){
            while (month > 12){
                month -= 12;
                year++;
            }
        }
        day = days1;
    }

   
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2){
        
        int endDays = date1.year * 365 + countLeapYears(date1.year, date1.month) + getDayOfYear(date1.month, date1.day);
        int startDays = date2.year * 365 + countLeapYears(date2.year, date2.month) + getDayOfYear(date2.month, date2.day);

        
        return endDays - startDays;
    }

    
    public static int countLeapYears(int year, int month) {
        if (month <= 2) {
            year--;
        }
        return year / 4 - year / 100 + year / 400;
    }

    
    public static int getDayOfYear(int month, int day) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayOfYear = 0;
        for (int i = 1; i < month; i++) {
            dayOfYear += daysInMonth[i];
        }
        return dayOfYear + day;
    }

    private static int judgeTheMonth(int month , int year){
        int result = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
                || month == 11 || month == 12){result = 31;}
        else if (month == 4 || month == 6 || month == 9 || month == 11){result = 30;}
        else if (month == 2 || year%4 == 0 || year%100 !=0 || year%400 ==0){ result =29;}
        else if (month ==2 || year%4 != 0 || year%100 ==0){ result =28;}
        return result;
    }
}