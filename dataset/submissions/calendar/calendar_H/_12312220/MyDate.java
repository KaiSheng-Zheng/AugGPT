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
        for (int i = 0; i < days; i++) {
            if (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0){
                switch (this.month) {
                    case 1:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 2;
                            this.day = 1;
                        }
                        break;
                    case 2:
                        if (this.day + 1 <= 29) {
                            this.day += 1;
                        } else {
                            this.month = 3;
                            this.day = 1;
                        }
                        break;
                    case 3:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 4;
                            this.day = 1;
                        }
                        break;
                    case 4:
                        if (this.day + 1 <= 30) {
                            this.day += 1;
                        } else {
                            this.month = 5;
                            this.day = 1;
                        }
                        break;
                    case 5:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 6;
                            this.day = 1;
                        }
                        break;
                    case 6:
                        if (this.day + 1 <= 30) {
                            this.day += 1;
                        } else {
                            this.month = 7;
                            this.day = 1;
                        }
                        break;
                    case 7:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 8;
                            this.day = 1;
                        }
                        break;
                    case 8:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 9;
                            this.day = 1;
                        }
                        break;
                    case 9:
                        if (this.day + 1 <= 30) {
                            this.day += 1;
                        } else {
                            this.month = 10;
                            this.day = 1;
                        }
                        break;
                    case 10:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 11;
                            this.day = 1;
                        }
                        break;
                    case 11:
                        if (this.day + 1 <= 30) {
                            this.day += 1;
                        } else {
                            this.month = 12;
                            this.day = 1;
                        }
                        break;
                    case 12:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.year += 1;
                            this.month = 1;
                            this.day = 1;
                        }
                        break;
                }
            }else {
                switch (this.month) {
                    case 1:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 2;
                            this.day = 1;
                        }
                        break;
                    case 2:
                        if (this.day + 1 <= 28) {
                            this.day += 1;
                        } else {
                            this.month = 3;
                            this.day = 1;
                        }
                        break;
                    case 3:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 4;
                            this.day = 1;
                        }
                        break;
                    case 4:
                        if (this.day + 1 <= 30) {
                            this.day += 1;
                        } else {
                            this.month = 5;
                            this.day = 1;
                        }
                        break;
                    case 5:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 6;
                            this.day = 1;
                        }
                        break;
                    case 6:
                        if (this.day + 1 <= 30) {
                            this.day += 1;
                        } else {
                            this.month = 7;
                            this.day = 1;
                        }
                        break;
                    case 7:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 8;
                            this.day = 1;
                        }
                        break;
                    case 8:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 9;
                            this.day = 1;
                        }
                        break;
                    case 9:
                        if (this.day + 1 <= 30) {
                            this.day += 1;
                        } else {
                            this.month = 10;
                            this.day = 1;
                        }
                        break;
                    case 10:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.month = 11;
                            this.day = 1;
                        }
                        break;
                    case 11:
                        if (this.day + 1 <= 30) {
                            this.day += 1;
                        } else {
                            this.month = 12;
                            this.day = 1;
                        }
                        break;
                    case 12:
                        if (this.day + 1 <= 31) {
                            this.day += 1;
                        } else {
                            this.year += 1;
                            this.month = 1;
                            this.day = 1;
                        }
                        break;
                }
            }
            }
        }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDate date01 =LocalDate.of(date1.year,date1.month,date1.day);
        LocalDate date02 =LocalDate.of(date2.year,date2.month,date2.day);
        int daysDifference =(int) getDaysDifference(date02,date01);
        return daysDifference;
    }
public static long getDaysDifference(LocalDate date01 , LocalDate date02){
        return ChronoUnit.DAYS.between(date01,date02);
}
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
