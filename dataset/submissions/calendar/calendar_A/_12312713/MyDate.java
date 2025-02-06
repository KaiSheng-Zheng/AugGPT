public class MyDate
{
	private int year;
	private int month;
	private int day;
	static int[] days={0,31,28,31,30,31,30,31,31,30,31,30,31};
	public MyDate(int year, int month, int day)
	{
		this.year=year;
		this.month=month;
		this.day=day;
	}
	static boolean leap(int x)
	{
		return (x%400==0||(x%4==0&&x%100!=0));
	}
	int cal()
	{
		int s=0;
		for(int i=1;i<year;i++)
			s+=(leap(i)?366:365);
		for(int i=1;i<month;i++)
			s+=days[i];
		if(leap(year)&&month>2)
			s++;
		s+=day;
		return s;
	}
	MyDate recal(int s)
	{
		int year=1,month=1,day=0;
		while(true)
		{
			int t=(leap(year)?366:365);
			if(s<t)
				break;
			else
				s-=t;
			year++;
		}
		while(true)
		{
			int t=days[month];
			if(leap(year)&&month==2)
				t++;
			if(s<t)
				break;
			else
				s-=t;
			month++;
		}
		day=s;
		return new MyDate(year,month,day);
	}
	public String toString()
	{
		String s=String.format("%04d-%02d-%02d",year,month,day);
		return s;
	}
	public void addDays(int days)
	{
		int s=cal();
		MyDate t=recal(s+days);
		year=t.year;
		month=t.month;
		day=t.day;
	}
	public static int difference(MyDate date1, MyDate date2)
	{
		int s1=date1.cal(),s2=date2.cal();
		return s1-s2;
	}
}