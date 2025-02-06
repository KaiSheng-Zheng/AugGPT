public class MyCalendar {
    private int capacity;
    private int count=0;
    private MyDate[] Date;
    private String[] event;
    private int a=-1;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        this.Date=new MyDate[capacity];
        this.event=new String[capacity];
    }
    public boolean addEvent(MyDate date, String eventName){
        if (count <=capacity-1) {
            Date[count]=date;
            event[count]=eventName;
            count++;
            return true;
        }else {
            for (int i=0;i<capacity-1;i++) {
                for (int j=0;j<capacity-i-1;j++){
                    if ((Date[j]==Date[j+1]&&event[j].compareTo(event[j+1])>0)||late(Date[j], Date[j + 1])){
                        String temp=event[j];
                        event[j]=event[j+1];
                        event[j+1]=temp;
                        MyDate tem=Date[j];
                        Date[j]=Date[j+1];
                        Date[j+1]=tem;
                    }
                }
            }
            return false;
        }
    }
    public boolean late(MyDate date1,MyDate date2){
        if (date1.getYear()>date2.getYear()){
            return true;
        }else if (date1.getYear()< date2.getYear()){
            return false;
        }else if (date1.getMonth()>date2.getMonth()){
            return true;
        }else if (date1.getMonth()<date2.getMonth()){
            return false;
        }else return date1.getDay() > date2.getDay();
    }
    public String finishNextEvent(){
        if (a<capacity-1) {
            a++;
            return event[a];
        }else return "NONE";
    }
}