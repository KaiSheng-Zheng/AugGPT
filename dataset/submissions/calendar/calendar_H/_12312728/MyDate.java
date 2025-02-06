public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
        if  (month <= 0) {
            throw new RuntimeException();
        }
        if (day <= 0 ) {
            throw new RuntimeException();
        }
    }
    private int monthToDay(int month){
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        }
        if(month==2){
            if (this.leapYear(this.year))return 29;
            else return 28;
        }
        if(month==4||month==6||month==9||month==11){
            return 30;
        }
        throw new RuntimeException();
    }

    private boolean leapYear(int year){
        return year%4==0&&(year%100!=0||year%400==0);
    }
    public int toNumber() {
        int number=this.day;
        for(int i=this.month-1;i>0;i--){
            number+=this.monthToDay(i);
        }
        for (int i=this.year-1;i>0;i--){
            number+=this.leapYear(i)?366:365;
        }
        return number;
    }
    public void addDays(int days){
        this.day+=days;
        while (this.day>=this.monthToDay(this.month)+1){
            day-=this.monthToDay(this.month);
            this.month++;
            if (this.month==13){
                this.month=1;
                this.year++;
            }
        }
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1,MyDate date2){
        return date1.toNumber()-date2.toNumber();
    }
}