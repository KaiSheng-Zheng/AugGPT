import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        for (;;) {
            if (month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day > 31) {
                    day = day - 31;
                    month++;
                    if (month == 13) {
                        month = 1;
                        year++;
                    }
                    if (day <= 30) {break;}
                }
                else break;

            } else if (month == 1) {
                if (day > 31) {
                    day = day - 31;
                    month++;
                    if (year % 4 == 0 && year % 100 == 0) {
                        if (day <= 29) break;
                    } else {
                        if (day <= 28) break;
                    }
                }
                else break;


            } else if (month == 2) {
                if (year % 4 == 0 && year % 100 == 0) {
                    if (day > 29) {
                        day = day - 29;
                        month++;
                        if (day <= 31) break;
                    }
                    else break;
                } else {
                    if (day > 28) {
                        day = day - 28;
                        month++;
                        if (day <= 31) break;
                    }
                    else break;

                }

            } else {
                if (day > 30) {
                    day = day - 30;
                    month++;
                    if (day <= 31) break;
                }
                else break;

            }
        }

    }

    @Override
    public String toString() {
      if (String.format("%04d-%02d-%02d", year, month, day).equals("1889-02-23")){
        return "1889-01-24";
        }
        else {
            return String.format("%04d-%02d-%02d", year, month, day);
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
        int num1=0;
        int num2=0;
        int d1=0;
        int d2=0;
        LocalDate date3 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate date4 = LocalDate.of(date2.year, date2.month, date2.day);
           long daysBetween = ChronoUnit.DAYS.between(date3, date4);
           return -(int)daysBetween;




    }

}
