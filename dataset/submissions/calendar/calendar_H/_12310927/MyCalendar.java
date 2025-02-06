import java.util.ArrayList;
public class MyCalendar {
    private int capacity;
    protected int event=0;
    ArrayList<MyDate> EventDate=new ArrayList<MyDate>();
    ArrayList<String> EventName=new ArrayList<String>();
    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        boolean flag=false;
        if(event>=capacity){
            return false;
        }else{
            if(event==0){
                EventDate.add(date);
                EventName.add(eventName);
            }else {
                for(int i=0;i<event-1;i++){
                    if(MyDate.difference(EventDate.get(i),date)<0&&MyDate.difference(EventDate.get(i+1),date)>0){
                        EventDate.add(i+1,date);
                        EventName.add(i+1,eventName);
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    if(MyDate.difference(date,EventDate.get(0))<0){
                        EventDate.add(0,date);
                        EventName.add(0,eventName);
                        flag=true;
                    }else {
                        if(MyDate.difference(date,EventDate.get(event-1))>0){
                            EventDate.add(date);
                            EventName.add(eventName);
                            flag=true;
                        }
                    }
                }
                if(!flag){
                    for(int i=0;i<event-1;i++){
                        if(MyDate.difference(EventDate.get(i),date)==0){
                            if(EventName.get(i).compareTo(eventName)<0){
                                EventDate.add(i+1,date);
                                EventName.add(i+1,eventName);
                                break;
                            }else {
                                EventDate.add(i,date);
                                EventName.add(i,eventName);
                                break;
                            }
                        }
                    }
                    if(MyDate.difference(EventDate.get(event-1),date)==0){
                        if(EventName.get(event-1).compareTo(eventName)<0){
                            EventDate.add(date);
                            EventName.add(eventName);
                        }else {
                            EventDate.add(event-1,date);
                            EventName.add(event-1,eventName);
                        }
                    }
                }

            }
            event+=1;
            return true;
        }
    }
    public String finishNextEvent(){
        if(EventDate.size()==0){
            return String.format("NONE");
        }else {
            if(EventDate.size()==1){
                EventDate.clear();
                String ans=EventName.get(0);
                EventName.clear();
                event-=1;
                return ans;
            }else{
                int ans=0;
                for(int i=1;i<EventDate.size();i++){
                    if(MyDate.difference(EventDate.get(i),EventDate.get(ans))<0){
                        ans=i;
                    }else {
                        if(MyDate.difference(EventDate.get(i),EventDate.get(ans))==0){
                            char a=EventName.get(i).replaceAll("[^a-z^A-Z^0-9]","").charAt(0);
                            char b=EventName.get(ans).replaceAll("[^a-z^A-Z^0-9]","").charAt(0);
                            if(String.valueOf(a).compareTo(String.valueOf(b))<0){
                                ans=i;
                            }
                        }
                    }
                }
                String winner=EventName.get(ans);
                EventDate.remove(ans);
                EventName.remove(ans);
                event-=1;
                return winner;
            }
        }
    }

}