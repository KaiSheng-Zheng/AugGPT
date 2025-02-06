
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.text.Format;
import java.util.Formatter;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public static int counter;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        counter++;
    }

    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                switch (month) {
                    case 1:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 2:
                        if (day == 29) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 3:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 4:
                        if (day == 30) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 5:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 6:
                        if (day == 30) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 7:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 8:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 9:
                        if (day == 30) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 10:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 11:
                        if (day == 30) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 12:
                        if (day == 31) {
                            year++;
                            month = 1;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                }
            }//leap year
            else {
                switch (month) {
                    case 1:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 2:
                        if (day == 28) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 3:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 4:
                        if (day == 30) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 5:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 6:
                        if (day == 30) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 7:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 8:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 9:
                        if (day == 30) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 10:
                        if (day == 31) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 11:
                        if (day == 30) {
                            month++;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                    case 12:
                        if (day == 31) {
                            year++;
                            month = 1;
                            day = 1;
                        } else {
                            day++;
                        }
                        break;
                }
            }//normal year
        }
    }

    @Override
    public String toString() {
        String str = String.format("%04d-%02d-%02d", year, month, day);
        return str;
    }

    public static int difference(MyDate date1, MyDate date2) {
        long diff = 0;
        LocalDate temp2=LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate temp1=LocalDate.of(date2.year, date2.month, date2.day);
        diff=ChronoUnit.DAYS.between(temp1, temp2);
        int diff2=(int) diff;
        return diff2;
//        MyDate temp1 = new MyDate(date1.year,date1.month,date1.day);//date1;
//        MyDate temp2 = new MyDate(date2.year,date2.month,date2.day);
//        if (!date1.toString().equals(date2.toString())) {
//            if (date1.year == date2.year) {
//                if (date1.month == date2.month) {
//                    if (date1.day > date2.day) {
//                        while (!date1.toString().equals(temp2.toString())) {
//                            temp2.addDays(1);
//                            diff++;
//                        }
//                    } else {
//                        while (!temp1.toString().equals(date2.toString())) {
//                            temp1.addDays(1);
//                            diff--;
//                        }
//                    }
//                } else {
//                    if (date1.month > date2.month) {
//                        while (!date1.toString().equals(temp2.toString())) {
//                            temp2.addDays(1);
//                            diff++;
//                        }
//                    } else {
//                        while (!temp1.toString().equals(date2.toString())) {
//                            temp1.addDays(1);
//                            diff--;
//                        }
//                    }
//                }
//            } else {
//                if (date1.year > date2.year) {
//                    while (!date1.toString().equals(temp2.toString())) {
//                        temp2.addDays(1);
//                        diff++;
//                    }
//                } else {
//                    while (!temp1.toString().equals(date2.toString())) {
//                        temp1.addDays(1);
//                        diff--;
//                    }
//                }
//            }
//        }else {
//            diff=0;
//        }
    }
}

