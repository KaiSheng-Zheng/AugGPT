
import java.util.ArrayList;

public class MyDate{
    private int year;
    private int month;
    private int day;

    public int datenum=0;

    ArrayList<String> eventName;
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month=month;
        this.day = day;
    }

    public void addDays(int days) {
        this.day = this.day + days;
        while (true) {
            
            if ((this.month==1 ||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12)&&this.day<=31){
                break;
            }else if ((this.month==2 && isleap(this.year))&&this.day<=29){
                break;
            }else if ((this.month==2 && !isleap(this.year))&&this.day<=29){
                break;
            }else if ((this.month==4 ||this.month==6||this.month==9||this.month==11)&&this.day<=30){
                break;
            }



            
            if (this.month == 2) {
              
                if (isleap(this.year)) {
                    if (this.day > 29) {
                        this.month++;
                        this.day = this.day - 29;
                    }
                }
             
                else if (!isleap(this.year)) {
                    if (this.day > 28) {
                        this.month++;
                        this.day = this.day - 28;
                    }
                }
            }
          
            else if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
               
                if (this.month == 12 && this.day > 31) {
                    this.month = 1;
                    this.year++;
                    this.day = this.day - 31;
                }
                
                else if (this.day > 31) {
                    this.month++;
                    this.day = this.day - 31;
                }
            }
           
            else if (this.day > 30) {
                this.month++;
                this.day = this.day - 30;
            }
         
            else break;
        }
    }

    public String toString(){
        return String.format("%d-%02d-%02d",year,month,day);
    }

    public static int difference(MyDate date1, MyDate date2){
        int di_days =0;
        di_days = cau_difference(date1)-cau_difference(date2);
        return di_days;
    }
    public static int cau_difference(MyDate date){
        int year=date.year;
        int month = date.month;
        int day = date.day;
        int di_days = 0;
         
        for (int i = 1; i < month; i++) {
            if (i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                    di_days+=31;
                }
                else if (isleap(year) && i==2){
                    di_days+=29;
                }
                else if (!isleap(year)&&i==2) {
                    di_days+=28;
                }
                else {
                    di_days+=30;
                }
            }
            
            di_days+=day-1;
           
        for (int i = 0; i <year ; i++) {
            if (isleap(i)){
                di_days+=366;
            }
            else di_days+=365;
        }
        return di_days;
    }

    public static boolean isleap(int year){
        int isyearleap;
        isyearleap = year;
        return (isyearleap % 4 == 0 && isyearleap % 100 != 0) || isyearleap % 400 == 0;
        
    }

}
