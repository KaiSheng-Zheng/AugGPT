import java.util.ArrayList;

public class MyCalendar {
    private int capacity=0;
    ArrayList <MyDate>time=new ArrayList<MyDate>();
    ArrayList<String> name=new ArrayList <String>();

    public MyCalendar(int capacity){
        this.capacity=capacity;
    }
    public boolean addEvent(MyDate date,String eventName){
        boolean f=false;
        if (time.size()<capacity){
            f=true;
            if (!time.isEmpty()){
                int x1=-1;
                int x2=-1;
                int position=-1;
                for (int i = 0; i < time.size(); i++) {
                    if (compare(time.get(i),date)==0){
                        x1=i;
                        break;
                    }
                }
                for (int i = time.size()-1; i >=0 ; i--) {
                    if (compare(time.get(i),date)==0){
                        x2=i;
                        break;

                    }
                }
                if (x1!=-1&&x2!=-1){
                    for (int i = x1; i <x2+1 ; i++) {
                        if (name.get(i).compareTo(eventName)>0){
                            position=i;
                            break;
                        }
                    }
                    if (position==-1){
                        position=x2+1;
                    }
                }
                if (position==-1){
                    for (int i = 0; i < time.size(); i++) {
                        if (compare(time.get(i),date)>0){
                            position=i;
                            break;
                        }
                    }
                    if (position==-1){
                        position=time.size();
                    }
                }
                time.add(position,date);
                name.add(position,eventName);

            }else {
                time.add(date);
                name.add(eventName);
            }
        }
        return f;

    }
    public String finishNextEvent(){
        String s="";
        if (time.isEmpty()){
            s="NONE";
        }else {
            s=name.get(0);
            time.remove(0);
            name.remove(0);
            
        }
        return s;
    }
    public int compare(MyDate date1,MyDate date2){
        int difference=0;
        if (date1.getYear()<date2.getYear()){
            difference=-1;
        } else if (date1.getYear()>date2.getYear()) {
            difference=1;
        }else {
            if (date1.getMonth()<date2.getMonth()){
                difference=-1;
            } else if (date1.getMonth()>date2.getMonth()) {
                difference=1;
            }else {
                if (date1.getDay()<date2.getDay()){
                    difference=-1;
                } else if (date1.getDay()>date2.getDay()) {
                    difference=1;
                }

            }

        }

        return difference;

    }
}