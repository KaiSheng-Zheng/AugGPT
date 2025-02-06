import java.time.LocalDate;

public class MyCalendar {
    private final int  capacity;
    private String[] events;
    private MyDate[] dates;
    private int x=0;
    //private int y=0;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        this.events =new String[capacity];
        this.dates =new MyDate[capacity];
    }
    public boolean addEvent(MyDate date,String eventname){
        if (x<capacity){events[x]=eventname;dates[x]=date;x++;return true;}
        else {return false;}

    }
    public String finishNextEvent(){
        arrange();
        try{String mid= events[0];

            for(int i=0 ;i< events.length-1;i++){
               events[i]=events[i+1];
               dates[i]=dates[i+1];
            }
            events[events.length-1]=null;
            dates[dates.length-1]=null;
            x--;
            if(mid!=null){
            return mid;}
            else {return "NONE";}
        }catch (ArrayIndexOutOfBoundsException a){return "NONE";}
    }


    public void arrange(){MyDate useless =new MyDate(0,0,0);
        String uselessstring;
        for(int i =0;i<events.length-1;i++){
            for(int j=i+1;j< events.length;j++){
                if(dates[i]!=null&&dates[j]!=null){
                    LocalDate date1 = LocalDate.of(dates[i].getYear(),dates[i].getMonth(),dates[i].getDay());
                    LocalDate date2 = LocalDate.of(dates[j].getYear(),dates[j].getMonth(),dates[j].getDay());
                    if(date1.isAfter(date2)){useless=dates[i];dates[i]=dates[j];dates[j]=useless;
                        uselessstring=events[i];events[i]=events[j];events[j]=uselessstring;}
                    else if (date1.isEqual(date2)) {
                        int result = events[i].compareTo(events[j]);
                        if(result>0){useless=dates[i];dates[i]=dates[j];dates[j]=useless;
                            uselessstring=events[i];events[i]=events[j];events[j]=uselessstring;}
                    }
                 }
            }
        }
    }



}
