public class MyDate {
    private int year;
    private  int month;
    private int day;


    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public void addDays(int days){
        int i = 1;
        boolean isLeapYear = JudgeLeapYear(year);
        while (i <= days){
            if (month == 2){
                if (isLeapYear){
                    day++;
                    i++;
                    if (day > 29){
                        day = 1;
                        month++;
                    }
                }
                else {
                    day++;
                    i++;
                    if (day > 28){
                        day = 1;
                        month++;
                    }
                }
            }
            else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                day++;
                i++;
                if (day > 31){
                    day = 1;
                    month++;
                }
            }
            else {
                day++;
                i++;
                if (day > 30){
                    day = 1;
                    month++;
                }
            }

            if (month == 13){
                month = 1;
                year++;
                isLeapYear = JudgeLeapYear(year);
            }
        }
    }

    public String toString() {
        String monthString = Integer.toString(month);
        String dayString = Integer.toString(day);
        if (month < 10)
            monthString = String.format("0%d",month);
        if (day < 10)
            dayString = String.format("0%d",day);
        return String.format("%d-%s-%s", year,monthString,dayString);
    }

    public static int difference(MyDate date1, MyDate date2){
        if (date1.year == date2.year && date1.month == date2.month && date1.day ==  date2.day)
            return  0;
        else {
            int result = 0;
            MyDate date3;
            MyDate date4;
            boolean isEarly = JudgeIsEarly(date1, date2);
            if (isEarly) {
                date3 = date1;
                date4 = date2;
            } else {
                date3 = date2;
                date4 = date1;
            }

            if (date3.year == date4.year) {
                boolean isLeapYear = JudgeLeapYear(date3.year);
                result = countInYear(date3.month, date3.day, date4.month, date4.day, isLeapYear);
            } else {
                int counter = 0;
                int i = date3.year + 1;
                while (i < date4.year) {
                    if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
                        counter = counter + 366;
                    else
                        counter = counter + 365;
                    i++;
                }

                boolean isLeapYear = JudgeLeapYear(date3.year);
                int C1 = countInYear(date3.month, date3.day, 12, 31, isLeapYear);
                isLeapYear = JudgeLeapYear(date4.year);
                int C2 = countInYear(1, 1, date4.month, date4.day, isLeapYear);
                result = counter + C1 + C2;
            }
            result++;
            if (isEarly)
                result = -result;
            return result;
        }
    }

    public static boolean JudgeLeapYear(int year){
        boolean isLeapYear;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            isLeapYear = true;
        else
            isLeapYear = false;
        return  isLeapYear;
    }

    public static boolean JudgeIsEarly(MyDate date1 , MyDate date2){
        boolean isEarly = false;
        if (date1.year < date2.year)
            isEarly = true;
        else if (date1.year == date2.year && date1.month < date2.month)
            isEarly = true;
        else if (date1.month == date2.month && date1.day <date2.day)
            isEarly = true;
        return isEarly;
    }

    public static int countInYear(int month1 , int day1 , int month2 , int day2 , boolean isLeapYear) {
        if (month1 == month2){
            int counter = 0;
            while (day1 < day2){
                day1++;
                counter++;
            }
            return counter;
        }
        else {
            int counter = 0;
            int i = month1 + 1;
            while (i < month2){
                if (i == 2) {
                    if (isLeapYear)
                        counter = counter + 29;
                    else
                        counter = counter + 28;
                }
                else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
                    counter = counter + 31;
                }
                else
                    counter= counter + 30;
                i++;
            }
            if (month1 == 2){
                if (isLeapYear)
                    counter = 29 - day1 + counter;
                else
                    counter = 28 - day1 + counter;
            }
            else if (month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12)
                counter = 31 - day1 + counter;
            else
                counter = 30 - day1 + counter;

            counter = counter + day2;

            return counter;
        }
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
