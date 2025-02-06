import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class MyCalendar {
    int limit;
    ArrayList <String> Date=new ArrayList<>();
    ArrayList <String> Event=new ArrayList<>();
    public MyCalendar(int capacity){
        limit=capacity;

    }
    public boolean addEvent(MyDate date ,String eventName){

        String str1=date.toString();
        Date.add(str1);
        Event.add(eventName);
        int length = Date.size();

        if (length> limit ){
            return false;
        }else{
            return true;
        }
    }
    public static int dateSum(String date){
        int daysum1=0;
        String [] a1=date.split("-");
        int[] x={0,31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i = 1; i< Integer.parseInt(a1[0]); i++){
            if(i%4==0&& i%100!=0 || i%400==0){
                daysum1+=366;
            }else{
                daysum1+=365;
            }
        }
        if(Integer.parseInt(a1[0])%4==0&&Integer.parseInt(a1[0])%100!=0 ||Integer.parseInt(a1[0])%400==0){
            x[2]=29;
        }
        for(int i=1;i<Integer.parseInt(a1[1]);i++){

            daysum1+=x[i];
        }
        daysum1+=Integer.parseInt(a1[2]);
        return daysum1;
    }
    public String finishNextEvent(){
        int [][]Date1=new int[1][];
        for (int i = 0; i < Date.size(); i++) {
            Date1[0][i]=dateSum(Date.get(i));
        }
        ArrayList<String>eventnew = new ArrayList<>();
        int min = Date1[0][0];
        int count=0;
        for (int i = 1; i < Date.size(); i++) {
            min = Math.min(min, Date1[0][i]);
            count++;
        }
        for (int i = 0; i < Date.size(); i++) {
            if (Date1[0][i]==Date1[0][count]){
                eventnew.add(Event.get(i));
            }
        }
        Collections.sort(eventnew);
        for (int i = 0; i <Date.size(); i++) {
            if (Objects.equals(Event.get(i), eventnew.get(1))){
                Event.remove(i);
            }
        }
        if (Event == null) {
            return "None";
        }else return eventnew.get(1);
    }
}
