public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public double compare(){
        return year + month*0.01 + day*0.0001;
    }

   public void addDays(int days) {

        int x = getDayOfBigYear(year, month + 1) - getDayOfBigYear(year, month);
          int leftDays = days + day;
        while (leftDays > x) {
            leftDays -= x;
            if (month == 12) {
                year += 1;
                month = 1;
            } else {
                month += 1;
            }
            x = getDayOfBigYear(year, month + 1) - getDayOfBigYear(year, month);
        }
        day = leftDays;
    }
    public String toString() {
if (month < 10 && day < 10){
        return this.year + "-0" + this.month + "-0" + this.day;
} else if (month<10) {
    return this.year + "-0" + this.month + "-" + this.day;
} else if (day < 10) {
    return this.year + "-" + this.month + "-0" + this.day;
}     return this.year + "-" + this.month + "-" + this.day;
    }

    public static int getDayOfSmallYear(int year, int month) {

        int totalDays;
        if (!runnian(year)) {
            totalDays = 365 - getDayOfBigYear(year, month);
        } else {
            totalDays = 366 - getDayOfBigYear(year, month);
        }
        return totalDays;
    }

    public static int getDayOfBigYear(int year, int month) {
        int totalDays = 0;
        if (!runnian(year))
            switch (month) {
                case 1:
                    break;
                case 2:
                    totalDays = 31;
                    break;
                case 3:
                    totalDays = 31 + 28;
                    break;
                case 4:
                    totalDays = 31 + 28 + 31;
                    break;
                case 5:
                    totalDays = 31 + 28 + 31 + 30;
                    break;
                case 6:
                    totalDays = 31 + 28 + 31 + 30 + 31;
                    break;
                case 7:
                    totalDays = 31 + 28 + 31 + 30 + 31 + 30;
                    break;
                case 8:
                    totalDays = 31 + 28 + 31 + 30 + 31 + 30 + 31;
                    break;
                case 9:
                    totalDays = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
                    break;
                case 10:
                    totalDays = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                    break;
                case 11:
                    totalDays = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                    break;
                case 12:
                    totalDays = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                    break;
                     case 13:
                    totalDays = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31;
                    break;
            }
        else {
            switch (month) {
                case 1:
                    break;
                case 2:
                    totalDays = 31;
                    break;
                case 3:
                    totalDays = 31 + 29;
                    break;
                case 4:
                    totalDays = 31 + 29 + 31;
                    break;
                case 5:
                    totalDays = 31 + 29 + 31 + 30;
                    break;
                case 6:
                    totalDays = 31 + 29 + 31 + 30 + 31;
                    break;
                case 7:
                    totalDays = 31 + 29 + 31 + 30 + 31 + 30;
                    break;
                case 8:
                    totalDays = 31 + 29 + 31 + 30 + 31 + 30 + 31;
                    break;
                case 9:
                    totalDays = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31;
                    break;
                case 10:
                    totalDays = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                    break;
                case 11:
                    totalDays = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                    break;
                case 12:
                    totalDays = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                    break;
                     case 13:
                    totalDays = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31;
                    break;
            }
        }
        return totalDays;
    }

    public static boolean runnian(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static int difference(MyDate date1, MyDate date2) {
        int days = 0;
        if (date2.year > date1.year) {
            for (int i = date1.year + 1; i < date2.year; i++) {
                if (runnian(i)) {
                    days = days + 366;
                } else {
                    days += 365;
                }
                
            }days = -(days + getDayOfBigYear(date2.year, date2.month) + date2.day
                        + getDayOfSmallYear(date1.year, date1.month) - date1.day);
        } else if (date2.year == date1.year) {
            days = -(days + getDayOfBigYear(date2.year, date2.month)
                    - getDayOfBigYear(date1.year, date1.month) + date2.day
                    - date1.day);
        } else {
            for (int i = date2.year + 1; i < date1.year; i++) {
                if (runnian(i)) {
                    days = days + 366;
                } else {
                    days += 365;
                }
                
            }days = days + getDayOfBigYear(date1.year, date1.month) + date1.day
                        + getDayOfSmallYear(date2.year, date2.month) - date2.day;
        }
        return days;
    }
}
