public class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] dayofmonth={31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days){

        while (days>=0){
            if((this.day+days)<=28) {
                this.day += days;
                break;
            } else RunYear(year);
            if((this.day+days)<=dayofmonth[month-1]) {
                this.day += days;
                break;
            }
            if ((this.day+days)>dayofmonth[month-1]&month<=11){
                days-=dayofmonth[month-1]-this.day+1;
                this.month+=1;
                this.day=1;
            }
            if ((this.day+days)>dayofmonth[month-1]&month==12){
                days-=dayofmonth[month-1]-this.day+1;
                this.year+=1;
                this.month=1;
                this.day=1;
                RunYear(year);
            }
        }
    }
    public void RunYear(int year){
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    dayofmonth[1]=29;
                } else {
                    dayofmonth[1]=28;
                }
            } else {
                dayofmonth[1]=29;
            }
        } else {
            dayofmonth[1]=28;
        }
    }
    public String toString(){
        String outputmonth=String.valueOf(this.month);
        String outputday=String.valueOf(this.day);
        if (this.month<=9&this.month>=1) {
            outputmonth=0+outputmonth;
        }
        if (this.day<=9&this.day>=1){
            outputday=0+outputday;
        }
        return this.year+"-"+outputmonth+"-"+outputday;
    }
    public int toInteger(){
        return this.year*10000+this.month*100+this.day;
    }
    public static int difference(MyDate date1,MyDate date2){
        int differences=0;
        MyDate date1t=new MyDate(date1.year,date1.month,date1.day);
        MyDate date2t=new MyDate(date2.year,date2.month,date2.day);
        if (date1t.toInteger()>=date2t.toInteger()){
            while (!date1t.toString().equals(date2t.toString())) {
                date2t.addDays(1);
                differences++;
            }
        }else{
            while (!date1t.toString().equals(date2t.toString())){
                date1t.addDays(1);
                differences--;
            }
        }
        return differences;
    }
}