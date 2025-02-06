import java.util.ArrayList;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private int totalDays = 0;
    ArrayList<String> Event = new ArrayList<>();
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month = month;
        this.day=day;
        for (int i=1582;i<this.year;i++){
            if ((i%4==0&&i%100!=0)||i%400==0){
                this.totalDays+=366;
            }else {
                this.totalDays+=365;
            }
        }
        for (int i=1;i<this.month;i++){
            if (i==1||i==3||i==5||i==7||i==8||i==10){
                this.totalDays+=31;
            }else if (i==4||i==6||i==9||i==11){
                this.totalDays+=30;
            }else if(i==2){
                if ((this.year%4==0&&this.year%100!=0)||this.year%400==0){
                    this.totalDays+=29;
                }else {
                    this.totalDays+=28;
                }
            }
        }
        this.totalDays+=this.day;
    }
    public void addDays(int days){
        this.totalDays+=days;
        for (int i = days;i>0;i--){
            this.day+=1;
            if (this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10){
                if (this.day>31){
                    this.month+=1;
                    this.day-=31;
                }
            }else if (this.month==4||this.month==6||this.month==9||this.month==11){
                if (this.day>30){
                    this.month+=1;
                    this.day-=30;
                }
            } else if (this.month==12) {
                if (this.day>31){
                    this.month=1;
                    this.year+=1;
                    this.day-=31;
                }
            } else{
                if ((this.year%4==0&&this.year%100!=0)||this.year%400==0){
                    if (this.day>29){
                        this.month+=1;
                        this.day-=29;
                    }
                }else {
                    if (this.day>28){
                        this.month+=1;
                        this.day-=28;
                    }
                }
            }
        }
    }
    public String toString(){
        return String.format("%d-%02d-%02d",this.year,this.month,this.day);
    }
    public static int difference(MyDate date1,MyDate date2){
        return (date1.totalDays - date2.totalDays);
    }

}