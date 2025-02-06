public class MyCalendar{
    private static int capacity;
    private static int amounts = 0;

    private static Tasks[] tasks = new Tasks[100];

    public static Tasks[] getTasks() {
        return tasks;
    }

    public MyCalendar(int capacity)
    {
        MyCalendar.capacity = capacity;
        InitialArray();

    }
    public boolean addEvent(MyDate date, String eventName)
    {

        if(amounts<capacity)
        {
            tasks[amounts].setTask(eventName);
            tasks[amounts].setDate(date);
            amounts++;
            Sort();
            return true;
        }

        return false;
    }

    private void InitialArray() {
        for(int i =0;i<100;i++){
            tasks[i] = new Tasks();
        }
    }

    public static int getCapacity() {
        return capacity;
    }

    public void Sort() {
        for(int i =0;i<amounts-1;i++){
            for(int j =0;j<amounts-1;j++){
                if(MyDate.difference(tasks[i].date,tasks[i+1].date)<0||MyDate.difference(tasks[i].date,tasks[i+1].date)==0
                &&tasks[i+1].task.compareTo(tasks[i].task)<0)
                {
                    Tasks tasks1 = tasks[i];
                    tasks[i] = tasks[i+1];
                    tasks[i+1] = tasks1;
                }
            }
        }
        for(int i =0;i<amounts;i++){
            System.out.println(tasks[i]);
        }
        System.out.println();
    }


    public String finishNextEvent(){

        if(amounts>0||tasks[amounts].task==null)
        {
            amounts--;
            return tasks[amounts].task;
        }
        else
        {
            return "NONE";
        }
    }
}
class Tasks
{ MyDate date;
    String task;

    public MyDate getDate() {
        return date;
    }

    public String getTask() {
        return task;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public void setTask(String task) {
        this.task = task;
    }
    @Override
    public String toString(){
        return String.format("%s %s",date,task);
    }
}