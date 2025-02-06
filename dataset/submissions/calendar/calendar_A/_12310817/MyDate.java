public class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] daysOfMonths=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days){
        day+=days;
        while (day>daysOfMonths[month-1]||month>12){
            if((year%4==0&&year%100!=0)||year%400==0){
                daysOfMonths[1]=29;
            }
            else daysOfMonths[1]=28;
            if(day>daysOfMonths[month-1]){
                day-=daysOfMonths[month-1];
                month++;
            }
            if(month>12){
                year++;
                month-=12;
            }
        }
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public static int difference(MyDate date1, MyDate date2){
        int year1=date1.getYear();int year2=date2.getYear();
        int month1=date1.getMonth();int month2=date2.getMonth();
        int day1=date1.getDay();int day2=date2.getDay();
        int[] daysOfMonths=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int difference=0;
        if(year1>=year2){
            for(int i=0;i<year1-year2;i++){
                if(((year2+i)%4==0&&(year2+i)%100!=0)||(year2+i)%400==0){
                    difference+=366;
                }
                else difference+=365;
            }
            if(((year1)%4==0&&(year1)%100!=0)||(year1)%400==0){
                daysOfMonths[1]=29;
            }
            for(int i=0;i<month1-1;i++){
                day1+=daysOfMonths[i];
            }
            if(((year2)%4==0&&(year2)%100!=0)||(year2)%400==0){
                daysOfMonths[1]=29;
            }
            else{
                daysOfMonths[1]=28;
            }
            for(int i=0;i<month2-1;i++){
                day2+=daysOfMonths[i];
            }
            difference+=day1-day2;
        }
        else{
            for(int i=0;i>year1-year2;i--){
                if(((year2+i-1)%4==0&&(year2+i-1)%100!=0)||(year2+i-1)%400==0){
                    difference-=366;
                }
                else difference-=365;
            }
            if(((year1)%4==0&&(year1)%100!=0)||(year1)%400==0){
                daysOfMonths[1]=29;
            }
            for(int i=0;i<month1-1;i++){
                day1+=daysOfMonths[i];
            }
            if(((year2)%4==0&&(year2)%100!=0)||(year2)%400==0){
                daysOfMonths[1]=29;
            }
            else{
                daysOfMonths[1]=28;
            }
            for(int i=0;i<month2-1;i++){
                day2+=daysOfMonths[i];
            }
            difference+=day1-day2;
        }
        return difference;
    }
}
