public class MyCalendar {
    private int capacity;
    private int sum=0;
    private MyDate[] date;
    private String[] eventname;
    private int[] Heap;
    private int t=0;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        date=new MyDate[capacity+10000];
        eventname=new String[capacity+10000];
        Heap=new int[capacity+10000];
    }
    public boolean addEvent(MyDate date,String eventname){
        if (t<capacity){
            this.date[++sum]=date;
            this.eventname[sum]=eventname;
            Heap_Insert(sum);
            return true;
        }
        return false;
    }
    public String finishNextEvent(){
        if (t==0) return "NONE";
        int id=Heap_Pop();
        return eventname[id];
    }
    private void Heap_Insert(int id){
        Heap[++t]=id;
        int now=t;
        while(now>1){
            int mid=now>>1;
            int flag=MyDate.difference(date[Heap[now]],date[Heap[mid]]);
            if (flag>0||(flag==0&&eventname[Heap[mid]].compareTo(eventname[Heap[now]])<=0)) break;
            int temp=Heap[mid];Heap[mid]=Heap[now];Heap[now]=temp;
            now>>=1;
        }
    }
    private int Heap_Pop(){
        int now=1,id=Heap[1];
        Heap[1]=Heap[t];t--;
        while((now<<1)<=t){
            int ls=now<<1,rs=now<<1|1;
            if (rs>t){
                int flag=MyDate.difference(date[Heap[ls]],date[Heap[now]]);
                if (flag<0||(flag==0&&eventname[Heap[ls]].compareTo(eventname[Heap[now]])<0)){
                    int tmp=Heap[now];
                    Heap[now]=Heap[ls];
                    Heap[ls]=tmp;
                }
                break;
            }
            int flag=MyDate.difference(date[Heap[ls]],date[Heap[rs]]);
            if (flag<0||(flag==0&&eventname[Heap[ls]].compareTo(eventname[Heap[rs]])<0)){
                flag=MyDate.difference(date[Heap[ls]],date[Heap[now]]);
                if (flag<0||(flag==0&&eventname[Heap[ls]].compareTo(eventname[Heap[now]])<0)){
                    int tmp=Heap[now];
                    Heap[now]=Heap[ls];
                    Heap[ls]=tmp;
                }
                now=ls;
            }
            else{
                flag=MyDate.difference(date[Heap[rs]],date[Heap[now]]);
                if (flag<0||(flag==0&&eventname[Heap[rs]].compareTo(eventname[Heap[now]])<0)){
                    int tmp=Heap[now];
                    Heap[now]=Heap[rs];
                    Heap[rs]=tmp;
                }
                now=rs;
            }
        }
        return id;
    }
}
