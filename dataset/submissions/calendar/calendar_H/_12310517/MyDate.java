public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate (int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean JudgingLeapYears () {
        if (year % 100 == 0) return year % 400 == 0;
        else return year % 4 == 0;
    }

    public boolean JudgingLeapYears_Next () {
        if ((year + 1) % 100 == 0) return (year + 1) % 400 == 0;
        else return (year + 1) % 4 == 0;
    }

    public void addDays (int days) {
        while (days >= (month <= 2 ? (JudgingLeapYears() ? 366 : 365) : (JudgingLeapYears_Next() ? 366 : 365))) {
            days -= (month <= 2 ? (JudgingLeapYears() ? 366 : 365) : (JudgingLeapYears_Next() ? 366 : 365));
            year++;
        }
        while (days > 0) {
            int ThisMonth = 0;
            switch (month) {
                case 1 :{}
                case 3 :{}
                case 5 :{}
                case 7 :{}
                case 8 :{}
                case 10 :{}
                case 12 :{
                    ThisMonth = 31;
                    break;
                }
                case 4 :{}
                case 6 :{}
                case 9 :{}
                case 11 :{
                    ThisMonth = 30;
                    break;
                }
                case 2 :{
                    ThisMonth = JudgingLeapYears() ? 29 : 28;
                    break;
                }
            }

            if (day == ThisMonth) {
                if (month == 12) {
                    day = 1;
                    month = 1;
                    year++;
                } else {
                    day = 1;
                    month++;
                }
            } else {
                day++;
            }

            days--;
        }
    }

    public String toString () {
        return String.format("%04d-%02d-%02d" ,year ,month ,day);
    }

    public static int difference (MyDate date1, MyDate date2) {
        MyDate date3 = new MyDate(date1.year, date1.month, date1.day);
        MyDate date4 = new MyDate(date2.year, date2.month, date2.day);
        int ans = 0;
        while (date3.year < date4.year) {
            ans -= (date3.month <= 2 ? (date3.JudgingLeapYears() ? 366 : 365) : (date3.JudgingLeapYears_Next() ? 366 : 365));
            date3.year++;
        }
        while (date3.year > date4.year) {
            ans += (date4.month <= 2 ? (date4.JudgingLeapYears() ? 366 : 365) : (date4.JudgingLeapYears_Next() ? 366 : 365));
            date4.year++;
        }
        while (date3.month < date4.month) {
            switch (date3.month) {
                case 1 :{}
                case 3 :{}
                case 5 :{}
                case 7 :{}
                case 8 :{}
                case 10 :{}
                case 12 :{
                    ans -= 31;
                    date3.month++;
                    break;
                }
                case 4 :{}
                case 6 :{}
                case 9 :{}
                case 11 :{
                    ans -= 30;
                    date3.month++;
                    break;
                }
                case 2 :{
                    ans -= date3.JudgingLeapYears() ? 29 : 28;
                    date3.month++;
                    break;
                }
            }
        }
        while (date3.month > date4.month) {
            switch (date4.month) {
                case 1 :{}
                case 3 :{}
                case 5 :{}
                case 7 :{}
                case 8 :{}
                case 10 :{}
                case 12 :{
                    ans += 31;
                    date4.month++;
                    break;
                }
                case 4 :{}
                case 6 :{}
                case 9 :{}
                case 11 :{
                    ans += 30;
                    date4.month++;
                    break;
                }
                case 2 :{
                    ans += date4.JudgingLeapYears() ? 29 : 28;
                    date4.month++;
                    break;
                }
            }
        }
        ans += date3.day - date4.day;
        return ans;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
