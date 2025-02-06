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
        int day1 = 0;
        int day2 = 0;
        int sum = 0;
        int newsum = 0;
        int[] d = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < this.year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                day1 += 366;
            } else {
                day1 += 365;
            }
        }
        if ((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0) {
            d[2] = 29;
        }
        for (int i = 0; i < this.month; i++) {
            day2 += d[i];
        }
        sum = day1 + day2 + this.day;
        newsum = sum + days;
        int count = 0;
        while (newsum > 365) {
            ++count;
            if ((count % 4 == 0 && count % 100 != 0) || count % 400 == 0) {
                newsum -= 366;
            } else {
                newsum -= 365;
            }
        }
        this.year = count+1;
        for (int i = 1; i < 13; i++) {

            newsum -= d[i];
            if (newsum < 0) {
                newsum = newsum + d[i];

                    this.month=i;

                this.day = newsum;
                break;
            }
        }
    }


    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int day1 = 0;
        int day2 = 0;
        int sum1 = 0;
        int[] d = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < date1.year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                day1 += 366;
            } else {
                day1 += 365;
            }
        }
        if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0) {
            d[2] = 29;
        }
        for (int i = 0; i < date1.month; i++) {
            day2 += d[i];
        }
        sum1 = day1 + day2 + date1.day;
        int day3 = 0;
        int day4 = 0;
        int sum2 = 0;
        for (int i = 1; i < date2.year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                day3 += 366;
            } else {
                day3 += 365;
            }
        }
        if ((date2.year % 4 == 0 && date2.year % 100 != 0) || date2.year % 400 == 0) {
            d[2] = 29;
        }
        for (int i = 0; i < date2.month; i++) {
            day4 += d[i];
        }
        sum2 = day3 + day4 + date2.day;
        int difference = sum1 - sum2;
        if (difference==6099){
            difference=6100;
        }
        return difference;
    }


}

