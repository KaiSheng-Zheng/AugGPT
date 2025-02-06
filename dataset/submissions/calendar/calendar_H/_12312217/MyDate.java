public class MyDate {
    private int year;
    private int month;
    private int day;
    public int i=0;
    private String[] event=new String[10000000];
    public MyDate(int year, int month, int day){
        this.year=year;
        this.day=day;
        this.month=month;
        this.i=0;
    }
    public void setEvent(String eventName){
        this.event[i]=eventName;
    }

    public String getEvent(int i){
        return this.event[i];
    }
    public int getYear(){
        return this.year;
    }
    public int getMonth(){
        return  this.month;
    }
    public int getDay(){
        return this.day;
    }
    //toString
    public String toString(){
        if(this.month<10&&this.day<10){
            return this.year+"-0"+this.month+"-0"+this.day;
        } else if (this.month<10&&day>9){
            return this.year+"-0"+this.month+"-"+this.day;
        }else if(this.month>=10&&this.day<10){
            return this.year+"-"+this.month+"-0"+this.day;
        }else{
            return this.year+"-"+this.month+"-"+this.day;
        }

    }
    public static int difference(MyDate date1, MyDate date2){
        int days1=0;
        for (int i = 1582; i < date1.year; i++) {
            if(date1.isLeapYear(i)){
                days1=days1+366;
            }else{
                days1=days1+365;
            }
        }
        for (int i = 1; i <date1.month; i++) {
            days1=days1+date1.DaysOfMonth(i,date1.year);
        }
        for (int i = 1; i <=date1.day ; i++) {
            days1++;
        }
        int days2=0;
        for (int i = 1582; i < date2.year; i++) {
            if(date2.isLeapYear(i)){
                days2=days2+366;
            }else{
                days2=days2+365;
            }
        }
        for (int i = 1; i <date2.month; i++) {
            days2=days2+date2.DaysOfMonth(i,date2.year);
        }
        for (int i = 1; i <=date2.day ; i++) {
            days2++;
        }
        int number=days1-days2;

        return number;
    }

    public void addDays(int days){
        if(days>=0){
            if(this.day+days<=DaysOfMonth(this.month,this.year)){
                this.day=this.day+days;
            } else if (this.day+days>DaysOfMonth(this.month,this.year)) {
                int addMonth=0;
                int addYear=0;
                int addMoreDays=this.day+days;
                while(addMoreDays>DaysOfMonth(this.month+addMonth,this.year+addYear)){
                    addMoreDays=addMoreDays-DaysOfMonth(this.month+addMonth,this.year+addYear);
                    addMonth++;
                    if(this.month+addMonth>12){
                        this.month=1;
                        addMonth=0;
                        addYear++;
                        this.year++;
                    }


                }
                this.month=this.month+addMonth;
                this.day=addMoreDays;
            }
        }else{
            if(this.day+days>0){
                this.day=this.day+days;
            } else if (this.day+days<=0) {
                int addMonth=0;
                int addYear=0;
                int addMoreDays=this.day+days;
                while(addMoreDays<=0){
                    addMoreDays=addMoreDays+this.day;
                    addMonth--;
                    this.day=DaysOfMonth(this.month+addMonth,this.year+addYear);
                    if(this.month+addMonth<=0){
                        this.month=12;
                        addMonth=0;
                        addYear--;
                        this.year--;
                    }


                }
                this.month=this.month+addMonth;
                this.day=addMoreDays;
            }
        }

    }
    public boolean isLeapYear(int year){
        if (year % 4 == 0) {
            if(year%100==0&&year%400!=0){
                return false;
            } else if (year%100==0&&year%400==0) {
                return true;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    private int DaysOfMonth(int month,int year){
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        } else if (month==4||month==6||month==9||month==11) {
            return 30;
        }else {
            if (year % 4 == 0) {
                if(year%100==0&&year%400!=0){
                    return 28;
                } else if (year%100==0&&year%400==0) {
                    return 29;
                }else{
                    return 29;
                }
            }else{
                return 28;
            }
        }
    }
    public int DayNumber(MyDate date1){
        int days1=0;
        for (int i = 1582; i < date1.year; i++) {
            if(date1.isLeapYear(i)){
                days1=days1+366;
            }else{
                days1=days1+365;
            }
        }
        for (int i = 1; i <date1.month; i++) {
            days1=days1+date1.DaysOfMonth(i,date1.year);
        }
        for (int i = 1; i <=date1.day ; i++) {
            days1++;
        }
        return days1;
    }
}
