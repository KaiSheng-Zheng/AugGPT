public class MyDate {
    private int year;
    private int month;
    private int date;
    public MyDate(int year, int month,int date){
        this.year=year;
        this.month=month;
        this.date=date;  }

    public void addDays(int days){
        int d=days+date;
       int []arrr=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
       if((year%4==0&&year%100!=0)||year%400==0){
           arrr[2]=29;
        }
       for(int i=1;i<month;i++){
            d+=arrr[i];
        }

       for( int l=year%4;d>365; l++){
          if(l%4==0&&(year%400==0||year%100!=0)) {
              if(d>366){
              year+=1;
              d-=366;}else{
                  break;
              }
          }
            else{
              year+=1;
              d-=365;}
           }

            int c=1;
        for(int i=1;d>arrr[i];c++,i++){
                 d-=arrr[i];}
        month=c;date=d;
        }

        public static int difference(MyDate date1,MyDate date2){
            String[]arr1 =date1.ss(date1);
            String[]arr2 =date2.ss(date2);
            int year01=Integer.parseInt(arr1[0]);
            int month01=Integer.parseInt(arr1[1]);
            int date01=Integer.parseInt(arr1[2]);

            int year02=Integer.parseInt(arr2[0]);
            int month02=Integer.parseInt(arr2[1]);
            int date02=Integer.parseInt(arr2[2]);
            
            int d01=date01;
            int []arrr01=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
            if((year01%4==0&&year01%100!=0)||year01%400==0){
                arrr01[2]=29;
            }
            for(int i=1;i<month01;i++){
                d01+=arrr01[i];
            }

            int d02=date02;
            int []arrr02=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
            if((year02%4==0&&year02%100!=0)||year02%400==0){
                arrr02[2]=29;
            }
            for(int i=1;i<month02;i++){
                d02+=arrr02[i];
            }
            int d=0;

            if(year01<year02){
                int y=year02-year01;
                for(int f=1;f<=y;f++){
                  if(year01%400==0||(year01%4==0&&year01%100!=0)){
                      d02+=366;
                      year01+=1;
                    }else{
                      d02+=365;
                      year01+=1;
                  }
                }
            }else{
                int y=year01-year02;
                for( int f=1;f<=y;f++){
                    if(year02%400==0||(year02%4==0&&year02%100!=0)){
                        d01+=366;
                        year02+=1;
                    }else{
                        d01+=365;
                        year02+=1;
                    }
                }
            }
            d=d01-d02;
        return d;
        }

    public String[] ss(MyDate dates){
       
        String s=year+"-"+month+"-"+date;
        String []arr=s.split("-");
        return arr;
    }

    public String toString(){
        String s="";
        if(month>=10&&date>=10){
            s=year+"-"+month+"-"+date;}
        else if(month<10&&date>=10){
            s=year+"-"+"0"+month+"-"+date;
        }else if(month>=10&&date<10){
            s=year+"-"+month+"-"+"0"+date;
        }else{
            s=year+"-"+"0"+month+"-"+"0"+date;
        }
        return s;
    }
}