import java.time.LocalDate;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private String eventName;

    // CONSTRUCTOR
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.eventName = "";
    }

    // SETTER
    public void setYear(int year) {
        this.year = year;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setEvent(String eventName) {
        this.eventName = eventName;
    }

    // GETTER
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public String getEvent() {
        return eventName;
    }

    // METHODS
    public static int getMonthDay(int month, int year) {

        int monthDay = 0;

        // 31 days
        if (month == 1 || month == 3) {
            monthDay = 31;
        }
        if (month == 5 || month == 7) {
            monthDay = 31;
        }
        if (month == 8 || month == 10) {
            monthDay = 31;
        }
        if (month == 12) {
            monthDay = 31;
        }
            
        // 30 days
        if (month == 4 || month == 6) {
            monthDay = 30;
        }
        if (month == 9 || month == 11) {
            monthDay = 30;
        }

        // 28 days
        if (month == 2) {
            if (year % 4 == 0 && year % 100 != 0) {
                monthDay = 29;
            }
            else if (year % 400 == 0) {
                monthDay = 29;
            }
            else {
                monthDay = 28;
            }
        }

        return monthDay;

    }

    public static int getYearDay(int year) {

        int yearDay = 0;

        if (year % 4 == 0 && year % 100 != 0) {
            yearDay = 366;
        }
        else if (year % 400 == 0) {
            yearDay = 366;
        }
        else {
            yearDay = 365;
        }

        return yearDay;

    }

    public void addDays(int days) {

        for (int i = days; i > 0; i--) {
            this.day++;
            if (this.day > getMonthDay(this.month, this.year)) {
                this.month++;
                this.day = 1;
            }
            if (this.month > 12) {
                this.year++;
                this.month = 1;
            }
        }
        
    }

    public String toString() {

        String formatDay = "";
        String formatMonth = "";
        String formatYear = Integer.toString(this.year);

        if (this.month < 10) {
            formatMonth = "0" + Integer.toString(this.month);
        }
        else {
            formatMonth = Integer.toString(this.month);
        }

        if (this.day < 10) {
            formatDay = "0" + Integer.toString(this.day);
        }
        else {
            formatDay = Integer.toString(this.day);
        }

        return (formatYear + "-" + formatMonth + "-" + formatDay + this.eventName);
        
    }

    // public static int difference(MyDate date1, MyDate date2) {

    //     int diffYear = 0;
    //     int diffMonth = 0;
    //     int diffDay = 0;
    
    //     // Year diff.
    //     diffYear = (date2.year - date1.year) * getYearDay(date1.year);
    
    //     // Month diff.
    //     int months1 = date1.year * 12 + date1.month;
    //     int months2 = date2.year * 12 + date2.month;
    //     diffMonth = months2 - months1;
        
    //     diffMonth -= date1.day / (double) getMonthDay(date1.month, date1.year);
    //     diffMonth += date2.day / (double) getMonthDay(date2.month, date2.year);
    
    //     // Day diff.
    //     int days1 = date1.year * 365 + date1.month * getMonthDay(date1.month, date1.year) + date1.day;
    //     int days2 = date2.year * 365 + date2.month * getMonthDay(date2.month, date2.year) + date2.day;
    //     diffDay = days2 - days1;
    
    //     // return
    //     int difference = diffDay + diffMonth + diffYear;
    //     return difference;
    // }
    

    public static int difference(MyDate date1, MyDate date2) {

        LocalDate dateA = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDay());
        LocalDate dateB = LocalDate.of(date2.getYear(), date2.getMonth(), date2.getDay());
        long diff = dateA.toEpochDay() - dateB.toEpochDay();

        return (int)diff;
        // int lesserDay = Math.min(date1.day, date2.day);
        // int greaterDay = Math.max(date1.day, date2.day);

        // int lesserMonth = Math.min(date1.month, date2.month);
        // int greaterMonth = Math.max(date1.month, date2.month);

        // int lesserYear = Math.min(date1.year, date2.year);
        // int greaterYear = Math.max(date1.year, date2.year);

        // // YEAR
        // int diffYear = 0;
        // for (int i = lesserYear; i < greaterYear; i++) {
        //     diffYear += getYearDay(i);
        // }
        // if (date1.year > date2.year) {
        //     diffYear *= -1;
        // }

        // // MONTH
        // int diffMonth = 0;
        // for (int i = lesserMonth + 1; i <= greaterMonth; i++) {
        //     diffMonth += getMonthDay(i, greaterYear);
        // }
        // if (date1.month > date2.month) {
        //     diffMonth *= -1;
        // }

        // // DAY
        // int diffDay = greaterDay - lesserDay;
        // if (date1.day + 1 > date2.day) {
        //     diffDay *= -1;
        // }
        
        // // return
        // int difference = (diffDay + diffMonth + diffYear) * -1;
        // return difference;

    }
}
