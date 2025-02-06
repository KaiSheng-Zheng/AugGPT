public class MyDate {
    private int year;
    private int month;
    private int day;
    private int dayNum;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayNum=countDayNum();
    }
    private boolean isLeap;

    public boolean isLeap(){
        isLeap=false;
        if ((year%4==0 && year%100!=0)||(year%400==0)){
            isLeap=true;
        }
        return isLeap;
    }
    public boolean isLeap(MyDate date){
        isLeap=false;
        if ((date.year%4==0 && date.year%100!=0)||(date.year%400==0)){
            isLeap=true;
        }
        return isLeap;
    }
private int leaps;
    public int getLeaps(){
            if (month>2) {
                leaps = (int) year / 4 - (int) year / 100 + (int) year / 400;
            }else leaps = (int) (year-1) / 4 - (int) (year-1) / 100 + (int) (year-1) / 400;
            return leaps;
    }


    public int countDayNum(){
        switch (month){
            case 12:dayNum=day;
            case 11:dayNum=(dayNum!=0) ? dayNum+30 : day;
            case 10:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 9:dayNum=(dayNum!=0) ? dayNum+30 : day;
            case 8:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 7:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 6:dayNum=(dayNum!=0) ? dayNum+30 : day;
            case 5:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 4:dayNum=(dayNum!=0) ? dayNum+30 : day;
            case 3:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 2:dayNum=(dayNum!=0) ? dayNum+28 : day;
            case 1:dayNum=(dayNum!=0) ? dayNum+31 : day;
            break;
        }

        dayNum+=year*365+getLeaps();
        return dayNum;
    }

    public int countDayNum(MyDate date){
        switch (month){
            case 12:dayNum=day;
            case 11:dayNum=(dayNum!=0) ? dayNum+30 : day;
            case 10:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 9:dayNum=(dayNum!=0) ? dayNum+30 : day;
            case 8:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 7:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 6:dayNum=(dayNum!=0) ? dayNum+30 : day;
            case 5:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 4:dayNum=(dayNum!=0) ? dayNum+30 : day;
            case 3:dayNum=(dayNum!=0) ? dayNum+31 : day;
            case 2:dayNum=(dayNum!=0) ? dayNum+28 : day;
            case 1:dayNum=(dayNum!=0) ? dayNum+31 : day;
                break;
        }
        dayNum+=year*365+getLeaps();
        return dayNum;
    }

    public void addDays(int days){
        MyDate newDate=new MyDate(this.year,this.month,this.day);
        newDate.dayNum=this.dayNum+days;
        newDate.year=year+(int)days/365;;
        newDate.getMonth(newDate);
        for (int i=1;i<32;i++){
            newDate.dayNum=0;
            newDate.day=i;
            if (newDate.countDayNum(newDate)==dayNum+days){
                day= newDate.day;
                month=newDate.month;
                year=newDate.year;
                dayNum+=days;
                break;
            }
        }
    }

    public String toString(){
        if (month < 10) {
            if (day<10){
                return String.format("%d-0%d-0%d", year, month, day);
            }
            return String.format("%d-0%d-%d", year, month, day);
        }
        if (day < 10) {
            return String.format("%d-%d-0%d", year, month, day);
        }
        return String.format("%d-%d-%d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2){

        return date1.dayNum- date2.dayNum;
    }

    private String eventName;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void getMonth(MyDate newDate){
        int d;
        if (newDate.isLeap()){
            d=1;
        }else d=0;
        int DaysInYear=dayNum-year*365-newDate.getLeaps();
        if (DaysInYear>0 && DaysInYear<=31){
            month=1;
        } else if (DaysInYear>31 && DaysInYear<=59+d) {
            month=2;
        }else if (DaysInYear>59+d && DaysInYear<=90+d){
            month=3;
        } else if (DaysInYear>90+d && DaysInYear<=120+d) {
            month=4;
        } else if (DaysInYear>120+d && DaysInYear<=151+d) {
            month=5;
        } else if (DaysInYear>151+d && DaysInYear<=181+d) {
            month=6;
        } else if (DaysInYear>181+d && DaysInYear<=212+d) {
            month=7;
        }else if (DaysInYear>212+d && DaysInYear<=243+d){
            month=8;
        } else if (DaysInYear>243+d && DaysInYear<=273+d) {
            month=9;
        } else if (DaysInYear>273+d && DaysInYear<=304+d) {
            month=10;
        } else if (DaysInYear>=304+d && DaysInYear<=334+d) {
            month=11;
        }else if (DaysInYear>334+d && DaysInYear<=365+d){
            month=12;
        }

    }

    public int getDayNum() {
        return dayNum;
    }

    public  MyDate(MyDate date){
        this.year= date.year;
        this.month= date.month;
        this.day= date.day;
        this.dayNum=date.dayNum;
        this.eventName=date.eventName;
    }
}
