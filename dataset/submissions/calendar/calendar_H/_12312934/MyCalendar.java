import java.util.ArrayList;

public class MyCalendar {
    private final int capacity;
    private int cnt=0;
    public MyCalendar(int capacity){
        this.capacity = capacity;
    }
    static class S{
        MyDate time;

        String thing;
        public S(MyDate time,String thing){
            this.thing = thing;
            this.time = time;
        }
    }
//    ArrayList<S> a = new ArrayList<S>();
//    public boolean addEvent(MyDate date, String eventName){
//        if(cnt>=capacity) return false;
//        cnt++;
//        S tmp = new S(date,eventName);
//        a.add(tmp);
//        System.out.println();
//        return true;
//    }
    ArrayList<MyDate> a = new ArrayList<MyDate>();
    ArrayList<String> b = new ArrayList<String>();
    public boolean addEvent(MyDate date, String eventName){
        if(cnt>=capacity) return false;
        cnt++;
        MyDate tmp = new MyDate(date);
        a.add(tmp);
        b.add(eventName);
        return true;
    }
    public String finishNextEvent(){
        if(a.size()==0){
            return String.format("NONE");
        }
        int id = 0;
        for(int i=1;i<a.size();++i){
            if(MyDate.bigger(a.get(id),a.get(i))){
                id = i;
            }
            else if(MyDate.Equal(a.get(id),a.get(i))){
                if(b.get(id).compareTo(b.get(i))>0){
                    id = i;
                }
            }
        }
        cnt--;
        a.remove(id);
        String ans = b.get(id);
        b.remove(id);
        return String.format("%s",ans);
}
//    public String finishNextEvent(){
//        if(a.size()==0){
//            return String.format("NONE");
//        }
//        S ans = a.get(0);
//        int id = 0;
//        for(int i=1;i<a.size();++i){
//            S tmp = a.get(i);
//            System.out.println(ans.time.toString()+" "+tmp.time.toString());
//            if(MyDate.bigger(ans.time,tmp.time)){
//                ans = tmp;
//                id = i;
//            }
//            else if(MyDate.Equal(ans.time,tmp.time)){
//                if(ans.thing.compareTo(tmp.thing)>0){
//                    ans = tmp;
//                    id = i;
//                }
//            }
//        }
//        a.remove(id);
//        return String.format("%s",ans.thing);
//    }
}
