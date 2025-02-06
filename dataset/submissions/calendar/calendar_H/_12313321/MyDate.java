public class MyDate {
    private int year;
    private int month;
    private int day;

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public static int R(int y){
        if(y%400==0)
            return 1;
        else{
            if(y%4==0&&y%100!=0)
                return 1;
            else
                return 0;
        }
    }
    public static int daysInMonth(int year,int month){
        if(R(year)==1){
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
                return 31;
            else if(month==2)
                return 29;
            else
                return 30;
        }
        else{
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
                return 31;
            else if(month==2)
                return 28;
            else
                return 30;
        }
    }
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days){
        int totalDays=getDay()+days;
        while (true) {
            if (totalDays > daysInMonth(getYear(), getMonth())) {
                totalDays = totalDays - daysInMonth(getYear(), getMonth());
                setMonth(getMonth() + 1);
                if (getMonth() > 12) {
                    setMonth(1);
                    setYear(getYear() + 1);
                }
            }
            else {
                setDay(totalDays);
                break;
            }
        }
    }
    public String toString(){
        return String.format("%d-%02d-%02d",getYear(),getMonth(),getDay());
    }
    public static int difference(MyDate date1, MyDate date2){
        int days=0;
        if(date1.getYear()==date2.getYear()){
            if(date1.getMonth()==date2.getMonth()){
                days=date1.getDay()-date2.getDay();
            }
            else if(date1.getMonth()<date2.getMonth()){
                for(int counter=date1.getMonth();counter<date2.getMonth();counter++){
                    days=days+daysInMonth(date1.getYear(),counter);
                }
                days=-days+date1.getDay()-date2.getDay();
            }
            else {
                for(int counter=date2.getMonth();counter<date1.getMonth();counter++){
                    days=days+daysInMonth(date1.getYear(),counter);
                }
                days=days-date2.getDay()+date1.getDay();
            }
        }
        else if(date1.getYear()<date2.getYear()){
            for(int co=date1.getYear();co<date2.getYear();co++){
                for(int cou=1;cou<=12;cou++){
                    days=days+daysInMonth(co,cou);
                }
            }
            int days1=0;
            for(int cou1=1;cou1<date1.getMonth();cou1++){
                days1=days1+daysInMonth(date1.getYear(),cou1);
            }
            days1+=date1.getDay();
            int days2=0;
            for(int cou2=1;cou2<date2.getMonth();cou2++){
                days2=days2+daysInMonth(date2.getYear(),cou2);
            }
            days2=days2+date2.getDay();
            days=-days-days2+days1;
        }
        else{
            for(int co=date2.getYear();co<date1.getYear();co++){
                for(int cou=1;cou<=12;cou++){
                    days=days+daysInMonth(co,cou);
                }
            }
            int days1=0;
            for(int cou1=1;cou1<date2.getMonth();cou1++){
                days1=days1+daysInMonth(date2.getYear(),cou1);
            }
            days1+=date2.getDay();
            int days2=0;
            for(int cou2=1;cou2<date1.getMonth();cou2++){
                days2=days2+daysInMonth(date1.getYear(),cou2);
            }
            days2=days2+date1.getDay();
            days=days-days1+days2;
        }
        return days;
    }
}
