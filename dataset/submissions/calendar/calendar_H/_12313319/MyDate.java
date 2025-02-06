import java.util.ArrayList;


public class MyDate {
    private int year;
    private int month;
    private int day;
    static ArrayList<MyDate> dates = new ArrayList<>();
    private final ArrayList<String> event = new ArrayList<>();

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        dates.add(this);
    }

   public void addDays(int days) {
        setDay(getDay() + days);
        radix1();
    }

    public String toString() {
        return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        if (date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth() && date1.getDay() == date2.getDay())         // 1.sameday
            return 0;
        else if (date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth())                                        //2.samemonth
            return date1.getDay() - date2.getDay();
        else if (date1.getYear() == date2.getYear()) {                                                                               //3.sameyear
            if (date1.compare(date1, date2)) {                                                                                         //A. date1>date2
                return date1.addition1(date1, date2);
            } else {                                                                                                                   //B. date1<date2
                return -date2.addition1(date2, date1);
            }
        } else if (date1.getYear() + 1 == date2.getYear() || date2.getYear() + 1 == date1.getYear()) {                                           //4.nextto
            if (date1.compare(date1, date2)) {                                                                                            //A. date1>date2
                MyDate start = new MyDate(date2.getYear(), 12, 31);
                MyDate over = new MyDate(date1.getYear(), 1, 1);
                return date2.addition1(start, date2) + date1.addition1(date1, over)+1;
            } else {                                                                                                                    //B. date1<date2
                MyDate start = new MyDate(date1.getYear(), 12, 31);
                MyDate over = new MyDate(date2.getYear(), 1, 1);
                return -(date1.addition1(start, date1) + date2.addition1(date2, over)+1);
            }
        } else {                                                                                                                       //5.haveGapYear
            if (date1.compare(date1, date2)) {
                MyDate start = new MyDate(date2.getYear(), 12, 31);                                                               //A. date1>date2
                MyDate over = new MyDate(date1.getYear(), 1, 1);
                int part = 0;
                for (int i = date2.getYear() + 1; i <= date1.getYear() - 1; i++) {
                    if (isleapyear(i)) {
                        part += 366;
                    } else {
                        part += 365;
                    }
                }
                return date2.addition1(start, date2) + date1.addition1(date1, over) + part+1;
            } else {
                MyDate start = new MyDate(date1.getYear(), 12, 31);                                                               //B. date1<date2
                MyDate over = new MyDate(date2.getYear(), 1, 1);
                int part = 0;
                for (int i = date1.getYear() + 1; i <= date2.getYear() - 1; i++) {
                    if (isleapyear(i)) {
                        part += 366;
                    } else {
                        part += 365;
                    }
                }
                return -(date1.addition1(start, date1) + date2.addition1(date2, over) + part+1);
            }
        }
    }

    public ArrayList<String> getEvent() {
        return event;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static boolean isbmonth(int month) {
        return month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12;
    }

    public static boolean isleapyear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public void radix1() {                          //day to month
        while (true) {
            if (isbmonth(getMonth()) && getDay() > 31) {                //bm31
                setMonth(getMonth() + 1);
                setDay(getDay() - 31);
            } else if (getMonth() != 2 && !isbmonth(getMonth()) && getDay() > 30) {                         //sm30
                setMonth(getMonth() + 1);
                setDay(getDay() - 30);
            } else if (getMonth() == 2 && isleapyear(getYear()) && getDay() > 29) {                    //Feb 29
                setMonth(getMonth() + 1);
                setDay(getDay() - 29);
            } else if (getMonth() == 2 && !isleapyear(getYear()) && getDay() > 28) {                   //Feb 28
                setMonth(getMonth() + 1);
                setDay(getDay() - 28);
            } else break;
            radix2();
        }
    }

    public void radix2() {                          //m to year
        while (true) {
            if (getMonth() > 12) {
                setYear(getYear() + 1);
                setMonth(getMonth() - 12);
            } else break;
        }
    }

    public static boolean compare(MyDate date1, MyDate date2) {       //if date1 > date2
        if (date1.getYear() > date2.getYear()) {
            return true;
        } else if (date1.getYear() < date2.getYear()) {
            return false;
        } else {
            if (date1.getMonth() > date2.getMonth()) {
                return true;
            } else if (date1.getMonth() < date2.getMonth()) {
                return false;
            } else {
                if (date1.getDay() > date2.getDay()) {
                    return true;
                } else if (date1.getDay() < date2.getDay()) {
                    return false;
                } else return false;
            }
        }
    }

    public static int daysof(int year, int month) {
        if (isbmonth(month)) return 31;
        else if (!isbmonth(month) && month != 2) return 30;
        else {
            if (isleapyear(year)) return 29;
            else return 28;
        }
    }

    public int addition1(MyDate date1, MyDate date2) {          //same year addition     date1 > date2

        if (date1.getMonth() != date2.getMonth()) {
            int delta = 0;
            delta += date1.getDay();                                                //add end days

            if (isbmonth(date2.getMonth())) {                                       //add start days            //bm31
                delta += 31 - date2.getDay();
            } else if (date2.getMonth() != 2 && !isbmonth(date2.getMonth())) {                            //sm30
                delta += 30 - date2.getDay();
            } else if (date2.getMonth() == 2 && isleapyear(date2.getYear())) {                         //Feb29
                delta += 29 - date2.getDay();
            } else if (date2.getMonth() == 2 && !isleapyear(date2.getYear())) {                        //Feb28
                delta += 28 - date2.getDay();
            }

            for (int i = date2.getMonth() + 1; i <= date1.getMonth() - 1; i++) {
                delta += daysof(date1.getYear(), i);
            }
            return delta;
        } else {
            return date1.getDay() - date2.getDay();
        }
    }
}

