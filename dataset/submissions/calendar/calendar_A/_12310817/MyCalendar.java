public class MyCalendar {
    private int capacity;
    private int cnt=0;
    private MyDate[] date;
    private String[] eventName;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        date=new MyDate[capacity];
        eventName=new String[capacity];
    }
    public boolean addEvent(MyDate date, String eventName){
        cnt++;
        if(cnt>capacity){
            cnt--;
            return false;
        }
        else{
            this.date[cnt-1]=date;
            this.eventName[cnt-1]=eventName;
            MyDate d;String s;
            for(int i=0;i<cnt-1;i++){
                for(int j=0;j<cnt-1-i;j++){
                    if(MyDate.difference(this.date[j],this.date[j+1])>0){
                        d=this.date[j+1];
                        this.date[j+1]=this.date[j];
                        this.date[j]=d;
                        s=this.eventName[j+1];
                        this.eventName[j+1]=this.eventName[j];
                        this.eventName[j]=s;
                    }
                }
            }
            for(int i=0;i<cnt-1;i++){
                for(int j=0;j<cnt-1;j++){
                    if(MyDate.difference(this.date[j],this.date[j+1])==0){
                        if(this.eventName[j].compareTo(this.eventName[j+1])>0){
                            s=this.eventName[j+1];
                            this.eventName[j+1]=this.eventName[j];
                            this.eventName[j]=s;
                        }
                    }
                }
            }
            return true;
        }
    }
    public String finishNextEvent(){
        if(cnt==0){
            return "NONE";
        }
        String s=eventName[0];
        for(int i=0;i<cnt-1;i++){
            date[i]=date[i+1];
            eventName[i]=eventName[i+1];
        }
        cnt--;
        return s;
    }
}