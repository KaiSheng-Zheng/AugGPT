import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.day=day;
        this.month=month;
    }
    public void addDays(int days){
        this.day+=days;
        int check=0;
        while (check==0){
            check=1;
        if(this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12){
            if(this.day>31){
                this.day=this.day-31;
                this.month++;
                check*=0;
            }else{
            }
        } else if (this.month==2) {
            if (this.year%4==0&&this.year%100!=0||this.year%400==0){
                if (this.day>29){
                    this.day=this.day-29;
                    this.month++;
                    check*=0;}
                }
            else{
                if (this.day>28){
                    this.day=this.day-28;
                    this.month++;
                    check*=0;
                }
            }
        }else if(this.month==4||this.month==6||this.month==9||this.month==11){
            if (this.day>30){
                this.day=this.day-30;
                this.month++;
                check*=0;
            }
        }
            else if (month>=12){
                    month=month-12;
                    year++;
                    check*=0;

        }
    }
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d",this.year,this.month,this.day);
    }
   public static int difference(MyDate date1, MyDate date2){
       LocalDate date10 = LocalDate.of(date1.year, date1.month, date1.day);
       LocalDate date20 = LocalDate.of(date2.year, date2.month, date2.day);
       int daysBetween = (int)ChronoUnit.DAYS.between(date20, date10);
       return daysBetween;
    }
}
