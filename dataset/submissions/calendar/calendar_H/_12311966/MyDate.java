public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
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

         public void addDays(int days) {
        while (true) {
            if (days == 0) {
                break;
            }
            switch (month) {
                case 1, 3, 5, 7, 8, 10: {
                    days = addToNextMonth(31,days);
                }
                break;
                case 4, 6, 9, 11: {
                    days = addToNextMonth(30,days);
                }
                break;
                case 12: {
                    if (this.day + days > 31) {
                        this.month = 1;
                        this.year++;
                        days = days - (31 - this.day) - 1;
                        this.day = 1;
                    } else {
                        this.day += days;
                        days = 0;
                    }
                }
                break;
                case 2: {
                    if ((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0) {
                        //leap year 29 days
                        days = addToNextMonth(29,days);
                    } else {
                        days = addToNextMonth(28,days);
                    }
                }
                break;
            }
        }
    }

    public int addToNextMonth(int monthDays,int days){
        if (this.day + days > monthDays) {
            this.month++;
            days = days - (monthDays - this.day) - 1;
            this.day = 1;
        } else {
            this.day += days;
            days = 0;
        }
        return days;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        if (date1.year == date2.year) {
            if (date1.month > date2.month) {
                return sameYearDifference(date1, date2);
            } else if (date1.month < date2.month) {
                return sameYearDifference(date2, date1) * (-1);
            } else {
                return date1.day - date2.day;
            }
        } else {
            if (date1.year > date2.year) {
                MyDate endDate = new MyDate(date2.getYear(),12,31);
                MyDate startDate = new MyDate(date1.getYear(),1,1);
                int difference = sameYearDifference(date1,startDate) + sameYearDifference(endDate,date2) + 1;
                int currentYear = date1.getYear() - 1;
                for (int i = 0; i < date1.year - date2.year - 1; i++) {
                    if ((currentYear % 4 == 0 && currentYear % 100 != 0) || currentYear % 400 == 0){
                        difference += 366;
                        currentYear--;
                    }
                    else {difference += 365;currentYear--;}
                }
                return difference;
            } else {
                MyDate endDate = new MyDate(date1.getYear(),12,31);
                MyDate startDate = new MyDate(date2.getYear(),1,1);
                int difference = sameYearDifference(date2,startDate) + sameYearDifference(endDate,date1) + 1;
                int currentYear = date2.getYear() - 1;
                for (int i = 0; i < date2.year - date1.year - 1; i++) {
                    if ((currentYear % 4 == 0 && currentYear % 100 != 0) || currentYear % 400 == 0){
                        difference += 366;
                        currentYear--;
                    }
                    else {difference += 365;currentYear--;}
                }
                return difference * (-1);
            }
        }
    }

    public static int sameYearDifference(MyDate date1, MyDate date2){//date1.month > date2.month
        int difference = 0;
        int[] leapYear = {31,29,31,30,31,30,31,31,30,31,30,31};
        int[] normalYear = {31,28,31,30,31,30,31,31,30,31,30,31};
        if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0){
            for (int i = date2.month - 1; i < date2.month - 1 + date1.month - date2.month; i++) {
                difference += leapYear[i];
            }
            difference = difference + date1.day - date2.day;
            return difference;
        }
        else {
            for (int i = date2.month - 1; i < date2.month - 1 + date1.month - date2.month; i++) {
                difference += normalYear[i];
            }
            difference = difference + date1.day - date2.day;
            return difference;
        }
    }
}