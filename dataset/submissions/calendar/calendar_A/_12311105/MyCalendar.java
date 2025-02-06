public class MyCalendar {
    private  int capacity;
    MyDate[]Date;
    String[]EventName;
    public MyCalendar(int capacity){
        this.capacity =capacity;
        this.Date=new MyDate[capacity];
        this.EventName=new String[capacity];
    }
    public boolean addEvent(MyDate date, String eventName){
        boolean a=false;
        for(int i=0;i<capacity;i++){
            if(EventName[i]==null){
                Date[i]=date;
                EventName[i]=eventName;
                a=true;
                break;
            }
        }return a;
    }
    public String finishNextEvent() {
        int num = 0;
        String a = "NONE";
        for(int i=0;i<capacity-1;i++){
            if(Date[i]==null){
                num=i+1;
            }else break;
        }if(Date[num]==null){
            num+=1;
        }
        for (int i = num+1; i < capacity; i++) {
            if(i>=capacity)break;
            if(Date[i]==null)continue;
            if(MyDate.difference(Date[num],Date[i])>0){
                num=i;
            }else if(MyDate.difference(Date[num],Date[i])==0){
                if(EventName[num].compareTo(EventName[i])>0){
                    num=i;
                }
            }
        }if(num!=capacity){
            a=EventName[num];
            EventName[num]=null;
            Date[num]=null;
        }
        return a;
    }
}