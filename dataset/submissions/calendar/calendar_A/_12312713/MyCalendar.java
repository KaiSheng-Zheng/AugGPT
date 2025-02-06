class Event
{
	MyDate date;
	String name;
	public Event(MyDate date,String name)
	{
		this.date=date;
		this.name=name;
	}
	static public boolean Compare(Event event1,Event event2)
	{
		int v=MyDate.difference(event1.date,event2.date);
		if(v!=0)
			return v<0;
		else
			return (event1.name.compareTo(event2.name)<0);
	}
}
public class MyCalendar
{
	int capacity,size;
	Event[] events;
	boolean[] del;
	public MyCalendar(int capacity)
	{
		this.capacity=capacity;
		size=0;
		events=new Event[capacity+1];
		del=new boolean[capacity+1];
		for(int i=1;i<=capacity;i++)
			del[i]=true;
	}
	public boolean addEvent(MyDate date, String eventName)
	{
		if(size==capacity)
			return false;
		for(int i=1;i<=capacity;i++)
		{
			if(del[i])
			{
				events[i]=new Event(date,eventName);
				del[i]=false;
				break;
			}
		}
		size++;
		return true;
	}
	public String finishNextEvent()
	{
		int id=0;
		for(int i=1;i<=capacity;i++)
		{
			if(del[i])
				continue;
			if(id==0||Event.Compare(events[i],events[id]))
				id=i;
		}
		if(id==0)
			return "NONE";
		else
		{
			del[id]=true;
			size--;
			return events[id].name;
		}
	}
	public static void main(String[] args) 
	{
		MyDate date1 = new MyDate(2023,1,30);
		MyDate date2 = new MyDate(2023,3,1);
		MyDate date3 = new MyDate(2023,2,5);

		date1.addDays(2);
		assert(date1.toString().equals("2023-02-01"));

		int diff = MyDate.difference(date1, date2);
		assert(diff == -28);

		int diff2 = MyDate.difference(date3, date1);
		assert(diff2 == 4);

		MyCalendar calendar = new MyCalendar(4);
		calendar.addEvent(date1, "meeting");
		calendar.addEvent(date2, "seminar");
		calendar.addEvent(date3, "appointment");
		calendar.addEvent(date1, "laundry");
		boolean success = calendar.addEvent(date1, "exam");
		assert(success == false); // event capacity exceeded
		assert(calendar.finishNextEvent().equals("laundry"));
		assert(calendar.finishNextEvent().equals("meeting"));
		assert(calendar.finishNextEvent().equals("appointment"));
		assert(calendar.finishNextEvent().equals("seminar"));
		assert(calendar.finishNextEvent().equals("NONE"));
	}
}