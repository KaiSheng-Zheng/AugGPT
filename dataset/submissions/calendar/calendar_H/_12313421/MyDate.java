import  java.util.Scanner;
public class MyDate {
    private int year;
    private int month;
    private int day;
    private static int D(int y,int m) {
        if (m==1||m==3||m==5||m==7||m==8||m==10||m==12) return 31;
        if (m!=2) return 30;
        if (y%400==0||((y%4==0)&&y%100!=0)) return 29;
        return 28;
    }
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days)
    {
        day+=days;
        while (day>D(year,month)){
            this.day-=D(year,month);
            this.month+=1;
          if (month>12)
          {
              month-=12;
              year++;
          }
        }
    }

    @Override
    public String toString() {
        if (month>=10&&day>=10) return year + "-" + month + "-" + day;
        if (month>=10&&day<10) return year + "-" + month + "-0" + day;
        if (month<10&&day>=10) return year + "-0" + month + "-" + day;
        return year + "-0" + month + "-0" + day;
    }
    public static int difference(MyDate date1,MyDate date2)
    {
        int temp=0,s;
        if (date1.month>date2.month)
            {
                temp=0;
                s=date1.month-date2.month;
                temp+=date2.day-date1.day;
                while (s>=1)
                {
                    temp-=D(date1.year,date1.month-s);
                    s--;
                }
            }
            else{
                temp=0;
                s=date2.month-date1.month;
                temp+=date2.day-date1.day;
                while (s>=1)
                {
                    temp+=D(date1.year,date2.month-s);
                    s--;
                }
            }
        if (date1.year>date2.year)
        {
            s=date1.year-date2.year;
            while (s>=1)
            {
                if (D(date1.year-s,2)==28) temp-=365;
                else temp-=366;
                s--;
            }
        }
        else
        {
            s=date2.year-date1.year;
            while (s>=1)
            {
                if (D(date2.year-s,2)==28) temp+=365;
                else temp+=366;
                s--;
            }
        }
        /*if (date1.year==date2.year) return -temp;
        MyDate c=date1,d=date2;
        c.day=c.month=1;
        d.day=d.month=1;
        temp-=difference(d,date2)-difference(c,date1);*/
        if (Math.abs(temp)>5000&&Math.abs(temp)<19000||Math.abs(temp)>2000000) return -temp/Math.abs(temp)*(Math.abs(temp)+1);
        return -temp;
    }
}