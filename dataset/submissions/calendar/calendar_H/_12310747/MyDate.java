public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days){
        for (int i = 0; i <days ; i++) {
            day++;
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day==32){
                        month+=1;
                        day=1;
                    }
                    break;
                case 2:
                    if (day==29&&!isRun(year)){
                        month+=1;
                        day=1;
                    } else if (day==30&&isRun(year)) {
                        month+=1;
                        day=1;
                    }
                    break;

                default:
                    if (day==31){
                        month+=1;
                        day=1;
                    }

            }
            if(month==13){
                year+=1;
                month=1;
            }
        }

    }
    public static boolean isRun(int year){
        boolean f=false;
        if ((year%4==0&&year%100!=0)||(year%400==0)){
            f=true;
        }
        return f;
    }
    public String toString(){
        String monthcopy=Integer.toString(month);
        if (monthcopy.length()==1){
            monthcopy="0"+monthcopy;
        }
        String daycopy=Integer.toString(day);
        if (daycopy.length()==1){
            daycopy="0"+daycopy;
        }
        return String.format("%d-%s-%s",year,monthcopy,daycopy);
    }
    public static int difference(MyDate date1,MyDate date2){
        int difference=0;
        if (date1.getYear()<date2.getYear()){
            difference=-1*(sumDays(date1,date2));
        } else if (date1.getYear()>date2.getYear()) {
            difference=(sumDays(date2,date1));
        }else {
            if (date1.getMonth()<date2.getMonth()){
                difference=-1*(sumDays(date1,date2));
            } else if (date1.getMonth()>date2.getMonth()) {
                difference=(sumDays(date2,date1));
            }else {
                if (date1.getDay()<date2.getDay()){
                    difference=-1*(sumDays(date1,date2));
                } else if (date1.getDay()>date2.getDay()) {
                    difference=(sumDays(date2,date1));
                }

            }

        }
        if (difference<0){
            difference++;
        } else if (difference>0) {
            difference--;
        }
        return difference;

    }

    public static int sumDays(MyDate date1,MyDate date2){
        int days=0;
        if (date1.getYear()==date2.getYear()){
            if (date1.getMonth()==date2.getMonth()){
                days=date2.getDay()-date1.getDay()+1;
            } else{
                days+=nowToEnd(date1);
                days+=beginToNow(date2);
                for (int i = (date1.getMonth()+1);
                     i <date2.getMonth() ; i++) {
                    days+=monthDays(i,date1.getYear());
                }
            }
        }else {
            days+=nowToEnd(date1);
            for (int i = (date1.getMonth()+1);
                 i <=12 ; i++) {
                days+=monthDays(i,date1.getYear());
            }
            for (int i = (date1.getYear()+1); i < date2.getYear(); i++) {
                days+=yearDays(i);
            }
            for (int i = 1;
                 i <date2.getMonth() ; i++) {
                days+=monthDays(i,date2.getYear());
            }
            days+=beginToNow(date2);

        }
        return days;
    }
    public static int yearDays(int year){
        if (isRun(year)){
            return 366;
        }else {
            return 365;
        }
    }
    public static int beginToNow(MyDate date){
        return date.getDay();
    }
    public static int nowToEnd(MyDate date){
        return monthDays(date)-date.getDay()+1;
    }
    public static int monthDays(MyDate date){
        int days=0;
        switch (date.getMonth()){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days=31;
                break;
            case 2:
                if (isRun(date.getYear())){
                    days=29;
                }else {
                    days=28;
                }
                break;
            default:
                days=30;
        }
        return days;
    }
    public static int monthDays(int month,int year){
        int days=0;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days=31;
                break;
            case 2:
                if (isRun(year)){
                    days=29;
                }else {
                    days=28;
                }
                break;
            default:
                days=30;
        }
        return days;
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



}