public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public void addDays(int days){
        while (days>0){
            if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
                if (31-day>=days){
                    day+=days;
                    days=0;
                }else {
                    days = days - 1 - 31 + day;
                    day = 1;
                    month+=1;
                    if (month==13){
                        year+=1;
                        month=1;
                    }
                }
            } else if (month == 4 ||month==6||month==9||month==11) {
                if (30-day>=days){
                    day+=days;
                    days=0;
                }else {
                    days = days - 1 - 30 + day;
                    day = 1;
                    month+=1;
                }
            }else {
                if (year%400==0||(year%4==0&&year%100!=0)){
                    if (29-day>=days){
                        day+=days;
                        days=0;
                    }else {
                        days = days - 1 - 29 + day;
                        day = 1;
                        month+=1;
                    }
                }else {
                    if (28-day>=days){
                        day+=days;
                        days=0;
                    }else {
                        days = days - 1 - 28 + day;
                        day = 1;
                        month+=1;
                    }
                }
            }
        }
    }
    public String toString(){
        if (month<10) {
            if (day<10){
                return year + "-0" + month + "-0" + day;
            }else return year + "-0" + month + "-" + day;
        }else {
            if (day<10){
                return year + "-" + month + "-0" + day;
            }else return year + "-" + month + "-" + day;
        }
    }
    public static int difference(MyDate date1, MyDate date2){
        int D=0;
        if (date1.year<date2.year||(date1.year==date2.year&&date1.month<date2.month)||(date1.year==date2.year&&date1.month==date2.month&&date1.day<date2.day)){
            MyDate temp=new MyDate(date1.year,date1.month,date1.day);
            while (temp.year!=date2.year||temp.month!=date2.month||temp.day!=date2.day){
                temp.addDays(1);
                D++;
            }
            return -D;
        }else {
            MyDate temp=new MyDate(date2.year,date2.month,date2.day);
            while (date1.year!=temp.year||date1.month!=temp.month||date1.day!=temp.day){
                temp.addDays(1);
                D++;
            }
            return D;
        }
    }
}
