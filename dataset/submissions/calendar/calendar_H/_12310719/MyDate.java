public class MyDate {
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int month;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    private int day;
    private int daythismonth;

    public int getDaythismonth() {
        return daythismonth;
    }

    public void setDaythismonth(int daythismonth) {
        this.daythismonth = daythismonth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public static boolean run(int year){
     if(year%400==0||(year%4==0&&year%100!=0)){
         return true;
     }
     return false;
    }
    public static int yearday(int year){
        if(year==0) return 0;
        if(year>0) {
            if(run(year)) return 366;
            else return 365;
        }
        else {
            if(run(year)) return -366;
            else return -365;
        }
    }
    public static int monthday(int month,int y){
        if(month==0) return 0;
        if(month>0) {
            int daythismonth = 0;
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                daythismonth = 31;
            if (month == 4 || month == 6 || month == 9 || month == 11) daythismonth = 30;
            if (month == 2) {
                if (run(y)) daythismonth = 29;
                else daythismonth = 28;
            }
            return daythismonth;
        }
        else {
            int daythismonth = 0;
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                daythismonth = -31;
            if (month == 4 || month == 6 || month == 9 || month == 11) daythismonth = -30;
            if (month == 2) {
                if (run(y)) daythismonth = -29;
                else daythismonth = -28;
            }
            return daythismonth;
        }
    }
    public MyDate(int year, int month, int day){
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public void addDays(int days){
        days+=getDay();
        setDay(0);
        while (days>0){
            days-=yearday(year);
            year++;
        }
        year--;
        days+=yearday(year);
        while (days>0){
            days-=monthday(month,year);
            month++;
        }
        month--;
        days+=monthday(month,year);
        setDay(days);
    }
    public static MyDate big(MyDate date1,MyDate date2){
        if(date1.getYear()>date2.getYear()||(date1.getYear()==date2.getYear()&&date1.getMonth()>date2.getMonth())
                ||(date1.getYear()==date2.getYear()&&date1.getMonth()==date2.getMonth()||date1.getDay()>date2.getDay())){
            return date1;
        }
        else return date2;
    }
    public static MyDate small(MyDate date1,MyDate date2){
        if(date1.getYear()>date2.getYear()||(date1.getYear()==date2.getYear()&&date1.getMonth()>date2.getMonth())
                ||(date1.getYear()==date2.getYear()&&date1.getMonth()==date2.getMonth()||date1.getDay()>date2.getDay())){
            return date2;
        }
        else return date1;
    }
    public static int diffy(MyDate bigd,MyDate smalld){
        int day=0;
        if(bigd.getYear()!=smalld.getYear()){
            for(int i=smalld.getYear();i< bigd.getYear();i++){
                day+=yearday(i);
            }
        }
        //System.out.println(day);
        if(bigd.getMonth()!=smalld.getMonth()) {
            if(smalld.getMonth()!=1) {
                for (int i = 1; i < smalld.getMonth(); i++) {
                    day += monthday(i, smalld.getYear());
                    //System.out.println( monthday(i, smalld.getYear()));
                }
            }
            if(bigd.getMonth()!=1) {
                for (int i = 1; i < bigd.getMonth(); i++) {
                    day -= monthday(i, bigd.getYear());
                    //System.out.println( monthday(i, bigd.getYear()));
                }
            }
        }
        //System.out.println(day);
        day+=bigd.getDay();
        day-= smalld.getDay();
        return day;
    }
    public static int difference(MyDate date1, MyDate date2){
        MyDate bigd=big(date1,date2);
        MyDate smalld=small(date1,date2);
        return diffy(bigd,smalld);
    }
    public String toString(){
        if(day/10==0&&month/10==0)
        return year+"-0"+month+"-0"+day;
        else if (day/10==0&&month/10!=0) return year+"-"+month+"-0"+day;
        else if(day/10!=0&&month/10!=0) return year+"-"+month+"-"+day;
        else return year+"-0"+month+"-"+day;
    }
}
