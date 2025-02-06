public class MyDate {
    private int year;
    private int month;
    private int day;
    private static int board;
    private static int count=0;
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
private static int i=0;

    public void addDays(int days){

        while(i<=days-1){
            if(this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12){
                board=31;}
            else if(this.month==4||this.month==6||this.month==9||this.month==11){
                board=30;}
            else if((this.year%4==0&&this.year%100!=0)||this.year%400==0){
                board=29;}
            else board=28;
            if(this.day<board){
                this.day++;
            }else if(this.month<12){
                this.day=1;this.month++;
            }else {this.day=1;this.month=1;this.year++;}
            i++;
        }
    }



    public String toString(){
        String y,m,d;
         y=String.valueOf(this.year);
        if(this.month>=10){
             m=String.valueOf(this.month);}
        else { m="0"+String.valueOf(this.month);}
        if(this.day>=10){
             d=String.valueOf(this.day);
        }
        else{  d="0"+String.valueOf(this.day);}
        String z=y+"-"+m+"-"+d;
        return z;
    }

    public static int difference(MyDate date1,MyDate date2){
        int a1=date1.year;
        int a2=date1.month;
        int a3=date1.day;
        int a4=date2.year;
        int a5=date2.month;
        int a6=date2.day;
        if(a1<date2.year||(a1==date2.year&&a2<date2.month)||
                (a1==date2.year&&a2==date2.month&&a3<date2.day)){
            count=0;
            while(a1<date2.year||(a1==date2.year&&a2<date2.month)||
                    (a1==date2.year&&a2==date2.month&&a3<date2.day)) {
                if(a2==1||a2==3||a2==5||a2==7||a2==8||a2==10||a2==12){
                    board=31;
                }else if(a2==4||a2==6||a2==9||a2==11)
                    board=30;
                else if((a1%4==0&&a1%100!=0)||a1%400==0)
                    board=29;
                else board=28;
                if(a3<board){
                    a3++;}
                else if(a2<12){ a3=1;a2++;}
                 else {a3=1;a2=1;a1++;}
                 count--;
            }
        }
        else count=0;
            while(a4<date1.year||(a4==date1.year&&a5<date1.month)||
                (a4==date1.year&&a5==date1.month&&a6<date1.day)){
            if(a5==1||a5==3||a5==5||a5==7||a5==8||a5==10||a5==12){
                board=31;
            }else if(a5==4||a5==6||a5==9||a5==11)
                board=30;
            else if((a4%4==0&&a4%100!=0)||a4%400==0)
                board=29;
            else board=28;
            if(a6<board){
                a6++;}
            else if(a5<12){ a6=1;a5++;}
            else {a6=1;a5=1;a4++;}

            count++;

        }
        return count ;
    }

}
