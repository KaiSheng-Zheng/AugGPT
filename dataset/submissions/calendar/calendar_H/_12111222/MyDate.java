public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    public void addDays(int days){
        int day1 = sum(this);
        day1 += days;
        int []x = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int year_number = 1;
        int month_number = 1;
        int day_number = 0;
        while(day1 > 366){
            if (year_number%4==0 && year_number%100 != 0 || year_number%400 == 0){
                day1 -= 366;
            }else {
                day1 -= 365;
            }
            year_number ++;
        }
        if (year_number%4==0 && year_number%100 != 0 || year_number%400 == 0){
            x[2] = 29;
        }
        while (day1 > x[month_number]){
            day1 -= x[month_number];
            month_number ++;
        }
        day_number = day1;
        this.year = year_number - 1;
        this.month = month_number;
        this.day = day_number;
    }


    public String toString(){
        return String.format("%04d-%02d-%02d",this.year,this.month,this.day);
    }

    public static int difference(MyDate date1,MyDate date2){
        //date1 - date2
        int day1 = sum(date1);
        int day2 = sum(date2);
        return day1 - day2;
    }
    public static int sum(MyDate d){
        int day = 0;
        int []x = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        for (int i = 0; i < d.year; i++) {
            if (i%4==0 && i%100 != 0 || i%400 == 0){
                day += 366;
            }else {
                day += 365;
            }
        }
        if (d.year%4==0 && d.year%100 != 0 || d.year%400 == 0){
            x[2] = 29;
        }
        for (int i = 0; i < d.month; i++) {
            day += x[i];
        }
        day += d.day;
        return day - 1;
    }
}
