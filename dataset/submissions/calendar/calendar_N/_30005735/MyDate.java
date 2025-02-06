public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    static int compare(MyDate date1,MyDate date2){
        if(date2.year==date1.year&&date2.month==date1.month&&date2.day==date1.day) return 0;
        boolean flag=true;
        if(date2.year<date1.year) flag=false;
        else if(date2.year==date1.year&&date2.month<date1.month) flag=false;
        else if(date2.year==date1.year&&date2.month==date1.month&&date2.day<date1.day) flag=false;
        if(flag) return 1;
        return 2;

    }
    public static int difference(MyDate date1,MyDate date2 ){
        boolean flag=true;
        if(date2.year<date1.year) flag=false;
        else if(date2.year==date1.year&&date2.month<date1.month) flag=false;
        else if(date2.year==date1.year&&date2.month==date1.month&&date2.day<date1.day) flag=false;

        if(!flag){
            MyDate temp=date2;
            date2=date1;
            date1=temp;
        }
        int difference=0;

        if(date1.year==date2.year&&date1.month==date2.month){
            difference=date2.day-date1.day;
        }else{
            MyDate d1=new MyDate(date1.year, date1.month, date1.day);
            MyDate d2=new MyDate(date2.year, date2.month, date2.day);
            difference+=month(d1.year, d1.month)-d1.day;
            d1.day=0;
            d1.monthadd();
            while(d1.year!=d2.year||d1.month!= d2.month){
                difference+=month(d1.year, d1.month);
                d1.monthadd();
            }
            difference+=d2.day;
        }

        if(!flag) return difference;
        else return 0-difference;
    }



    public void addDays(int days){
        if(day+days<=month(year,month)){
            day+=days;
            return;
        }else{
            days-=month(year,month)-day+1;
            monthadd();
            day=1;
        }

        while(days!=0){
            if(days>month(year,month)){
                days-=month(year,month);
                monthadd();
            }else{
                break;
            }
        }
        day+=days;

    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }


    public void monthadd(){
        month++;
        if(month>12){
            month%=12;
            year++;
        }
    }

    public static int month(int year,int month){
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        }
        if(month==2){
            if(year%400==0||(year%4==0&&year%100!=0))
                return 29;
            return 28;
        }
        return 30;
    }

}
