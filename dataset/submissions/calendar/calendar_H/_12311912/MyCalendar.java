public class MyCalendar
{
    private String[] name;
    private MyDate[] date;
    private boolean[] finished;
    private int count = 0;
    private int capacity;
    public MyCalendar(int capacity)
    {
        this.capacity = capacity;
        name = new String[capacity + 1];
        date = new MyDate[capacity + 1];
        finished = new boolean[capacity + 1];
    }
    public boolean addEvent(MyDate date, String eventName)
    {
        if (count + 1 > capacity)
            return false;
        else
        {
            count++;
            this.name[count] = eventName;
            this.date[count] = date;
            this.finished[count] = false;
            resorts();
            return true;
        }
    }
    public void resorts()
    {
        String name;
        MyDate date = new MyDate(0,0,0);
        for (int i = 1;i < count;i++)
        {
            for (int j = i + 1;j <= count;j++)
            {
                if (MyDate.bigger(this.date[j],this.date[i]))
                {
                    name = this.name[i];
                    date = this.date[i];
                    this.name[i] = this.name[j];
                    this.date[i] = this.date[j];
                    this.name[j] = name;
                    this.date[j] = date;
                }
                else
                if (MyDate.thesame(this.date[i],this.date[j]))
                    if (this.name[j].compareTo(this.name[i]) > 0)
                    {
                        name = this.name[i];
                        date = this.date[i];
                        this.name[i] = this.name[j];
                        this.date[i] = this.date[j];
                        this.name[j] = name;
                        this.date[j] = date;
                    }
            }
        }
    }
    public String finishNextEvent()
    {
        if (count == 0) return "NONE";
        else return this.name[count--];
    }
}
