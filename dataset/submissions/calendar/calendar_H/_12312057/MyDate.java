import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int oldAllDays = 0;
        for (int i = 1; i < month; i++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                months[2] = 29;
            } else {
                months[2] = 28;
            }
            oldAllDays += months[i];
        }
        oldAllDays += day;
        int added = oldAllDays + days;

        while (added > 365) {
            int oneYearSum = 0;
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                oneYearSum = 366;
            } else {
                oneYearSum = 365;
            }
            if (added > oneYearSum) {
                year++;
                added = added - oneYearSum;
            }
        }
        int newdays = added;
        month = 0;
        for (int i = 1; newdays > months[i]; i++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                months[2] = 29;
            } else {
                months[2] = 28;
            }
            newdays -= months[i];
            month = i;
        }
        month++;
        day = newdays;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    @Override
    public int compareTo(MyDate anotherDate) {
        if (this.year != anotherDate.year) {
            return this.year - anotherDate.year;
        }
        if (this.month != anotherDate.month) {
            return this.month - anotherDate.month;
        }
        return this.day - anotherDate.day;
    }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDate localDate1 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate localDate2 = LocalDate.of(date2.year, date2.month, date2.day);
        return (int) -ChronoUnit.DAYS.between(localDate1, localDate2);
//        int dif = 0;
//        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        int oldAllDays = 0;
//        int newAllDays = 0;
//        int posOrNeg = 1;
//        if (date1.year < date2.year) {
//            MyDate date3 = date1;
//            date1 = date2;
//            date2 = date3;
//            posOrNeg = 2;
//        } else if (date1.year == date2.year) {
//            if (date1.month < date2.month) {
//                MyDate date3 = date1;
//                date1 = date2;
//                date2 = date3;
//                posOrNeg = 2;
//            } else if (date1.month == date2.month) {
//                if (date1.day < date2.day) {
//                    MyDate date3 = date1;
//                    date1 = date2;
//                    date2 = date3;
//                    posOrNeg = 2;
//                }
//            }
//        }
//        while (date1.year > date2.year) {
//            if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0) {
//                dif += 366;
//            } else {
//                dif += 365;
//            }
//            date1.year++;
//        }
//
//        for (int i = 1; i < date1.month; i++) {
//            if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0) {
//                months[2] = 29;
//            } else {
//                months[2] = 28;
//            }
//            oldAllDays += months[i];
//        }
//        oldAllDays += date1.day;
//
//        for (int i = 1; i < date2.month; i++) {
//            if ((date2.year % 4 == 0 && date2.year % 100 != 0) || date2.year % 400 == 0) {
//                months[2] = 29;
//            } else {
//                months[2] = 28;
//            }
//            newAllDays += months[i];
//        }
//        newAllDays += date2.day;
//        newAllDays--;
//
//        dif = dif - oldAllDays + newAllDays;
//        if (posOrNeg == 2) {
//            dif = -dif;
//        }
//        return dif;
    }


}
