public class MyCalendar{
    private MyDate date[];
    private String name[];
    private boolean done[];
    private int count;

    public MyCalendar(int capacity){
        this.date = new MyDate[capacity];
        this.name = new String[capacity];
        this.done = new boolean[capacity];
        this.count=0;
    }

    public boolean addEvent(MyDate date, String eventName){
        if(this.count==this.date.length)return false;
        this.date[this.count] = date;
        this.name[this.count] = eventName;
        this.count++;
        return true;    
    }

    public String finishNextEvent(){
        if(this.count==0)return "NONE";
        int minIndex=0;
        for(int i=1;i<this.count;i++){
            if(this.date[i].getTimestamp()<this.date[minIndex].getTimestamp()||(this.date[i]==this.date[minIndex]&&this.name[i].compareTo(this.name[minIndex])<0))minIndex=i;
        }
        String ret = this.name[minIndex];
        this.done[minIndex]=true;
        for(int i=minIndex;i<this.count-1;i++){
            this.date[i]=this.date[i+1];
            this.name[i]=this.name[i+1];
            this.done[i]=this.done[i+1];
        }
        this.count--;
        return ret;
    }
}