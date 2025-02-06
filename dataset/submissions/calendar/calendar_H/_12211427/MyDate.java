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
        int[] nofdays1=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int[] nofdays2=new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        while(days>0){
            if(((year%4==0)&(year%100!=0))|(year%400==0)){
                if(days+day<=nofdays2[month-1]){
                    day+=days;
                    days=0;
                }
                else{
                    if(month!=12){
                        days-=nofdays2[month-1]-day+1;
                        day=1;
                        month+=1;
                    }
                    else{
                        days-=nofdays2[11]-day+1;
                        day=1;
                        month=1;
                        year+=1;
                    }
                }
            }
            else{
                if(days+day<=nofdays1[month-1]){
                    day+=days;
                    days=0;
                }
                else{
                    if(month!=12){
                        days-=nofdays1[month-1]-day+1;
                        day=1;
                        month+=1;
                    }
                    else{
                        days-=nofdays1[11]-day+1;
                        day=1;
                        month=1;
                        year+=1;
                    }
                }
            }
        }
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1, MyDate date2){
        int n=0;
        //int year1=date1.year;
        //int year2=date2.year;
        //int month1=date1.month;
        //int month2=date2.month;
        //int day1=date1.day;
        //int day2=date1.day;
        //int[] nofdays1=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        //int[] nofdays2=new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        //if(year1>year2){
            //while((year1!=year2)|(month1!=month2)|(day1!=day2)){
                //year2.addDays(1);
           //}
        //}
        if((date1.year>date2.year)|((date1.year==date2.year)&(date1.month>date2.month))|((date1.year==date2.year)&(date1.month==date2.month)&(date1.day>=date2.day))){
            MyDate x=new MyDate(date1.year,date1.month,date1.day);
            MyDate y=new MyDate(date2.year,date2.month,date2.day);
            while((x.year!=y.year)|(x.month!=y.month)|(x.day!=y.day)){
                y.addDays(1);
                n+=1;
            }
        }
        else{
            MyDate x=new MyDate(date1.year,date1.month,date1.day);
            MyDate y=new MyDate(date2.year,date2.month,date2.day);
            while((x.year!=y.year)|(x.month!=y.month)|(x.day!=y.day)){
                x.addDays(1);
                n+=1;
            }
            n*=-1;
        }
        return n;
    }
}
