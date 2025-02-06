public class MyDate{
    private long timestamp;
    private final int sum[]={0,31,31+28,31+28+31,31+28+31+30,31+28+31+30+31,31+28+31+30+31+30,31+28+31+30+31+30+31,31+28+31+30+31+30+31+31,31+28+31+30+31+30+31+31+30,31+28+31+30+31+30+31+31+30+31,31+28+31+30+31+30+31+31+30+31+30,31+28+31+30+31+30+31+31+30+31+30+31};

    public MyDate(int year,int month,int day){
        year--;
        this.timestamp = year * 365 + year / 4 -year / 100 + year / 400 + sum[month-1] + day-1;
        year++;
        this.timestamp += ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month > 2) ? 1 : 0;
    }

    public void addDays(int days){
        this.timestamp += days;
    }

    public static int difference(MyDate date1, MyDate date2){
        return (int)(date1.timestamp - date2.timestamp);
    }

    public String toString(){
        int year = (int)(this.timestamp / 366);
        while(year * 365 + year / 4 -year / 100 + year / 400 <= this.timestamp)
            year++;
        year--;
        int month=1,day,rem=(int)(this.timestamp - (year * 365 + year / 4 -year / 100 + year / 400));
        year++;
        while(sum[month]+(((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month >= 2) ? 1 : 0)<=rem)month++;
        day = rem - sum[month-1] - (((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month > 2) ? 1 : 0)+1;
        return String.format("%02d-%02d-%02d", year,month,day);
    }

    public long getTimestamp(){
        return this.timestamp;
    }
}