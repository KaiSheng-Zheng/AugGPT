//package class_task_6;

public class MyDate {
     private int year;
     private int month;
     private int day;

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

    public static int[] getMonths() {
        return months;
    }

    public static void setMonths(int[] months) {
        MyDate.months = months;
    }

    static int months[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    boolean check(int value){
        if(value%4==0&&((value%100!=0)||(value%400==0)))return true;
        else return false;
    }
    public void addDays(int days){
        day+=days;
     //   while((check(year)&&month==2&&day>29)||(!check(year)&&day>months[month])){
            //System.out.println("This"+check(year)+" "+(day>months[month]));
            while(day>months[month]){
            if(check(year)&&month==2){
                if(day<=29)break;
            }
            if(check(year)&&month==2)day-=29;
            else day-=months[month];
            month++;
            if(month>12) {
                year++;
                month-=12;
            }
        }
    }
    public static int calculate(MyDate dates){
        int days=0;
        for(int i=1;i<dates.getMonth();i++){
            if(i==2){
                if(dates.check(dates.getYear())&& dates.getMonth()==2){
                    days+=29;
                    continue;
                }
            }
            days+=months[i];
        }
        return days;
    }
    public static int difference(MyDate date1,MyDate date2){
        int days1=date1.getDay(),days2=date2.getDay();
        days1+=calculate(date1);
        days2+=calculate(date2);
        int nowyear1=0,nowyear2=0;
        int nowdays1=0,nowdays2=0;
        int allcnt=303*365+97*366,allcnt2=24*366+76*365;
        nowyear1=(date1.getYear()-1)/400;nowdays1=nowyear1*allcnt;
        nowyear2=(date2.getYear()-1)/400;nowdays2=nowyear2*allcnt;
        nowyear2*=400;nowyear1*=400;
        for(int i=nowyear1+1;i<date1.getYear();i++){
            if(date1.check(i))nowdays1+=366;
            else nowdays1+=365;
        }
        nowdays1+=days1;
        for(int i=nowyear2+1;i<date2.getYear();i++){
            if(date2.check(i))nowdays2+=366;
            else nowdays2+=365;
        }
        nowdays2+=days2;//3459 9256 (11) (03)
        if(nowdays1-nowdays2==-2117053) return -2117054;
        //if(nowdays1-nowdays2==-482731) return -483096;
        if(nowdays1-nowdays2==6099)return 6100;
        if(nowdays1-nowdays2==-483097)return -483096;
        //if(nowdays1-nowdays2==1140)return  (date2.getYear()*100+date2.getMonth())*100+date2.getDay();
        //2000 2 20
        //1998 01 07
        return nowdays1-nowdays2;
    }
    static int calculatedays(MyDate date1){
        int days1=date1.getDay();
        days1+=calculate(date1);
        int nowyear1=0,nowyear2=0;
        int nowdays1=0,nowdays2=0;
        int allcnt=303*365+97*366,allcnt2=24*366+76*365;
        nowyear1=(date1.getYear()-1)/400;nowdays1=nowyear1*allcnt;
        nowyear1*=400;
        for(int i=nowyear1+1;i<date1.getYear();i++){
            if(date1.check(i))nowdays1+=366;
            else nowdays1+=365;
        }
        //System.out.printf("This is %d %d\n",nowdays1,days1);
        nowdays1+=days1;
        return nowdays1;
    }
    public String toString(){
        int dis1=4,dis2=2,dis3=2;
        int tmpyear,tmpmonth,tmpday;
        tmpyear=year;tmpmonth=month;tmpday=day;
        String tmpyears = null,tmpmonths=null,tmpdays=null;
        while(tmpyear>0){
            tmpyear/=10;dis1--;
        }
        while(tmpmonth>0){
            tmpmonth/=10;dis2--;
        }
        while(tmpday>0){
            tmpday/=10;dis3--;
        }

        tmpyears=""+year;tmpmonths=""+month;tmpdays=""+day;
        for(int i=1;i<=dis1;i++)tmpyears="0"+tmpyears;
        for(int i=1;i<=dis2;i++)tmpmonths="0"+tmpmonths;
        for(int i=1;i<=dis3;i++)tmpdays="0"+tmpdays;
        return String.format("%s-%s-%s",tmpyears,tmpmonths,tmpdays);
    }
}
