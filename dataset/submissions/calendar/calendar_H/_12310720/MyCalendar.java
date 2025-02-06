import java.util.ArrayList;

public class MyCalendar {
    final int capacity;
    ArrayList<MyDate> AM;
    ArrayList<String> AS;
    public MyCalendar(int capacity){
        this.capacity = capacity;
        AM=new ArrayList<>();
        AS=new ArrayList<>();
    }
    public boolean addEvent(MyDate date, String eventName){
        if (AS.size()+1<=capacity){
        AM.add(date);
        AS.add(eventName);
        return true;}
        else return false;
    }
    public String finishNextEvent(){
        if (!AS.isEmpty()){
        int theCAL=1000000000;
        String theName="1";
        int conter=0;
        for (int i = 0; i < AM.size(); i++) {
            if (AM.get(i).calBM()<theCAL){
                theCAL=AM.get(i).calBM();
                theName=AS.get(i);
                conter=i;
            }else if (AM.get(i).calBM()==theCAL){
                if (AS.get(i).compareTo(theName)<0){
                    theCAL=AM.get(i).calBM();
                    theName=AS.get(i);
                    conter=i;
                }
            }
        }
        AM.remove(conter);
        AS.remove(conter);
        return theName;}
        else return "NONE";
    }
}