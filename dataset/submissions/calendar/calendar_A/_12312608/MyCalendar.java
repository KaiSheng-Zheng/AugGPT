public class MyCalendar {
    private int cap,cnt;
    MyDate[] dt;String[] nam;
    public MyCalendar(int capacity){
        cap=capacity;cnt=0;dt=new MyDate[cap];nam=new String[cap];
    }
    public boolean addEvent(MyDate date, String eventName){
        if(cnt==cap)return false;
        dt[cnt]=date;nam[cnt]=eventName;++cnt;return true;
    }
    public String finishNextEvent(){
        if(cnt==0)return "NONE";
        int id=0;
        for(int i=0;i<cnt;++i){
            if(dt[id].equals(dt[i])){
                if(nam[id].compareTo(nam[i])>0)id=i;
            }
            else if(MyDate.gthan(dt[id],dt[i]))id=i;
        }
        String ans=nam[id];--cnt;
        for(int i=id;i<cnt;++i){nam[i]=nam[i+1];dt[i]=dt[i+1];}
        return ans;
    }
}
