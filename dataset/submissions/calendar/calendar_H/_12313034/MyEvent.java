public class MyEvent {
    private MyDate date;
    private String name;
    public MyEvent(MyDate date,String name){
        this.date = date;
        this.name = name;
    }
    public MyDate getDay() {
        return this.date;
    }

    public String getName(){
        return this.name;
    }

}
