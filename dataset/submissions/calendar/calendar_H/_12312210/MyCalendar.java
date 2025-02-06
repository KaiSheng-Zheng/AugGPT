//package class_task_6;
public class MyCalendar {
    private int capacity;
    private int cnt=0,realcnt=0;
    private int inf=(1<<30);
    MyDate dates[]=new MyDate[505];
    String names[]=new String[505];
    int time[]=new int[505];
    int vis[]=new int[505];
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date,String eventName){
         realcnt++;
         cnt++;
         if(realcnt>capacity) {
             realcnt--;
             cnt--;
             return false;
         }
         dates[cnt]=date;
         names[cnt]=eventName;
         time[cnt]=MyDate.calculatedays(date);
         return true;
    }
    public String finishNextEvent(){
       int flag=0,maxdays=inf,pos=0;
       for(int i=1;i<=cnt;i++){
           if(vis[i]==1)continue;
           if(maxdays>MyDate.calculatedays(dates[i])){
               maxdays=MyDate.calculatedays(dates[i]);
               pos=i;
           }
           else{
               if(maxdays==time[i]){
                   if(names[pos].compareTo(names[i])>0){//judge
                       pos=i;
                   }
               }
           }
       }
       if(pos==0)return "NONE";
       else{
           vis[pos]=1;
           realcnt--;
           return names[pos];
       }
    }
}
