public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days){
       for (int i=1;i<=days;i++){
           if (month==4||month==6||month==9||month==11){
               if (day>=30){
                   day=1;
                   month++;
               }else day++;
           } else if (month==2) {
               if (isLeapYear()){
                   if (day>=29){
                       day=1;
                       month++;
                   }else day++;
               }else {
                   if (day>=28){
                       day=1;
                       month++;
                   }else day++;
               }
           }else {
               if (day>=31){
                   day=1;
                   month++;
               }else day++;
           }
           if (month>12){
               month=1;
               year++;
           }
       }
    }
    public String toString(){
        if (month<10&&day<10) {
            return String.format("%d-0%d-0%d", year, month, day);
        } else if (day<10) {
            return String.format("%d-%d-0%d", year, month, day);
        }else if (month<10) {
            return String.format("%d-0%d-%d", year, month, day);
        }
        return String.format("%d-%d-%d", year, month, day);
    }
    public static int difference(MyDate date1,MyDate date2){
        return date1.days(date1)-date2.days(date2);
    }
    private boolean isLeapYear() {
           return (this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0;
    }
    public int days(MyDate myDate){
        int days=0;
        for (int i=0;i<year;i++){
            if ((i%4==0&&i%100!=0)||i%400==0)days+=366;
            else days+=365;
        }
        for (int i=1;i<month;i++){
            if (i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                days+=31;
            } else if (i==2) {
                if (myDate.isLeapYear())days+=29;
                else days+=28;
            }else days+=30;
        }
        days+=day;
        return days;
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