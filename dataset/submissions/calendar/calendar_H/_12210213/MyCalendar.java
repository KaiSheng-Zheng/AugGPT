public class MyCalendar {
    private int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
          events=new String[capacity];
          Date=new MyDate[capacity];
    }
    String[] events;
    MyDate[] Date;

    private int count=0;

    public boolean addEvent(MyDate date, String eventName) {
        if (count<capacity) {
            events[count]=eventName;
            Date[count]=date;
            count++;
            return true;
        } else return false;
    }
    public int num=-1;
    public String finishNextEvent(){
        num++;
        for(int i=0;i<=capacity-1;i++) {
            for ( int j= 0; j <capacity-1-i; j++) {
                if ((MyDate.difference(Date[j], Date[j + 1]) >0 )|| (MyDate.difference(Date[j],Date[j+1])==0&&events[j].compareTo(events[j + 1]) > 0)){
                    String t;
                    MyDate date0;
                    t = events[j];date0=Date[j];
                    events[j] = events[j+1];Date[j]=Date[j+1];
                    events[j+1] = t;Date[j+1]=date0;
                }
            }
        }
        if(count>=num+1){
        return events[num];}
        else return "NONE";
    }
}