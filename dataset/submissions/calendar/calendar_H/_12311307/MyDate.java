
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

    public class MyDate {
        public int year;
        public int month;
        public int day;

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }


        public String toString () {
            return String.format("%d-%02d-%02d",year,month,day);
        }

        public void addDays(int days) {
            for (int i = 0; i < days; i++) {



                if ((year % 4 == 0 & year % 100 != 0) | year % 400 == 0) {
                    switch (month) {
                        case 1, 3, 5, 7, 8, 10:
                            if (day == 31) {
                                month += 1;
                                day = 1;
                            } else day += 1;
                            break;
                        case 2:
                            if (day == 29) {
                                month = 3;
                                day = 1;
                            } else day += 1;
                            break;
                        case 4, 6, 9, 11:
                            if (day == 30) {
                                month += 1;
                                day = 1;
                            } else day += 1;
                            break;
                        case 12:
                            if (day==31){
                                year+=1;
                                month=1;
                                day=1;
                            }
                            else day+=1;
                            break;
                    }
                }
                else {

                        switch (month) {
                            case 1, 3, 5, 7, 8, 10:
                                if (day == 31) {
                                    month += 1;
                                    day = 1;
                                } else day += 1;
                                break;
                            case 2:
                                if (day == 28) {
                                    month = 3;
                                    day = 1;
                                } else day += 1;
                                break;
                            case 4, 6, 9, 11:
                                if (day == 30) {
                                    month += 1;
                                    day = 1;
                                } else day += 1;
                                break;
                            case 12:
                                if (day==31){
                                    year+=1;
                                    month=1;
                                    day=1;
                                }
                                else day+=1;
                                break;

                    }
                }
            }
        }


        public static int difference(MyDate date1, MyDate date2) {
            LocalDate a = LocalDate.of(date1.year, date1.month, date1.day);
            LocalDate b = LocalDate.of(date2.year, date2.month, date2.day);
            int daysBetween = (int) ChronoUnit.DAYS.between(b, a);
            return daysBetween;
        }
    }


