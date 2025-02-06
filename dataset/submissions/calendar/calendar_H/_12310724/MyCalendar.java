import java.util.ArrayList;

public class MyCalendar {
    public int capacity;

     ArrayList<MyDate> Date = new ArrayList<MyDate>();
     ArrayList<String> Name = new ArrayList<String>();
    public MyCalendar(int cap){
        capacity=cap;
    }
    public boolean addEvent(MyDate date,String eventname){
        if(Date.size()==capacity)   return false;
        Date.add(date);
        Name.add(eventname);
//        System.out.printf("%d\n",Date.size());
        return true;
    }
    public String finishNextEvent(){
//        System.out.println("????\n");
        if(Date.size()==0)  return "NONE";
        int loc=0;MyDate minn=Date.get(0);

        for(int i=1;i<Date.size();++i){
            MyDate tmp=Date.get(i);
            if(tmp.Compare(tmp,minn)){
               loc=i;minn=tmp;
            }
            else if(!tmp.Compare(tmp,minn)&&!tmp.Compare(minn,tmp)){
                String t1=Name.get(i),t2=Name.get(loc);
                if(t1.compareTo(t2)<0){
                    loc=i;minn=tmp;
                }
            }
        }
        String ans=Name.get(loc);
        Name.remove(loc);Date.remove(loc);
//        System.out.println(ans);
        return ans;
    }
}
