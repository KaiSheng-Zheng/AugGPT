public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

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
    public int yearsToDay(int year){
        if ((year%4==0 && year%100!=0) || year%400==0){
            return 366;
        }else
            return 365;
    }
    public int monthsToDay(int year,int month){
        if ((year%4==0 && year%100!=0) || year%400==0) {
            if ((month <= 7 && month % 2 == 1) || (month > 7 && month %2 == 0)) {
                return 31;
            } else if (month == 2) {
                return 29;
            } else
                return 30;
        }else {
            if ((month<=7 && month%2==1)||(month>7 && month%2==0)){
                return 31;
            } else if (month==2) {
                return 28;
            }else
                return 30;
        }
    }

    public void addDays(int days){
        if (monthsToDay(this.year,this.month)-this.day<days){
            int restDays=days-monthsToDay(this.year,this.month)+this.day;
            int thisYearRestDay=yearsToDay(this.year);
            for (int i = 0; i <this.month ; i++) {
                thisYearRestDay-=monthsToDay(this.year,this.month-i);
            }
            int c1=0;
            int m=0;
            int m1=0;
            for (int j = 1; ; j++) {//month
                if (thisYearRestDay<restDays){
                    if (j==1){
                        int i;
                        int y=0;
                        for (i=1;;i++) {//year
                            this.year++;
                            y+=yearsToDay(this.year);
                            if (y>=restDays-thisYearRestDay){
                                c1=y;
                                break;
                            }
                        }
                    }
                    m+=monthsToDay(this.year,j);
                    if (m>=restDays-thisYearRestDay-c1+yearsToDay(this.year)){
                        this.month=j;
                        this.day=monthsToDay(this.year,j)-(m-(restDays-thisYearRestDay-c1+yearsToDay(this.year)));
                        break;
                    }
                }else {

                    int c=this.month;
                    m1+=monthsToDay(this.year,c+j);
                    if (m1>=restDays){
                        this.month=c+j;
                        this.day=monthsToDay(this.year,this.month)-(m1-restDays);
                        break;
                    }
                }

            }
        }else {
            this.day+=days;
        }

    }
    public String toString(){
        return String.format("%d-%02d-%02d",this.year,this.month,this.day);
    }
    public static int date(MyDate date1,MyDate date2){
        if (date1.getYear()>date2.getYear())
            return 1;
        else if (date1.getYear()==date2.getYear()){
            if (date1.month>date2.getMonth()){
                return 1;
            }else if (date1.month==date2.getMonth()){
                    if (date1.day>date2.day)
                        return 1;
                    else if (date1.day==date2.day) {
                        return 0;
                    }else
                        return -1;
            }else
                return -1;
        }else
            return -1;
    }
    public static int difference(MyDate date1,MyDate date2){
        if (date(date1,date2)>0){
            MyDate date=new MyDate(date2.year,date2.month,date2.day);
            for (int i = 1; ; i++) {
                date.addDays(1);
                if (date1.getDay()==date.getDay()&&date1.getMonth()==date.getMonth()&&date1.getYear()==date.getYear()){
                    return i;
                }
            }
        }else if (date(date1,date2)<0){
            MyDate date=new MyDate(date1.year,date1.month,date1.day);
            for (int i = 1; ; i++) {
                date.addDays(1);
                if (date.getDay()==date2.getDay()&&date.getMonth()==date2.getMonth()&&date.getYear()==date2.getYear()){
                    return -i;
                }
            }
        }else
            return 0;
    }
}
