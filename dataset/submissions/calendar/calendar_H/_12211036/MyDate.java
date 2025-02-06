public class MyDate {
    private int year;
    private int month;
    private int day;



    public MyDate(){

    }
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int DateNum(){
        int []yearday=new int[10000];
        for (int i = 0;i<10000;i++){
            if(i%400==0){
                yearday[i]=366;
            }else if(i%100==0){
                yearday[i]=365;
            } else if (i%4==0) {
                yearday[i]=366;
            }else {
                yearday[i] =365;
            }
            yearday[0]=366;
        }
        int []monthday= {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(yearday[year]==366){
            monthday[2]=29;
        }
        int datenum = day;
        for (int i = month-1;i>0;i--){
            datenum=datenum+monthday[i];
        }
        for (int i = year-1;i>=0;i--){
            datenum=datenum+yearday[i];
        }
        return datenum;
    }

    public void addDays(int days){
        int []yearday=new int[10000];
        for (int i = 0;i<10000;i++){
            if(i%400==0){
                yearday[i]=366;
            }else if(i%100==0){
                yearday[i]=365;
            } else if (i%4==0) {
                yearday[i]=366;
            }else {
                yearday[i] =365;
            }
            yearday[0]=366;
        }
        int []monthday= {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(yearday[year]==366){
            monthday[2]=29;
        }
        int datenum = day;
        for (int i = month-1;i>0;i--){
            datenum=datenum+monthday[i];
        }
        for (int i = year-1;i>=0;i--){
            datenum=datenum+yearday[i];
        }
        int datechange =datenum+days;
        int yearnow=0;
        int monthnow=1;
        int daynow=0;
        for (int i=datechange;datechange>0;){
            if(datechange>yearday[yearnow]){
                datechange=datechange-yearday[yearnow];
                yearnow++;
            }else if(datechange>monthday[monthnow]){
                datechange=datechange-monthday[monthnow];
                monthnow++;
            } else {
                daynow=datechange;
                datechange=0;
            }
        }
        year=yearnow;
        month=monthnow;
        day=daynow;
    }

    public String toString(){
        String yearString = String.format("%04d",year);
        String monthString = String.format("%02d",month);
        String dayString = String.format("%02d",day);
        String A = yearString+"-"+monthString+"-"+dayString;
        return A;
    }

    public static int difference(MyDate date1, MyDate date2){
        int chazhi = date1.DateNum()-date2.DateNum();
        return chazhi;
    }
}
