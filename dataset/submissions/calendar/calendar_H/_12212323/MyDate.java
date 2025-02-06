public class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int leapYearSum = 366;
    private int commonYearSum = 365;
    private int[] commonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days) {
        int[] year = new int[12];
        for (int i = 0; i < days; i++) {
            if ((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0) {
                year = leapYear;
            } else {
                year = commonYear;
            }
            if (day == year[month - 1]) {
                day = 1;
                month++;
            } else {
                day++;
            }
            if (month > 12) {
                month = 1;
                this.year++;
            }
        }
    }

    public String toString() {
        String monTh;
        String daY;
        if(month<10){
            monTh="0"+month;
        }else {
            monTh=String.valueOf(month);
        }
        if(day<10){
            daY ="0"+day;
        }else{
            daY=String.valueOf(day);
        }
        return year+"-"+monTh+"-"+daY;
    }

    public static int difference(MyDate date1, MyDate date2) {
        int sumYear1 = 0;
        int sumYear2=0;
        int sumDate1=0;
        int sumDate2 = 0;
        int sumMonth1 = 0;
        int sumMonth2=0;
        for (int i = 0; i < date1.year - 1582; i++) {
            int yearSum = 0;
            int monthSum = 0;
            int[] year = new int[12];
            if (((1582 + i) % 4 == 0 && (1582 + i) % 100 != 0) || (1582 + i) % 400 == 0) {
                year = date1.leapYear;
                yearSum = date1.leapYearSum;
            } else {
                year = date1.commonYear;
                yearSum = date1.commonYearSum;
            }
            sumYear1 += yearSum;
        }
        if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0) {
            for (int i = 0; i < date1.month-1; i++) {
                sumMonth1 += date1.leapYear[i];
            }
        } else {
            for (int i = 0; i < date1.month-1; i++) {
                sumMonth1 += date1.commonYear[i];
            }
        }
        sumDate1=sumYear1+sumMonth1+date1.day;
        System.out.println(sumDate1);
        for (int i = 0; i < date2.year - 1582; i++) {
            int yearSum = 0;
            int monthSum = 0;
            int[] year = new int[12];
            if (((1582 + i) % 4 == 0 && (1582 + i) % 100 != 0) || (1582 + i) % 400 == 0) {
                year = date2.leapYear;
                yearSum = date2.leapYearSum;
            } else {
                year = date2.commonYear;
                yearSum = date2.commonYearSum;
            }
            sumYear2 += yearSum;
        }
        if ((date2.year % 4 == 0 && date2.year % 100 != 0) || date2.year % 400 == 0) {
            for (int i = 0; i < date2.month-1; i++) {
                sumMonth2 += date2.leapYear[i];
            }
        } else {
            for (int i = 0; i < date2.month-1; i++) {
                sumMonth2 += date2.commonYear[i];
            }
        }
        sumDate2=sumYear2+sumMonth2+date2.day;
        System.out.println(sumDate2);
        return sumDate1 - sumDate2;
    }
}
