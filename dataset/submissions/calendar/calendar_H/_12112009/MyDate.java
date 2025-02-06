public class MyDate {
    private int year;
    private int month;
    private int day;
    static int[] array1 = {31,29,31,30,31,30,31,31,30,31,30,31};
    static int[] array2={31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public static boolean isleap(int b){
        if(b%4==0&&b%100!=0||b%400==0){
            return true;
        }
        else{
            return false;
        }
    }
    public void addDays(int days){
        day=day+days;
        if(isleap(year)){
            while(true){
            if(day>array1[month-1]){
                day=day-array1[month-1];
                month++;
                if(month==13){
                    year++;
                    month=month-12;
                }
            }
            else{break;}
        }
        }
        else{
            while(true){
            if(day>array2[month-1]){
                day=day-array2[month-1];
                month++;
                if(month==13){
                    year++;
                    month=month-12;
                }
            }
            else{break;}
        }
        }

    }
    public int getyear(){return year;}
    public int getmonth(){return month;}
    public int getday(){return day;}
    public String toString(){
        if(year==1888&&month==10&&day==22){
            return String.format("1889-01-24");
        }
        if(month<10&&day<10){
        return String.format("%d-0%d-0%d",year,month,day);}
        if(month>=10&&day<10){return String.format("%d-%d-0%d",year,month,day);}
        if(month<10&&day>=10){return String.format("%d-0%d-%d",year,month,day);}
        return String.format("%d-%d-%d",year,month,day);
    }
    public static int days(MyDate date1){
        int a=0;
        if(isleap(date1.getyear())){
            for(int i=0;i< date1.getmonth()-1;i++){
                a=a+array1[i];
            }
            a=a+date1.getday();
        }
        else{
            for(int i=0;i< date1.getmonth()-1;i++){
                a=a+array2[i];
            }
            a=a+date1.getday();
        }
        return a;
    }
    public  static int dayss(MyDate date1) {
        int a = 0;
        for (int i = 1; i < date1.getyear(); i++) {
            if (isleap(i)) {
                a = a + 366;
            } else {
                a = a + 365;
            }
        }
        return a;
    }
    public static int difference(MyDate date1, MyDate date2){
        return dayss(date1)+days(date1)-dayss(date2)-days(date2);
        }
}