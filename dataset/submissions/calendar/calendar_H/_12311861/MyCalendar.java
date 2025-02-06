import java.util.HashSet;

class MyCalendar{
    private int cap;
    HashSet<da> lis=new HashSet<>(cap);

    public MyCalendar(int capacity){
        cap=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        if(lis.size()>=cap){
            return false;
        }else{
            date.setNam(eventName);
            da dd=new da(date.tonum(),eventName);
            lis.add(dd);
        }
        return true;
    }
    public String finishNextEvent(){
        if(lis.size()<=0){
            return "NONE";
        }
        int yy= -1;
        String ans="..";
        for(da i:lis){
            if((yy>i.getTi())||yy==-1){
                yy=i.getTi();
            }
        }
        da del=new da(0,"..");
        for(da i:lis){
            if(yy>=i.getTi()){
                String yyy=i.getStr();
                if((ans.compareTo(yyy) > 0) || ans.equals("..")){
                    ans=yyy;del=i;
                }
            }
        }
        lis.remove(del);
        return ans;
    }
}
class da{
    public int ti;
    public String str;
    public da(int a,String b){
        ti=a;
        str=b;
    }
    public int getTi(){
        return ti;
    }
    public String getStr(){
        return str;
    }
}