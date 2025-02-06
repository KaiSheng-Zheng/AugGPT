public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
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

    public void addDays(int days) {
        day += days;
        while (true) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day > 31) {
                    month += 1;
                    if (month == 13) {
                        year += 1;
                        month = 1;
                    }
                    day -= 31;
                } else break;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 30) {
                    month += 1;
                    day -= 30;
                } else break;
            } else if (month == 2) {
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    if (day > 29) {
                        month += 1;
                        day -= 29;
                    } else break;
                } else {
                    if (day > 28) {
                        month += 1;
                        day -= 28;
                    } else break;
                }
            }
        }
    }
    public String toString(){
        return String.format("%d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1,MyDate date2){
        int dif=0;
        if((date1.getYear()> date2.getYear())||((date1.getYear()==date2.getYear()&&date1.getMonth()> date2.getMonth()))||((date1.getYear()==date2.getYear()&&date1.getMonth()== date2.getMonth()&&date1.getDay()>= date2.getDay()))){
            int year=date2.getYear();
            int month=date2.getMonth();
            int day=date2.getDay();
            while(!(date1.getYear()==date2.getYear()&&date1.getMonth()==date2.getMonth()&&date1.getDay()==date2.getDay())){
                date2.addDays(1);
                dif++;
            }
            date2.setDay(day);
            date2.setMonth(month);
            date2.setYear(year);
        }else{
            int year=date1.getYear();
            int month=date1.getMonth();
            int day=date1.getDay();
            while(!(date1.getYear()==date2.getYear()&&date1.getMonth()==date2.getMonth()&&date1.getDay()==date2.getDay())){
                date1.addDays(1);
                dif--;
            }
            date1.setDay(day);
            date1.setMonth(month);
            date1.setYear(year);
        }
        return dif;
    }
}
