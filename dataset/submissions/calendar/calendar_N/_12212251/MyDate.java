public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year,int month,int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     *
     * @param year
     * @return Is this year a leap year?
     */
    private static boolean  isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    /**
     *
     * @param month
     * @param year
     * @return the days of month
     */
    private static int getDaysOfMonth(int month,int year) {
        if(month == 2) return isLeapYear(year)? 29:28;
        if((month % 2 == 0&&month < 8) || (month % 2 == 1&&month > 7)) return 30;
        return 31;
    }
    public void addDays(int days) {
        MyDate boundary = new MyDate(this.year,1,1);
        days += boundaryDif(boundary,this) - 1;
        this.month = 1;
        this.day = 1;
        while(days >= (isLeapYear(this.year)? 366:365)) {
            days -= (isLeapYear(this.year)? 366:365);
            this.year++;
        }
        while(days >= getDaysOfMonth(this.month,this.year)) {
            days -= getDaysOfMonth(this.month,this.year);
            this.month++;
        }
        this.day += days;
    }
    @Override
    public String toString() {
        return String.format(year + "-" + (month < 10?"0":"") + month + "-" + (day < 10?"0":"") + day);
    }

    /**
     *
     * @param boundary
     * @param date
     * @return the days between xxxx-1-0 and date
     */
    public static int boundaryDif(MyDate boundary,MyDate date) {
        int dif = (date.year - boundary.year) * 365 + date.day,boudaryYear = (boundary.year + 3) / 4 * 4,leap = 0;
        for(int i = 1;i < date.month;i++) dif += getDaysOfMonth(i,date.year);
        date.year--;
        if(date.year >= boudaryYear) leap = (date.year - boudaryYear) / 4 + 1;
        boudaryYear = (boundary.year + 99) / 100 * 100;
        if(date.year >= boudaryYear) leap -= ((date.year - boudaryYear) / 100 + 1);
        boudaryYear = (boundary.year + 399) / 400 * 400;
        if(date.year >= boudaryYear) leap += (date.year - boudaryYear) / 400 + 1;
        date.year++;
        dif += leap;
        return dif;
    }
    public static int difference(MyDate date1,MyDate date2) {
        boolean ischanged = false;
        if(date1.year > date2.year||
                date1.year == date2.year&&
                        (date1.month > date2.month ||
                                date1.month == date2.month&&date1.day > date2.day)) {
            ischanged = true;
            MyDate tmp = date1;
            date1 = date2;
            date2 = tmp;
        }
        MyDate boundary = new MyDate(date1.year,1,1);
        return (boundaryDif(boundary,date2) - boundaryDif(boundary,date1)) * (ischanged?1:-1);
    }
}
