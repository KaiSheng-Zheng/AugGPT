import java.util.ArrayList;

public class MyDate {
    private int year;
    private  int month;
    private  int day;
    public int getYear(){
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
    int[] arr1=new int[13];
    int[] arr2=new int[13];
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;

        for(int i=1;i<8;i++){
            if(i%2==0&&i!=2) {
                arr1[i] = 30;
                arr2[i] = 30;
            }
            if(i%2!=0) {
                arr1[i] = 31;
                arr2[i] = 31;
            }if(i==2){
                arr1[i]=28;
                arr2[i]=29;
            }
        }
        for(int i=8;i<13;i++){
            if(i%2==0){
                arr1[i]=31;
                arr2[i]=31;
            }
            else {
                arr1[i]=30;
                arr2[i]=30;
            }
        }
    }
    public void  checkDate(int year,int month,int day){
                while (day>arr1[month]){
                    if(month==2) {
                        if(isLeapYear(year))
                            day-=arr2[2];
                        else day-=arr1[2];
                        month++;
                        continue;
                    }
                    day-=arr1[month];
                    month++;
                    if(month>12){
                        year++;
                        month-=12;
                    }
                }
        this.day=day;
        this.month=month;
        this.year=year;
    }




    public String toString(){
        String a,b;
        if(month<10){
            a="0"+month;
        }
        else{
            a=""+month;}
        if(day<10){
            b="0"+day;
        }else {
            b=String.valueOf(day);
        }
       return String.format("%d-%s-%s",year,a,b);
    }
    public void  addDays(int days){
        day+=days;
        checkDate(year,month,day);
    }
    public static int difference(MyDate date1,MyDate date2){
        return  date1.intoDays(date1.year, date1.month,date1.day)- date2.intoDays(date2.year, date2.month,date2.day);
         }



public boolean isLeapYear(int year){
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
}


public int intoDays(int year, int month,int day){
        MyDate test=new MyDate(year,month,day);
    int a ;
        if(test.isLeapYear(year)){
        a=( test.year/4-test.year/100+test.year/400-1)*366+(test.year-(test.year/4-test.year/100+test.year/400))*365;
        for(int j=1;j<month;j++){
            a+=arr2[j];
        }}
      else {
           a=( test.year/4-test.year/100+test.year/400)*366+(test.year-(test.year/4-test.year/100+test.year/400)-1)*365;
         for (int j=1;j<month;j++){
             a+=arr1[j];
         }
        }
        a+=day;
      return a;
}
}


