public class MyDate {
    private int year;
    private int month;
    private int day;
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",getYear(),getMonth(),getDay());
    }
    public static int difference(MyDate date1, MyDate date2){
        int begin=Math.min(date1.getYear(),date2.getYear());
        int dayof1=0;
        for(int i=0;i<date1.getYear();i++){
            boolean de=(i%4==0&&i%100!=0)||(i%400==0);
            if(de)
                dayof1+=366;
            else
                dayof1+=365;
        }
            int [] mod=new int [12];
            mod[0]=31;
            mod[1]=28;
            mod[2]=31;
            mod[3]=30;
            mod[4]=31;
            mod[5]=30;
            mod[6]=31;
            mod[7]=31;
            mod[8]=30;
            mod[9]=31;
            mod[10]=30;
            mod[11]=31;
            boolean b1=(date1.getYear()%4==0&&date1.getYear()%100!=0)||(date1.getYear()%400==0);
            if(b1)
                mod[1]=29;
            for(int j=0;j<date1.getMonth()-1;j++){
                dayof1+=mod[j];
            }
            dayof1+=date1.getDay();
        int dayof2=0;
        for(int i=0;i<date2.getYear();i++){
            boolean de=(i%4==0&&i%100!=0)||(i%400==0);
            if(de)
                dayof2+=366;
            else
                dayof2+=365;
        }
        boolean b2=(date2.getYear()%4==0&&date2.getYear()%100!=0)||(date2.getYear()%400==0);
        if(b2)
            mod[1]=29;
        else
            mod[1]=28;
        for(int j=0;j<date2.getMonth()-1;j++){
            dayof2+=mod[j];
        }
        dayof2+=date2.getDay();
        return dayof1-dayof2;
    }
    public void addDays(int days){
        boolean de=(getYear()%4==0&&getYear()%100!=0)||(getYear()%400==0);
        int [] mmdd=new int [12];
        mmdd[0]=31;
        mmdd[1]=28;
        mmdd[2]=31;
        mmdd[3]=30;
        mmdd[4]=31;
        mmdd[5]=30;
        mmdd[6]=31;
        mmdd[7]=31;
        mmdd[8]=30;
        mmdd[9]=31;
        mmdd[10]=30;
        mmdd[11]=31;
        int yydd=365;
        if(de){
            yydd=366;
            mmdd[1]=29;
        }
        int ad=days;
        int doty=0;//days of this year
        for(int i=0;i<getMonth()-1;i++){
            doty+=mmdd[i];
        }
        doty+=getDay();
        ad=ad-(yydd-doty);//minus the initial year
        int y=getYear();
        if(ad>0) {//from year to minus
            while (ad > 0) {
                y++;
                de = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
                yydd = 365;
                mmdd[1] = 28;
                if (de) {
                    mmdd[1] = 29;
                    yydd = 366;
                }
                ad = ad - yydd;
            }
            setYear(y);
            ad = ad + yydd;
            int am = 0;
            while (ad > 0) {
                am++;
                ad -= mmdd[am - 1];
            }
            setMonth(am);
            setDay(ad+mmdd[am-1]);
        }else if(getDay()+days>mmdd[getMonth()-1]){//from month to minus
            int add=days;
            add=add-mmdd[getMonth()-1]+getDay();
            int gm=getMonth();
            while(add>0){
                gm++;
                add-=mmdd[gm-1];
            }
            setMonth(gm);
            setDay(add+mmdd[gm-1]);
        }else{
            setDay(getDay()+days);
        }

    }

}
