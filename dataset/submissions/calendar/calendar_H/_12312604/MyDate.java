public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days)
    {
        int temp=8192;
        int temp_year=this.year;
        int temp_month=1;
        int temp_day=1;
        while(temp>0){
//            System.out.println(new MyDate(temp_year+temp,temp_month,temp_day).toString());
//            System.out.println(difference(new MyDate(temp_year+temp,temp_month,temp_day),new MyDate(0,0,0)));
//            System.out.println("temp:"+temp+" difference:"+difference(new MyDate(temp_year+temp,temp_month,temp_day),this));
            if(temp_year+temp<=9999 && difference(new MyDate(temp_year+temp, temp_month, temp_day),this)<=days){
                temp_year+=temp;
            }else {
                temp/=2;
            }
        }
        temp=8;
        while(temp>0){
            if(temp_month+temp<=12 && difference(new MyDate(temp_year,temp_month+temp,temp_day),this)<=days){
                temp_month+=temp;
            }else {
                temp/=2;
            }
        }
        temp=32;
        while(temp>0){
            if(temp_day+temp<=32 && difference(new MyDate(temp_year,temp_month,temp_day+temp),this)<=days){
                temp_day+=temp;
            }else {
                temp/=2;
            }
        }
        this.year = temp_year;
        this.month = temp_month;
        this.day = temp_day;
    }
    public String toString()
    {
        return String.format("%04d",year)+'-'+String.format("%02d",month)+'-'+String.format("%02d",day);
    }
    public static int difference(MyDate date1, MyDate date2)
    {
        return date1.pre_year()-date2.pre_year()+date1.pre_month()-date2.pre_month()+date1.getDay()-date2.getDay();
    }
    public int pre_year()
    {
        int temp_days=0;
        int temp=this.year-1;
//        System.out.println("caculating pre_year");
        if(temp>400)
        {
            temp_days+=(temp-temp%400)/400*(365*400+97);
            temp%=400;
        }
//        System.out.println("temp_days="+temp_days);
        while(temp>100) {
            if((temp-temp%400)>temp-100){
                temp_days+=25;
            }
            else {
                temp_days+=24;
            }
            temp_days+=100*365;
            temp-=100;
        }
//        System.out.println("temp_days="+temp_days);
        while(temp>4){
            if((temp-temp%400)>temp-4){
                temp_days+=1;
            }
            else if((temp-temp%100)>temp-4)
            {
                temp_days+=0;
            }
            else {
                temp_days+=1;
            }
            temp_days+=4*365;
            temp-=4;
        }
//        System.out.println("temp_days="+temp_days);
        while(temp>=0)
        {
            if(temp%400==0)
            {
                temp_days+=366;
            } else if (temp%100==0) {
                temp_days+=365;
            } else if (temp%4==0) {
                temp_days+=366;
            }else {
                temp_days+=365;
            }
            temp-=1;
        }
//        System.out.println("temp_days="+temp_days);
        return temp_days;
    }
    public int pre_month()
    {
        int temp_days=0;
        int month[];
        if(this.year%400==0)
        {
            month= new int[]{0,0,31,60,91,121,152,182,213,244,274,305,335};
        } else if (this.year%100==0) {
            month= new int[]{0,0,31,59,90,120,151,181,212,243,273,304,334};
        } else if (this.year%4==0) {
            month= new int[]{0,0,31,60,91,121,152,182,213,244,274,305,335};
        }
        else {
            month= new int[]{0,0,31,59,90,120,151,181,212,243,273,304,334};
        }
        return month[this.month];
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
