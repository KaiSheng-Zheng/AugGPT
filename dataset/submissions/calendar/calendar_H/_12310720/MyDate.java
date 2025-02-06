public class MyDate {
    private int year;
    private int month;
    private int day;
    private int BM ;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public int calBM(){
        int total=0;
        for (int i=year-1; i > 0 ; i--) {
            if (i%4==0 && i%100 !=0){
                total = total+366;
            }else if (i%400==0){
                total = total+366;
            }else {
                total = total+365;
            }
        }
        for (int i = month-1; i >0 ; i--) {
            switch (i) {
                case 1, 12, 10, 8, 7, 5, 3 -> total = total + 31;
                case 2 -> {
                    if (year % 4 == 0 && year % 100 != 0) {
                        total = total + 29;
                    } else if (year % 400 == 0) {
                        total = total + 29;
                    } else {
                        total = total + 28;
                    }
                }
                case 4, 11, 9, 6 -> total = total + 30;
            }
        }
        total =total+day;
        return total;
    }
    public static MyDate analyzeBM(int total){
        int a=1;int b=1;int c;
        int future=total-365;
        for (int i=1; future > 0 ; i++) {
            if (i%4==0 && i%100 !=0){
                total = total-366;
            }else if (i%400==0){
                total = total-366;
            }else {
                total = total-365;
            }
            if (total<=800){
            if ((i+1)%4==0 && (i+1)%100 !=0){
                future = total-366;
            }else if ((i+1)%400==0){
                future = total-366;
            }else {
                future = total-365;
            }}
            a = i+1;
        }
        int lastone=total-31;
        for (int i = 1; lastone > 0 ; i++) {
            switch (i) {
                case 1 -> total = total - 31;
                case 2 -> {
                    if (a % 4 == 0 && a % 100 != 0) {
                        total = total - 29;
                    } else if (a % 400 == 0) {
                        total = total - 29;
                    } else {
                        total = total - 28;
                    }
                }
                case 3 -> total = total - 31;
                case 4 -> total = total - 30;
                case 5 -> total = total - 31;
                case 6 -> total = total - 30;
                case 7 -> total = total - 31;
                case 8 -> total = total - 31;
                case 9 -> total = total - 30;
                case 10 -> total = total - 31;
                case 11 -> total = total - 30;
                case 12 -> total = total - 31;
            }
            switch (i + 1) {
                case 1, 3, 5, 7, 8, 10, 12 -> lastone = total - 31;
                case 2 -> {
                    if (a % 4 == 0 && a % 100 != 0) {
                        lastone = total - 29;
                    } else if (a % 400 == 0) {
                        lastone = total - 29;
                    } else {
                        lastone = total - 28;
                    }
                }
                case 4, 6, 9, 11 -> lastone = total - 30;
            }
            b=i+1;
        }
        c =total;
        return new MyDate(a,b,c);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    public void call(){
        System.out.println(calBM());
    }
    public void addDays(int days){
        int now = calBM()+days;
         day= analyzeBM(now).getDay();
         month=analyzeBM(now).getMonth();
         year=analyzeBM(now).getYear();
        }
    public String toString(){
        if (month<10&&day<10){
        return year+"-0"+month+"-0"+day;} else if (month<10&&day>=10) {return year+"-0"+month+"-"+day;
        } else if (month>=10&&day<10) {return year+"-"+month+"-0"+day;

        } else if (month>=10&&day>=10) {return year+"-"+month+"-"+day;

        } else return year+"-"+month+"-"+day;
    }
    public static int difference(MyDate date1, MyDate date2){
        return date1.calBM()-date2.calBM();
    }
}