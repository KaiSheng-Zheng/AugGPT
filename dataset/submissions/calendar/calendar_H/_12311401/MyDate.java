public class MyDate {
    private int year;
    private int month;
    private int day;
    int[] daysPerMonth =
            { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public MyDate(int year, int month, int day){
        getYear(year);
        getMonth(month);
        getDay(day);
    }

    public void getYear(int year){
        if (year>0&&year<10000) this.year=year;
    }
    public void getMonth(int month){
        if (month>0&&month<13) this.month=month;
    }
    public void getDay(int day){
        if (checkDay(day)!=0) this.day=day;
    }

    private int checkDay(int day) { // data validation
        if(day > 0 && day <= daysPerMonth[month]) return day;
        if(month == 2 && day == 29 && (year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0)))
            return day;
        return 0;
    }

    public void addDays(int days){
        if (checkDay(day+days)!=0) {
            day+=days;
        }else {
            while (checkDay(day+days)==0) {
                days-=(daysPerMonth[month]-day+1);
                if (month==2&&(year % 400 == 0 ||
                        (year % 4 == 0 && year % 100 != 0))){
                    days--;
                }
                day=1;
                if (month+1<13){
                    ++month;
                }else {
                    month=1;
                    year++;
                }
            }
            day+=days;
        }
    }

    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }

    public static int difference(MyDate date1, MyDate date2){
        int difference=0;
        if (date1.year-date2.year>0){
            if (date1.year-date2.year>1){
                difference=yearDiff(date1.year, date2.year, difference);
            }
            difference+=date1.dayBefore();
            difference+=date2.dayAfter();
        }
        if (date1.year-date2.year<0){
            if (date2.year-date1.year>1){
                difference=yearDiff(date2.year, date1.year, difference);
            }
            difference+=date2.dayBefore();
            difference+=date1.dayAfter();
            return -difference;
        }
        if (date1.year-date2.year==0){
            difference= date1.dayBefore()- date2.dayBefore();
        }
        return difference;
    }
    public static int yearDiff(int a,int b,int difference){
        for (int i=a-1;i-b>0;i--){
            if (i % 400 == 0 ||
                    (i % 4 == 0 && i % 100 != 0)){
                difference+=366;
            }else {
                difference+=365;
            }
        }
        return difference;
    }
    public int dayBefore(){
        int sum=0;
        for (int i = month-1; i > 0 ; i--) {
            if (i==2&&(year % 400 == 0 ||
                    (year % 4 == 0 && year % 100 != 0))){
                sum++;
            }
            sum+=daysPerMonth[i];
        }
        sum+= day;
        return sum;
    }
    public int dayAfter(){
        int sum=0;
        for (int i = month; i <13 ; i++) {
            if (i==2&&(year % 400 == 0 ||
                    (year % 4 == 0 && year % 100 != 0))){
                sum++;
            }
            sum+=daysPerMonth[i];
        }
        sum-= day;
        return sum;
    }
}
