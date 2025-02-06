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
        while (days>0){
            int dayOfMonth=getDayOfMonth(month,year);
            if(days>=dayOfMonth-day+1){
                days-=dayOfMonth-day+1;
                this.day=1;
                if(month==12){
                    month=1;
                    year++;
                }
                else{
                    month++;
                }

                }
            else{
                    day+=days;
                    days=0;
            }
        }
    }

    public String toString() {
        String yearToS = year + "";
        String monthToS = month + "";
        String dayToS = day + "";
        if(month<10){
            monthToS="0"+monthToS;
        }
        if(day<10){
            dayToS="0"+dayToS;
        }
        return yearToS + "-" + monthToS + "-" + dayToS;
    }

    public static int difference(MyDate date1, MyDate date2) {
        int day1 = date1.getDay();
        int month1 = date1.getMonth();
        int year1 = date1.getYear();
        int day2 = date2.getDay();
        int month2 = date2.getMonth();
        int year2 = date2.getYear();
        int diffDays=0;
        if(year1<year2){
            for (int i = year1+1; i < year2; i++) {
                diffDays+=isLeapYear(i) ? 366 : 365;
            }
            diffDays=diffDays+daysLeftYear(date1)+daysInYear(date2);
            diffDays=-diffDays;
        }
        if(year1>year2){
            for (int i = year2+1; i < year1; i++) {
                diffDays+=isLeapYear(i) ? 366 : 365;
            }
            diffDays=diffDays+daysInYear(date1)+daysLeftYear(date2);
        }
        if(year1==year2){
            diffDays=daysInYear(date1)-daysInYear((date2));
        }
        return diffDays;
    }

    public static int daysInYear(MyDate date) {
        int i=1;
        int days=0;
        int month= date.getMonth();
        while (i<month){
            days+=getDayOfMonth(i,date.getYear());
            i++;
        }
        return days+date.getDay();
    }
    public static int daysLeftYear(MyDate date){
         int days=0;
         int month=date.getMonth();
         int i=month;
         while(i<=12){
            days+=getDayOfMonth(i,date.getYear());
            i++;
        }
       return days-date.getDay();
        
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
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
    public static int getDayOfMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }
}
