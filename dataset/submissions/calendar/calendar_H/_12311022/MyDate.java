
import java.util.Arrays;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public int length;
    private int runTimeSet;

    public String[] eventName=new String[9];
    public String getEventName(int things) {
        return eventName[things];
    }
    public void upEventName(){
        runTimeSet++;
    }


    public void assortEvent(){
        Arrays.sort(eventName, (o1,o2) -> (o1).compareTo((o2)));
    }

    public void setEventName(String eventName) {
        this.eventName[runTimeSet] = eventName;
    }
    public int eventNumber;
    public void eventNumber(){
        eventNumber++;
    }
    public void getSet0(){
        runTimeSet=0;
    }
    public void getEventNumber0(){
        eventNumber=0;
    }
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }



    public int getDay() {
        return day;
    }


    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
        int[][] monthNumber={{31},{28},{31},{30},{31},{30},{31},{31},{30},{31},{30},{31}};
        int totalDay=year*365+ day;
        for(int i=0;i<month;i++){
            totalDay+=monthNumber[i][0];
        }
        for(int i=0;i<year;i++){
            if(i%4==0 && i%100!=0 || i%400==0){
                totalDay++;
            }
        }
        this.length=totalDay;
    }

    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public void addDays(int days){
        int[][] monthNumber={{31},{28},{31},{30},{31},{30},{31},{31},{30},{31},{30},{31}};
        while(true){
            int dayHave=dateLength(year,month,day);
            int dayWill=dateLength(year,12,31);
            int totalDay1=dayWill-dayHave;
            if(days<=totalDay1){
                for(int i=1;i<=days;i++){
                    day++;
                    if(year%4==0 && year%100!=0 || year%400==0){
                        int[][] monthNumber1={{31},{29},{31},{30},{31},{30},{31},{31},{30},{31},{30},{31}};
                        if(day==monthNumber1[month-1][0]+1){
                            day=1;
                            month++;
                        }
                    }
                    else{
                        if(day==monthNumber[month-1][0]+1){
                            day=1;
                            month++;
                        }
                    }
                }
                break;
            }
            else{
                year++;
                month=1;
                day=1;
                days-=(dateLength(year+1,1,1)-dateLength(year,month,day));
            }
        }
    }

    public int dateLength(int year,int month,int day){
        int[][] monthNumber={{31},{28},{31},{30},{31},{30},{31},{31},{30},{31},{30},{31}};
        int totalDay=year*365+ day;
        for(int i=0;i<month;i++){
            totalDay+=monthNumber[i][0];
        }
        for(int i=0;i<year;i++){
            if(i%4==0 && i%100!=0 || i%400==0){
                totalDay++;
            }
        }
        return totalDay;
    }

    public static int difference(MyDate date1,MyDate date2){

        int totalDay1=date1.year*365+ date1.day;

        for(int i=0;i<date1.month-1;i++){
            if(date1.year%4==0 && date1.year%100!=0 || date1.year%400==0){
                int[][] monthNumber={{31},{29},{31},{30},{31},{30},{31},{31},{30},{31},{30},{31}};
                totalDay1+=monthNumber[i][0];
            }
            else {
                int[][] monthNumber = {{31}, {28}, {31}, {30}, {31}, {30}, {31}, {31}, {30}, {31}, {30}, {31}};
                totalDay1+=monthNumber[i][0];
            }
        }
        for(int i=0;i<date1.year;i++){
            if(i%4==0 && i%100!=0 || i%400==0){
                totalDay1++;
            }
        }

        int totalDay2=date2.year*365+ date2.day;
        for(int i=0;i<date2.month-1;i++){
            if(date2.year%4==0 && date2.year%100!=0 || date2.year%400==0){
                int[][] monthNumber={{31},{29},{31},{30},{31},{30},{31},{31},{30},{31},{30},{31}};
                totalDay2+=monthNumber[i][0];
            }
            else {
                int[][] monthNumber = {{31}, {28}, {31}, {30}, {31}, {30}, {31}, {31}, {30}, {31}, {30}, {31}};
                totalDay2+=monthNumber[i][0];
            }

        }
        for(int i=0;i<date2.year;i++){
            if(i%4==0 && i%100!=0 || i%400==0){
                totalDay2++;
            }
        }
        return totalDay1-totalDay2;
    }


}
