public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = ((year >= 0) ? year : 0);
        this.month = ((month >= 1 && month <= 12) ? month : 1);
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            this.day = ((day >= 1 && day <= 31) ? day : 1);
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            this.day = ((day >= 1 && day <= 30) ? day : 1);
        } else {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                this.day = ((day >= 1 && day <= 29) ? day : 1);
            } else {
                this.day = ((day >= 1 && day <= 28) ? day : 1);
            }
        }
    }

    public int monthdays(int month, int year) {
        int[] monthdays = {31, 28, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month < 2) {
            return 31;
        } else if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                return monthdays[2];
            } else {
                return monthdays[1];
            }
        } else {
            return monthdays[month];
        }
    }

    public void addDays(int days) {
        int testDay = this.day + days;
        int n = 0;
        while (testDay > 0) {
            testDay -= monthdays(this.month, this.year);
            if (testDay <= 0) {
                this.day = (testDay + monthdays(this.month, this.year));
                break;
            } else {
                this.month++;
                this.day = 0;
                if (this.month == 13) {
                    this.year++;
                    this.month = 1;
                }
            }
        }
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date3, MyDate date4) {
        MyDate date1 = new MyDate(date3.year, date3.month,date3.day);
        MyDate date2 = new MyDate(date4.year, date4.month,date4.day);
        int dif = 0;
        while ((date1.year * 10000 + date1.month * 100 + date1.day) != (date2.year * 10000 + date2.month * 100 + date2.day)){
            if ((date1.year * 10000 + date1.month * 100 + date1.day) - (date2.year * 10000 + date2.month * 100 + date2.day)<0){
                date1.addDays(1);
                dif--;
            }else {
                date2.addDays(1);
                dif++;
            }
        }
        return dif;
    }
}
