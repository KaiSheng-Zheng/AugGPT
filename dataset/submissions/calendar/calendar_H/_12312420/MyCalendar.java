public class MyCalendar {
    private int capacity,tot=0,cnt=0;

    private int[] v;
    private String[] day,event;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        day=new String[capacity+10];
        event=new String[capacity+10];
        v=new int[capacity+10];
    }
    public boolean addEvent(MyDate date, String eventName){
        if(cnt==capacity)return false;
        day[++tot]=date.toString();event[tot]=eventName;
        ++cnt;
        return true;
    }
    public String finishNextEvent(){
        if(cnt==0)return "NONE";
        int k;
        for(k=1;k<=tot;k++)
            if(v[k]==0)break;
        String res1=day[k],res2=event[k];
        int lst=k;
        for(int i=k+1;i<=tot;i++){
            if(v[i]>0)continue;
            if(res1.compareTo(day[i])>0){res1=day[i];res2=event[i];lst=i;}
            else if(res1.compareTo(day[i])==0&&res2.compareTo(event[i])>0){res2=event[i];lst=i;}
        }
        v[lst]=1;cnt--;
        return res2;
    }
}
