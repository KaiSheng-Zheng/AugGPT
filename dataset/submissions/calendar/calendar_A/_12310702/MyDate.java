
public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(MyDate date){
        set(date);
    }
    public MyDate(int year,int month,int day){
        setYear(year);
        setMonth(month);
        setDay(day);
    }
    private int getYear(){
        return year;
    }
    private int getMonth(){
        return month;
    }
    private int getDay(){
        return day;
    }
    public void set(MyDate date){
        setYear(date.getYear());
        setMonth(date.getMonth());
        setDay(date.getDay());
    }
    private void setYear(int year){
        this.year=year;
    }
    private void setMonth(int month){
        this.month=month;
    }
    private void setDay(int day){
        this.day=day;
    }
    public void addDays(int days){
        this.set(MyDate.toDate(this.toInt()+days));
    }
    public String toString(){
        return String.format("%d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1,MyDate date2){
        return date1.toInt()-date2.toInt();
    }
    private int toInt(){
        int s=0;
        int i;
        for(i=1;i<this.getYear();i++)
            s+=daysOfYear(i);
        for(i=1;i<this.getMonth();i++)
            s+=daysOfMonth(this.getYear(),i);
        s+=this.getDay();
        return s;
    }
    private static MyDate toDate(int s){
        MyDate date=new MyDate(1,1,1);
        int i;
        for(i=1;s>daysOfYear(i);i++)
            s-=daysOfYear(i);
        date.setYear(i);
        for(i=1;s>daysOfMonth(date.getYear(),i);i++)
            s-=daysOfMonth(date.getYear(),i);
        date.setMonth(i);
        date.setDay(s);
        return date;
    }
    private static int daysOfYear(int year){
        if(isLeapYear(year))
            return 366;
        else
            return 365;
    }
    private static int daysOfMonth(int year,int month){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if(isLeapYear(year))
                    return 29;
                else
                    return 28;
            default:
                return -1;
        }
    }
    private static boolean isLeapYear(int year){
        if((year%4==0&&year%100!=0)||year%400==0)
            return true;
        else
            return false;
    }
}