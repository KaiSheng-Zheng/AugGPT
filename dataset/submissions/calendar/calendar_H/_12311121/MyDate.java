
public class MyDate {
    private int year;
    private int month;
    private int day;
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day){
        this.day=day;
        this.month=month;
        this.year=year;
    }


    final int[]EachMonth1={31,28,31,30,31,30,31,31,30,31,30,31};
    final int[]EachMonth2={31,29,31,30,31,30,31,31,30,31,30,31};
    boolean judge=true;
    public void addDays(int days){
        int n = 0;
        int day1=0;
        int day2=0;
        outer:
        while(judge) {
            if (((year % 4 == 0 && year % 100 != 0)||year%400==0)&&getMonth() <= 2) {
                if(n==0){
                     day1 = day + days;
                     day2 = 0;
                }

                    while (true) {
                        if (n == 0) {
                            day2 = day1 - EachMonth2[month - 1];
                        } else {
                            day2 = day2 - EachMonth2[month - 1];
                        }
                        month++;
                        if (day2 < 0) {
                            month--;
                            day = day2 + EachMonth2[month - 1];
                            if (day <= 0) {
                                day = day2 + EachMonth2[month - 2] + EachMonth2[month - 1];
                                month--;
                            }
                            judge = false;
                            break outer;
                        }
                        if (month > 12) {
                            month = 1;
                            year++;
                            n++;
                            break ;
                        }
                        n++;
                    }
                }
            else  {
                if(n==0){
                    day1 = day + days;
                    day2 = 0;
                }

                while (true) {
                    if (n == 0) {
                        day2 = day1 - EachMonth1[month - 1];
                    } else {
                        day2 = day2 - EachMonth1[month - 1];
                    }
                    month++;
                    if (day2 < 0) {
                        month--;
                        day = day2 + EachMonth1[month - 1];
                        if (day <= 0) {
                            day = day2 + EachMonth1[month - 2] + EachMonth1[month - 1];
                            month--;
                        }
                        judge=false;
                        break outer;
                    }
                    if (month > 12) {
                        month = 1;
                        year++;
                        n++;
                        break;
                    }
                    n++;
                }
            }
        }
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }

    public static int difference(MyDate date1, MyDate date2){
        final int[]EachMonth3={31,28,31,30,31,30,31,31,30,31,30,31};
        final int[]EachMonth4={31,29,31,30,31,30,31,31,30,31,30,31};
        int n =0;
        int date1day=0;
        int date2day=0;
        int differ=0;
        for(int i=0;i< Math.abs(date1.getYear()- date2.getYear());i++) {
            if ((Math.min(date1.getYear(), date2.getYear()) + i) % 4 == 0 && (Math.min(date1.getYear(), date2.getYear()) + i) % 100 != 0||(Math.min(date1.getYear(), date2.getYear()) + i)%400==0) {
                n++;
            }
        }
            if((date1.getYear()%4==0&&date1.getYear()%100!=0)||date1.getYear()%400==0){
                for(int j =1;j<date1.getMonth();j++){
                    date1day+=EachMonth4[j-1];
                }
                date1day+=date1.getDay();
            }else{
                for(int j =1;j<date1.getMonth();j++){
                    date1day+=EachMonth3[j-1];
                }
                date1day+=date1.getDay();
            }
            if((date2.getYear()%4==0&&date2.getYear()%100!=0)||date2.getYear()%400==0){
                for(int j =1;j<date2.getMonth();j++){
                    date2day+=EachMonth4[j-1];
                }
                date2day+=date2.getDay();
            }
            else{
                for(int j =1;j<date2.getMonth();j++){
                    date2day+=EachMonth3[j-1];
                }
                date2day+=date2.getDay();
            }
            if(date1.getYear()<date2.getYear()){
                differ=date1day-((date2.getYear()-date1.getYear())*365+n+date2day);
            } else if (date1.getYear()==date2.getYear()) {
                differ=date1day-date2day;
            }else if(date1.getYear()>date2.getYear()){
                differ=((date1.getYear()-date2.getYear())*365+n+date1day)-date2day;
            }
        return differ;
    }
}
/*MyDate.java
MyCalendar.java*/
