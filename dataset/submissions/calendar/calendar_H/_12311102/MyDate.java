public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

    }
    public void addDays(int days) {
        day += days;
        for (int counter = 0;counter <= day/28+day/365;counter++) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day >= 32) {
                    month += 1;
                    day -= 31;
                }
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day >= 31) {
                    month += 1;
                    day -= 30;
                }
            }
            else if (month == 2) {
                if (((year&4) == 0 && (year&100) != 0) || (year&400) == 0) {
                    if (day >= 30) {
                        month += 1;
                        day -= 29;
                    }
                }
                else {
                    if (day >= 29) {
                        month += 1;
                        day -= 28;
                    }
                }
            }
            else {
                year += 1;
                month -= 12;
            }
        }
    }
    public String toString() {
            return String.format("%04d-%02d-%02d", year, month, day);
    }
    public static int difference(MyDate date1, MyDate date2) {
        int difference = 0;
        if (date1.year > date2.year) {
            for (int counter = date2.year;counter < date1.year;counter++) {
                if (((counter&4) == 0 && (counter&100) != 0) || (counter&400) == 0) {
                    difference += 366;
                }
                else {
                    difference += 365;
                }
            }
        }
        else if (date1.year < date2.year) {
            for (int counter = date1.year;counter < date2.year;counter++) {
                if (((counter&4) == 0 && (counter&100) != 0) || (counter&400) == 0) {
                    difference -= 366;
                }
                else {
                    difference -= 365;
                }
            }
        }
        if (date1.month > date2.month) {
            for (int counter = date2.month;counter < date1.month;counter++) {
                if (counter == 1 || counter == 3 || counter == 5 || counter == 7 || counter == 8 || counter == 10 || counter == 12) {
                    difference += 31;
                }
                else if (counter == 4 || counter == 6 || counter == 9 || counter == 11) {
                    difference += 30;
                }
                else {
                    if (((date1.year&4) == 0 && (date1.year&100) != 0) || (date1.year&400) == 0) {
                        difference += 29;
                    }
                    else {
                        difference += 28;
                    }
                }
            }
        }
        else if (date1.month < date2.month) {
            for (int counter = date1.month;counter < date2.month;counter++) {
                if (counter == 1 || counter == 3 || counter == 5 || counter == 7 || counter == 8 || counter == 10 || counter == 12) {
                    difference -= 31;
                }
                else if (counter == 4 || counter == 6 || counter == 9 || counter == 11) {
                    difference -= 30;
                }
                else {
                    if (((date2.year&4) == 0 && (date2.year&100) != 0) || (date2.year&400) == 0) {
                        difference -= 29;
                    }
                    else {
                        difference -= 28;
                    }
                }
            }
        }
        int diffDay = date1.day-date2.day;
        difference += diffDay;
        return difference;
    }
}