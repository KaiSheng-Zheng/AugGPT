public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day) {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days) {
        days+=difference(this,new MyDate(1,1,1));
        year=1;month=1;day=1;
        while ((isLeapYear(year)?366:365)<=days) {
            days-=(isLeapYear(year)?366:365);
            year++;
        }
        for (int i=1;i<=12;i++) {
            int tmp=0;
            if (i==2) tmp=isLeapYear(year)?29:28;
            else if (i%2==1&&i<=7||i%2==0&&i>=8) tmp=31;
            else tmp=30;
            if (tmp<=days) {
                month++;
                days-=tmp;
            } else break;
        }
        day=1+days;
    }
    public String toString() {
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public static boolean isLeapYear(int year) {
        return year%4==0&&year%100!=0||year%400==0;
    }
    //static int[] daysOfMonth={}
    private int calcDaysOfMonthAndDay() {
        int ret=day;
        for (int i=1;i<month;i++) {
            if (i==2) ret+=isLeapYear(year)?29:28;
            else if (i%2==1&&i<=7||i%2==0&&i>=8) ret+=31;
            else ret+=30;
        }
        return ret;
    }

    public static int difference(MyDate date1, MyDate date2) {
        boolean isSwap = false;
        if (date1.year<date2.year||date1.year== date2.year&&date1.month< date2.month
            ||date1.year== date2.year&&date1.month== date2.month&&date1.day< date2.day) {
            MyDate tmpDate=date1;
            date1=date2;
            date2=tmpDate;
            isSwap=true;
        }
        int d1=date1.calcDaysOfMonthAndDay();
        int d2=date2.calcDaysOfMonthAndDay();
        int ret=0;
        for (int i= date2.year;i<date1.year;i++) {
            ret+=isLeapYear(i)?366:365;
        }
        ret+=d1-d2;
        return isSwap?-ret:ret;
    }
}
