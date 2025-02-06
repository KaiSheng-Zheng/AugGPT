public class MyCalendar {
    private int capacity;
    private MyEvent[] Events;
    private int Index;
    public MyCalendar(int capacity){
        this.Index=0;
        this.capacity=capacity;
        this.Events=new MyEvent[capacity];
        for(int i=0;i<capacity;i++){
            this.Events[i]=new MyEvent("NONE",new MyDate(9999,12,31));
        }
    }
    private void Update(){
        for(int i=0;i<capacity-1;i++){
            for(int j=0;j<capacity-1;j++){
                if(MyDate.difference(this.Events[j].Date,this.Events[j+1].Date)>0){
                    MyEvent temp;
                    temp = this.Events[j];
                    this.Events[j]=this.Events[j+1];
                    this.Events[j+1]=temp;
                } else if (MyDate.difference(this.Events[j].Date,this.Events[j+1].Date)==0) {
                    boolean is_bigger=false;
                    for (int k=0;k<this.Events[j].Eventname.length()&&k<this.Events[j+1].Eventname.length();k++){
                        if((int)this.Events[j].Eventname.charAt(k)>(int)this.Events[j+1].Eventname.charAt(k)){
                            is_bigger=true;
                        }
                    }
                    if(is_bigger){
                        MyEvent temp;
                        temp = this.Events[j];
                        this.Events[j]=this.Events[j+1];
                        this.Events[j+1]=temp;
                    }
                }
            }
        }
    }
    public boolean addEvent(MyDate date, String eventName){
        if(Index==capacity){
            return false;
        }
        else {
            this.Events[capacity-1]=new MyEvent(eventName,date);
            this.Index++;
            Update();
            return true;
        }
    }
    public String finishNextEvent(){
        String temp;
        if (Events[0].Eventname!="NONE"){
            this.Index--;
            temp=Events[0].Eventname;
        }
        else {
            temp="NONE";
        }
        this.Events[0]=new MyEvent("NONE",new MyDate(9999,12,31));
        Update();
        return temp;
    }
}
