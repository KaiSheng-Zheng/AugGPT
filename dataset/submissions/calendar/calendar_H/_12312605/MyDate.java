public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        boolean IfRun = false;
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            IfRun = true;
        }
        for (int i = 1; i <= days; i++) {

            if (day == Maxday(IfRun, month)) {
                day = 1;
                if (month == 12) {
                    month = 1;
                    year++;
                    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                        IfRun = true;
                    } else {
                        IfRun = false;
                    }
                } else {
                    month++;
                }
            } else {
                day++;
            }
        }
    }

    public String toString() {
        String year = Integer.toString(this.year);
        String month = Integer.toString(this.month);
        String day = Integer.toString(this.day);
        if (this.month < 10) {
            month = "0" + month;
        }
        if (this.day < 10) {
            day = "0" + day;
        }
        return year + "-" + month + "-" + day;
    }

    public static int difference(MyDate d1, MyDate d2) {
        int count;
        //System.out.println("!1 "+d1.toString());
        //System.out.println("!2 "+d2.toString());
        //System.out.println("111");
        if (d1.year < d2.year || (d1.year == d2.year && d1.month < d2.month) || (d1.year == d2.year && d1.month == d2.month && d1.day <= d2.day)) {
            count=0;
            MyDate D = new MyDate(d1.year,d1.month,d1.day);
            //MyDate D=d1;
            //System.out.println("222");
            while(true){
                if(D.year == d2.year && D.month == d2.month && D.day == d2.day){
                    break;
                }else{
                    D.addDays(1);
                    count++;
                }
                //System.out.println("444");
                //System.out.println("!!!"+count);
            }
            count=0-count;
        }else {
            count=0;
            MyDate D = new MyDate(d2.year,d2.month,d2.day);
            //MyDate D=d2;
            //System.out.println("333");
            while(true){
                if(d1.year == D.year && d1.month == D.month && d1.day == D.day){
                    break;
                }else{
                    D.addDays(1);
                    count++;
                }
            }

            //System.out.println("!3 "+d2.toString());
        }
        return count;
    }

    private int Maxday(boolean IfRun, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (IfRun == false) {
            return 28;
        } else {
            return 29;
        }
    }

    public int getYear(){
        return this.year;
    }
    public int getMonth(){
        return this.month;
    }
    public int getDay(){
        return this.day;
    }

}
