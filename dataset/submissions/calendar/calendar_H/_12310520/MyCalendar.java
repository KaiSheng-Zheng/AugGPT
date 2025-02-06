public class MyCalendar {
    public int capacity;
    public boolean[] state;
    public MyDate[] dat;
    public String[] name;
    public MyCalendar(int capacity){
        this.capacity=capacity;
        state =new boolean[capacity];
        dat=new MyDate[capacity];
        name=new String[capacity];
        this.setTrue();
    }
    public void setTrue(){
        for (int i = 0; i < capacity; i++) {
            state[i]=false;
        }
    }
    public boolean addEvent(MyDate date,String eventName){
        int findid=findNull();
        if(findid==-1)return false;
        if(findid>=0&&findid<capacity){
            dat[findid]=date;
            name[findid]=eventName;
            state[findid]=true;
        }
        return true;
    }
    public int findNull(){
        for (int i = 0; i < capacity; i++) {
            if(!state[i]){
                return i;
            }
        }
        return -1;
    }
    public int find(){
        int jl=-1;
        MyDate min=new MyDate(99999,12,31);
        String mz="zzzzzzzzz";
        for (int i = 0; i < capacity; i++) {
            if(state[i]){
                if(MyDate.difference(min,dat[i])>0||MyDate.difference(min,dat[i])==0&&mz.compareTo(name[i])>0){
                    min=dat[i];
                    mz=name[i];
                    jl=i;
                }
            }
        }
        if(jl!=-1)state[jl]=false;
        return jl;
    }
    public String finishNextEvent(){
        int jl=this.find();
        if(jl==-1){
            return "NONE";
        }else{
            state[jl]=false;
            return name[jl];
        }
    }
}
