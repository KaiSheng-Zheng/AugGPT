public class MyCalendar{
    int rl,c=0;

    public MyCalendar(int incapacity){
        rl=incapacity;
    }
    String []d=new String[1000];
    int[]f=new int[1000];
    public boolean addEvent(MyDate date, String eventName){
        date.event=eventName;
        int a= date.year*100+date.month;
        d[c]=eventName;
        f[c]=a;
        c+=1;
        if (c>rl) {
            return false;
        }else{return true;}
    }
    int g=-1;
    public String finishNextEvent(){
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<c-i;j++)
            {
                if(f[j]>f[j+1])
                {
                    int temp=f[j];
                    f[j]=f[j+1];
                    f[j+1]=temp;
                    String temp2=d[j];
                    d[j]=d[j+1];
                    d[j+1]=temp2;
                }
            }
        }
        g+=1;
        if (g>=c) {
            return "NONE";}
        else{return d[g];}
    }

}