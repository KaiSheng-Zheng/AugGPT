public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    private boolean judge(){
        if(year % 400 == 0)
            return true;
        if(year % 4 == 0 && year % 100 != 0)
            return true;
        return false;
    }
    public void addDays(int days){
        int[] d = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while(days > 0){
            days--;
            if(this.month == 12 && this.day == 31){
                this.year++;
                this.month = 1;
                this.day = 1;
            }
            else{
                if(judge()){
                    d[2] = 29;
                }
                else{
                    d[2] = 28;
                }
                this.day++;
                if(this.day > d[this.month]){
                    this.day = 1;
                    this.month++;
                }
            }
        }
    }
    @Override
    public String toString(){
        String s1 = String.format("%d", this.year);
        String s2, s3;
        if(this.month >= 10)
            s2 = String.format("%d", this.month);
        else
            s2 = String.format("0%d", this.month);
        if(this.day >= 10)
            s3 = String.format("%d", this.day);
        else
            s3 = String.format("0%d", this.day);
        return s1 + "-" + s2 + "-" + s3;
    }
    public int getDayNumber(){
        int[] d = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(judge())
            d[2] = 29;
        int ans = 0;
        for(int i = 1; i < this.month; i++){
            ans += d[i];
        }
        ans += this.day;
        return ans;
    }
    public boolean LaterThan(MyDate x){
        if(this.year != x.year)
            return this.year > x.year;
        if(this.month != x.month)
            return this.month > x.month;
        return this.day > x.day;
    }
    public static int difference(MyDate date1, MyDate date2){
        int op = 1;
        if(date2.LaterThan(date1)){
            MyDate tmp = date1;
            date1 = date2;
            date2 = tmp;
            op = 0 - op;
        }
        int ans = 0;
        for(int i =  date2.year; i < date1.year; i++){
            ans += 365;
            if((i % 400 == 0) || (i % 4 == 0 && i % 100 != 0)) ans++;
        }
        ans = ans + date1.getDayNumber() - date2.getDayNumber();
        return op * ans;
    }
}
