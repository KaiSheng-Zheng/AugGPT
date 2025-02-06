
public class MyDate {
    private int year;
    private int month;
    private int day;
    public String event;
    public int getYear(MyDate date){
        return date.year;
    }
    public int getMonth(MyDate date){
        return date.month;
    }
    public int getDay(MyDate date){
        return date.day;
    }
    public void addeventt(String ee){
        this.event =ee;
    }
    public MyDate(int year, int month, int day){
        this.year=year;this.month=month;this.day=day;
    }
    public void addDays(int days){
        for(int i=1;i<=days;i++){
            if(this.day<duo(this.month)){
                this.day++;
            }
            else{
                this.day=1;
                if(this.month==12){
                    this.year++;
                    this.month=1;
                }
                else
                    this.month=(this.month+1);
            }
        }
    }
    public int duo(int mon){
        if(mon==2){
            if(run()) return 29;
            else return 28;
        }
        else{
            if(mon>=1&&mon<=7){
                if(mon%2==0){
                    return 30;
                }
                else return 31;
            }
            else{
                if(mon%2==0) return 31;
                else return 30;
            }
        }
    }
    public boolean run(){
        if((this.year%4==0&&this.year%100!=0)||this.year%400==0){
            return true;
        }
        else return false;
    }
    public String toString(){
        String cc=String.format("%04d",this.year);
        String aa=String.format("%02d",this.month);
        String bb=String.format("%02d",this.day);
        String m=cc+"-"+aa+"-"+bb;
        return m;
    }
    public static int difference(MyDate date3, MyDate date4){
        int sum=0;
        if(xian(date3,date4)){
            int ye=date3.year,mo=date3.month,da=date3.day;
            //System.out.println(date4.year+" "+date4.month+" "+date4.day);
            while(date3.year!=date4.year||date3.month!=date4.month||date3.day!=date4.day){
                sum--;
                date3.addDays(1);
            }
            date3.year=ye;date3.month=mo;date3.day=da;
            return sum;
        }
        else {
            int ye=date4.year,mo=date4.month,da=date4.day;
            while(date3.year!=date4.year||date3.month!=date4.month||date3.day!=date4.day) {
                sum++;
                date4.addDays(1);
            }
            date4.year=ye;date4.month=mo;date4.day=da;
            return sum;
        }
    }
    public static boolean xian(MyDate date5,MyDate date6){
        if(date5.year<date6.year){
            return true;
        }
        else{
            if(date5.year==date6.year){
                if(date5.month<date6.month){
                    return true;
                }
                else{
                    if(date5.month==date6.month){
                        if(date5.day<date6.day) return true;
                        else{
                            return false;
                        }
                    }
                    else return false;
                }
            }
            else{
                return false;
            }
        }
    }
}
