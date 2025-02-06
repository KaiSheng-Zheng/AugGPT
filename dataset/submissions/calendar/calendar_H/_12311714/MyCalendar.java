public class MyCalendar {
    private int capacity;
    private int cnt;
    private MyDate[] rq;
    private String[] name;
    private int now;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        cnt=0;now=0;
        rq=new MyDate[capacity+10];
        name=new String[capacity+10];
    }

    public boolean addEvent(MyDate date,String eventName){
        if(cnt==capacity)
            return false;
        rq[++cnt]=date;
        name[cnt]=eventName;
        return true;
    }

    private void refresh(){
        for(int i=1;i<=cnt;i++){
            for(int j=i+1;j<=cnt;j++){
                if(MyDate.dy(rq[i],rq[j])){
                    MyDate t=rq[i];
                    rq[i]=rq[j];
                    rq[j]=t;

                    String s=name[i];
                    name[i]=name[j];
                    name[j]=s;
                }
                else if(MyDate.equal(rq[i],rq[j])&&name[i].compareTo(name[j])>0){
                    String s=name[i];
                    name[i]=name[j];
                    name[j]=s;
                }
            }
        }
    }
    public String finishNextEvent(){
        refresh();
        if(cnt==0)
            return "NONE";
        String ans=name[1];
        for(int i=1;i<=cnt-1;i++){
            rq[i]=rq[i+1];
            name[i]=name[i+1];
        }
        cnt--;
        return ans;
    }
}
