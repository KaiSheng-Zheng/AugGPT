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
        while (days != 0) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day < 31) {
                    day++;
                    days--;
                } else {
                    if (month < 12) {
                        month++;
                        day = 1;
                        days--;
                    } else {
                        year++;
                        month = 1;
                        day = 1;
                        days--;
                    }
                }
            } else {
                if (month == 2) {
                    if (leapYear(year)) {
                        if (day < 29) {
                            day++;
                            days--;
                        } else {
                            month++;
                            day = 1;
                            days--;
                        }
                    } else {
                        if (day < 28) {
                            day++;
                            days--;
                        } else {
                            month++;
                            day = 1;
                            days--;
                        }
                    }
                } else {
                    if (day < 30) {
                        day++;
                        days--;
                    } else {
                        month++;
                        day = 1;
                        days--;
                    }
                }
            }

        }

    }
    public boolean equals(MyDate d){
        boolean a ;
        if(this.year==d.year&&this.month==d.month&&this.day==d.day){
            a=true;
        }else {
            a=false;
        }
        return a;
    }
    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }
    public static int difference(MyDate date1, MyDate date2){
        int diff = 0;
        MyDate date3 = new MyDate(date1.year,date1.month,date1.day);
        MyDate date4 = new MyDate(date2.year,date2.month,date2.day);

        if (date2IsEarly(date1, date2)){
            while (true){
                if (date4.equals(date3)){
                    break;
                }
                date4.addDays(1);
                diff++;
            }
        }else {
            while (true){
                if (date4.equals(date3)){
                    break;
                }
                date3.addDays(1);
                diff++;
            }diff = 0 - diff;
        }
        return diff;
    }

    public static boolean date2IsEarly(MyDate date1, MyDate date2){
        boolean date2IsEarly;
        if (date1.year>date2.year) {
            date2IsEarly=true;
        }else{
            if (date1.year<date2.year){
                date2IsEarly=false;
            }else {
                if (date1.month>date2.month){
                    date2IsEarly=true;
                }else {
                    if (date1.month<date2.month){
                        date2IsEarly=false;
                    }else {
                        if (date1.day> date2.day){
                            date2IsEarly=true;
                        }else date2IsEarly = false;
                    }
                }
            }
        }
        return date2IsEarly;
    }
    public boolean leapYear(int year) {
        boolean judgement= false;
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                judgement = true;
            } else if (year%400==0){
                judgement  = true;
            }
        }
        return judgement;
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