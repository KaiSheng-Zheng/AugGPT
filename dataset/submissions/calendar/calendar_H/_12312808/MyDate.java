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
        while (days > 0) {
            days--;
            if (day != daysOfMonth(year, month)) {
                day++;
            } else if (month != 12) {
                month++;
                day = 1;
            } else {
                year++;
                month = 1;
                day = 1;
            }
        }
    }

    public String toString() {
        return String.format("%4d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        MyDate early, late;
        if (formerIsEarlier(date1, date2)) {
            early = date1;
            late = date2;
        } else {
            early = date2;
            late = date1;
        }
        int diff = 0;

        //when there is at least one gap year
        for (int i = early.year + 1; i < late.year; i++) {
            diff += daysOfYear(i);
        }
        //when not in the same year
        if (early.year != late.year) {
            for (int i = early.month + 1; i < 13; i++) {
                diff += daysOfMonth(early.year, i);
            }
            for (int i = 1; i < late.month; i++) {
                diff += daysOfMonth(late.year, i);
            }
        }

        if (early.month != late.month) { //when not in the same month
            diff += late.day + daysOfMonth(early.year, early.month) - early.day;
        } else { //when in the same month
            diff += late.day - early.day;
        }
        if (formerIsEarlier(date1, date2)) {
            return -diff;
        } else {
            return diff;
        }
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static int daysOfMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 42;
        }
    }

    public static int daysOfYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        } else {
            return 365;
        }
    }

    public static boolean formerIsEarlier(MyDate date1, MyDate date2) {
        if (date1.year < date2.year) {
            return true;
        } else if (date1.year > date2.year) {
            return false;
        }

        if (date1.month < date2.month) {
            return true;
        } else if (date1.month > date2.month) {
            return false;
        }

        return date1.day < date2.day;
    }
    public static int getNumUnEventsOfThisDateInThisCalendar(MyDate date1, MyCalendar calendar1) {
        int count = 0;
        for (int i = 0; i < event.events.size(); i++) { // iterate through all the events
            if (event.events.get(i).date == date1 && event.events.get(i).calendar == calendar1 && !event.events.get(i).isFinished) { // ensure the event is at date1 and calendar1;
                count++;
            }
        }
        return count;
    }
}
