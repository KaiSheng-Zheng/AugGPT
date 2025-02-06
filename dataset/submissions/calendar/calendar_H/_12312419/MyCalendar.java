

public class MyCalendar {
    private static int capacity;
    private Myevent[] events;
    private int i=0;
    private static int check[];

    public MyCalendar(int capacity){
        this.capacity=capacity;
        this.events=new Myevent[capacity];
        check=new int[capacity];
        for (int j=0;j<capacity;j++){
            check[j]=0;
        }
    }
    public boolean addEvent(MyDate date, String eventName){
        Myevent event=new Myevent(date,eventName);
        boolean succ=true;
        int c0=0;
        for (int j=0;j<capacity;j++){
            c0+=check[j];
        }
        if (c0==capacity) {succ=false;}
        else{
            for (int j=0;j<capacity;j++){
                if (check[j]==0){
                    events[j]=event;
                    check[j]=1;
                    i++;
                    succ=true;
                    break;
                }
            }
            Myevent t;
            for (int j=0;j<i-1;j++){
                for(int k=0;k<i-1;k++){
                    if (check[k+1]==0&&check[k]==1){
                        t=events[k+1];
                        events[k+1]=events[k];
                        events[k]=t;
                        check[k]=0;
                        check[k+1]=1;
                    }
                }
            }
        }
        return succ;
    }

    public String finishNextEvent(){
        Myevent t;
        String eve=null;
        if (i==0){
            eve="NONE";
        }else{
        for (int i=0;i<capacity;i++){
            if (events[i]==null){
                check[i]=0;
            }else {
            }
        }
        int ch0=0;
        for (int j=0;j<capacity;j++){
            ch0+=check[j];
        }
        if(ch0==0){
            eve="NONE";}
            else{
                int cnt=0;
            while (cnt < i && check[cnt]==0) {
                cnt++;
            }
                for (int j=cnt;j<i-1;j++){
                    for (int i=cnt;i<this.i-1;i++) {
                        if (MyDate.difference(events[i].getDate(),events[i+1].getDate())>0) {
                    t = events[i];
                    events[i]=events[i+1];
                    events[i+1]=t;
                } else if (MyDate.difference(events[i].getDate(),events[i+1].getDate())==0) {
                    if (events[i].getEvent().compareTo(events[i+1].getEvent())>0) {
                        t = events[i];
                        events[i]=events[i+1];
                        events[i+1]=t;
                    }
                }
            }
            }
            }
            for (int j=0;j<check.length;j++){
                if (check[j]==1){
                    eve=events[j].getEvent();
                    check[j]=0;
                    i--;
                    break;
                }
            }
        }
        return eve;
    }
}



