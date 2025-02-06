import java.util.*;
import java.util.Map;
public class MyCalendar {
     private int capacity;
     private int count=0;
     private static int count1=-1;
    TreeMap<MyDate,String> list=new TreeMap<>(new Comparator<MyDate>() {
        @Override
        public int compare(MyDate o1, MyDate o2) {
            if (o1.toString().compareTo(o2.toString())!=0){
                return o1.toString().compareTo(o2.toString());
            }
            return 1;
        }
    });

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName){
        if (count<capacity){
            list.put(date,eventName);
            count++;
            return true;
        }
        else {
            return false;
        }
    }
    public String finishNextEvent(){
        int i=0;
        MyDate[] md=new MyDate[list.size()];
        String[] s=new String[list.size()];
        Set<Map.Entry<MyDate, String>> set = list.entrySet();
        for (Map.Entry<MyDate, String> myDateStringEntry : set) {
            md[i]=myDateStringEntry.getKey();
            s[i]=myDateStringEntry.getValue();
            i++;
        }
        String temp;
        for (int k=0;k<md.length-1;k++) {
            for (int j = 0; j < md.length-1; j++) {
                if (md[j].equals(md[j+1])){
                    if (s[j].compareTo(s[j+1])>0){
                        temp=s[j];
                        s[j]=s[j+1];
                        s[j+1]=temp;
                    }
                }
            }
        }


        if(list.isEmpty()){
            return "NONE";
        }else {
            String temps;
            temps=s[0];
            list.clear();
            for (int n = 1; n < md.length; n++) {
                list.put(md[n],s[n]);
            }
            count--;
            return temps;
        }

        /*count1++;
        if (count1>= list.size()){
            count1--;
            return "NONE";
        }else {
            count--;
            return s[count1];
        }*/
    }
}
