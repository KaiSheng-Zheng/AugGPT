import java.util.ArrayList;
public class MyCalendar {
    int cap=0;
    public MyCalendar(int capacity){
        cap= capacity;
    }
    int c=0;int d=0;int q=0;
    ArrayList<MyDate> dates =new ArrayList<>() ;
    ArrayList<String>events=new ArrayList<>();
 boolean addEvent(MyDate date, String eventName){
            c++;
        if(c>cap){
            c--;
            return false;
        }
        else{
        if (c==1){
           dates.add(0,date);
            events.add(0,eventName);
            q++;
            return true;
        } else{
            int diff=0;
            for(int r=0;r<q;){
               diff = MyDate.difference(date,dates.get(r));
                if(diff>0){
                    if(r==q-1){
                        dates.add(q,date);
                        events.add(q,eventName);
                        q++;
                        return true;
                    }
                    r++;
                }
                else if(diff<0){
                    dates.add(r,date);
                    events.add(r,eventName);
                    q++;
                    return true;
                }else{
                  int dif=eventName.compareTo(events.get(r));
                  if(dif>0){
                      if(r==q-1){
                      events.add(q,eventName);
                      dates.add(q,date);
                      q++;
                      return true;}
                      r++;
                  }else {
                      events.add(r,eventName);
                      dates.add(r,date);
                      q++;
                      return true;
                  }
                }
            }
        }
            return true;}
      }

    public String finishNextEvent(){
     if(q==0){
         return"NONE";
     }else{
      String m=events.get(0);
      for(int t=0;t<q-1;t++){
          events.set(t,events.get(t+1));
          dates.set(t,dates.get(t+1));
      }
      events.remove(q-1);
      dates.remove(q-1);
      c--;q--;
return m;
     }
    }
}

