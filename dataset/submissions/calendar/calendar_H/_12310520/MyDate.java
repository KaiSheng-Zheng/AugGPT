public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year,int month,int day){
        this.day=day;
        this.year=year;
        this.month=month;
    }
    public void addDays(int days){ // assume input: days = 1
        // current fields: month = 2, day = 28, year = 2023 (any non-leap year)

        // expected result: 2023-03-01
        // actual result: 2023-02-29

        int[] mon={31,29,31,30,31,30,31,31,30,31,30,31};
        day+=days; // day += 1 -> day = 29
        while(day>mon[month-1]){ // mon[month-1] = mon[1] = 29, 29 > 29, False
            // will not enter the while loop,
            // hence will not be checked whether is a non-leap year
            if(isRunnian(year)){
                mon[1]=29;
            }else{
                mon[1]=28; // then the mon[1] will not be updated correctly as 28
            }
            day-=mon[month-1];
            month++;
            if(month>12){
                year++;
                month%=12;
            }
        }
    }
    public String toString(){
        String yyyy=String.valueOf(year);
        String mm=String.valueOf(month);
        String dd=String.valueOf(day);
        if(year<10)yyyy="000"+year;
        if(10<=year&&year<100)yyyy="00"+year;
        if(100<=year&&year<1000)yyyy="0"+year;
        if(month<10)mm="0"+month;
        if(day<10)dd="0"+day;
        return String.format("%s-%s-%s",yyyy,mm,dd);
    }
    public static int difference(MyDate date1, MyDate date2){
        int js=0;
        int[] mon={31,29,31,30,31,30,31,31,30,31,30,31};
        MyDate zao=new MyDate(0,0,0);
        MyDate wan=new MyDate(0,0,0);
        if(dateCompare(date1,date2)){
            wan.year=date1.year;wan.month=date1.month;wan.day=date1.day;
            zao.year=date2.year;zao.month=date2.month;zao.day=date2.day;
        }else{
            wan.year=date2.year;wan.month=date2.month;wan.day=date2.day;
            zao.year=date1.year;zao.month=date1.month;zao.day=date1.day;
        }

        js-= (zao.day-1);zao.day=1;
        while(!(zao.year==wan.year&&zao.month==wan.month)){
            if(isRunnian(zao.year)){
                mon[1]=29;
            }else{
                mon[1]=28;
            }
            js+= mon[zao.month-1];
            zao.month++;
            if(zao.month>12){
                zao.year++;
                zao.month=zao.month%12;
            }
        }
        js+=(wan.day- zao.day);
        if(!dateCompare(date1,date2))js*=-1;
        return js;
    }
    public static boolean dateCompare(MyDate date1, MyDate date2){
        if(date1.year>date2.year)return true;
        if(date1.year==date2.year&&date1.month>date2.month)return true;
        if(date1.year==date2.year&&date1.month==date2.month&&date1.day>date2.day)return true;
        return false;
    }
    public static boolean isRunnian(int year){
        if(year%400==0||year%100!=0&&year%4==0)return true;
        return false;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

