public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addDays(int dayplus){
        int days = days( year,  month,  day);
        int y = this.year;

        days += dayplus;

        int year1;
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
            year1 = 366;
        } else {
            year1 = 365;
        }
        while(days > year1) {
            days -= year1;
            y++;
            if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
                year1 = 366;
            } else {
                year1 = 365;
            }
        }

            year = y;

            int m = 1;


            int[] monthday = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int[] monthday1 = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
                for (int i = 0; i < 12; i++) {
                    if( (days - monthday1[i])  > 0 ){
                        m++;
                        days -= monthday1[i];
                    }else{
                        break;
                    }
                }
            } else {
                for (int i = 0; i < 12; i++) {
                    if( (days - monthday[i])  > 0 ){
                        m++;
                        days -= monthday[i];
                    }else{
                        break;
                    }
                }

            }

//            setMonth(m);;
//            setDay(days);

//        System.out.println("M"+m);
//        System.out.println("D"+days);
        this.setMonth(m);
        this.setDay(days);
        month = m;
        day = days;
    }







    @Override
    public String toString(){
        return String.format("%04d-%02d-%02d",getYear(),getMonth(),getDay());
//        2023-02-01
    }

    public static int difference(MyDate date1, MyDate date2){
        int days = 0;
        int max;
        int min ;

        if(date1.getYear() > date2.getYear()){
            max = date1.getYear() ;
            min =  date2.getYear();
        }else {
            max =  date2.getYear();
            min = date1.getYear() ;
        }
        if (date1.getYear() != date2.getYear()) {
            for (int i = min ; i < max; i++) {

                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    days += 366;
                } else {
                    days += 365;
                }
            }
        }

        int starday = days(date1.getYear(), date1.getMonth(), date1.getDay());

        int endday = days(date2.getYear(), date2.getMonth(), date2.getDay());

        if (date1.getYear() <date2.getYear() ){
            days = days - starday + endday;}
            else if ( date1.getMonth() <= date2.getMonth() ){
                days = days - starday + endday;}
                else if ( date1.getDay() <=date2.getDay()){
                    days = days - starday + endday;
                } else {
                    days = -(days - starday + endday);
                }
        days = -days;

        return days;
    }

    public static int days(int year, int month, int day) {
        int days = 0;
        int nowyear = year;
        int[] monthday = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] monthday1 = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean flag = true;
        if (nowyear % 4 == 0 && nowyear % 100 != 0 || nowyear % 400 == 0) {
        } else {
            flag = false;
        }
        for (int i = 0; i < month; i++) {
            if (flag) {
                days += monthday1[i];
            } else {
                days += monthday[i];
            }
        }
        days += day;
        return days;

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


}
