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
        while(days!=0) {
            int[] m={31,28,31,30,31,30,31,31,30,31,30,31};
            if(year%4==0&year%100!=0|year%400==0){
                m[1]=29;
            }
            if (days > m[month-1] - day) {
                month =month%12+1;
                if(month==1){
                    year+=1;
                }
                days -= m[month-1] - day;
                day=0;
            }else{
                day+=days;
                days=0;
            }
        }
    }
    public String toString(){
        String a;
        if(month<10&day<10){
            a= year + "-0" + month + "-0" + day;
        }else if(month<10&day>=10){
            a= year + "-0" + month + '-' + day;
        }else if(day<10){
            a= year + '-' + month + "-0" + day;
        }else{
            a= String.valueOf(year)+'-'+month+'-'+day;
        }
        return a;
    }
    public static int difference(MyDate date1, MyDate date2) {
        int num1=0;
        int num2=0;
        int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i=0;i<date1.year;i++){
            if(i%4==0&i%100!=0|i%400==0){
                num1+=366;
            }else{
                num1+=365;
            }
        }
        if(date1.year%4==0&date1.year%100!=0|date1.year%400==0){
            m[1]=29;
            }
            for (int i = 0; i < date1.month - 1; i++) {
                num1 += m[i];
            }
            num1+=date1.day;
        for(int i=0;i<date2.year;i++){
            if(i%4==0&i%100!=0|i%400==0){
                num2+=366;
            }else{
                num2+=365;
            }
        }
        m[1]=28;
        if(date2.year%4==0&date2.year%100!=0|date2.year%400==0){
            m[1]=29;
        }
        for (int i = 0; i < date2.month - 1; i++) {
            num2 += m[i];
        }
        num2+=date2.day;
        return num1-num2;
    }
}