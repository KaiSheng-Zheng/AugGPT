import java.text.*;
import java.util.*;
public class MyCalendar {
	private int capacity;
	private int pointer=0;
	String[] events;
	public MyCalendar(int capacity){
		this.capacity=capacity;
		events=new String[this.capacity];
	}
	public boolean addEvent(MyDate date, String eventName){
		if(pointer<this.capacity) {
			this.events[pointer++] = String.format("%s %s", date.toString(), eventName);
			return true;
		}
		else{
			return false;
		}
	}
	public String finishNextEvent(){
		ArrayList<MyDate> dates=new ArrayList<MyDate>();
		String[][] str=new String[pointer][2];
		for (int i = 0; i < pointer; i++) {
			int p=0;
			while(this.events[i].charAt(p)!=' ')
				p++;
			str[i][0]=this.events[i].substring(0,p);
			str[i][1]=this.events[i].substring(p);
			SimpleDateFormat tmp=new SimpleDateFormat("yyyy-MM-dd");
			try {
				Calendar cal=Calendar.getInstance();
				cal.setTime(tmp.parse(str[i][0]));
				dates.add(new MyDate(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)));
			} catch (ParseException e) {
				System.out.println("lol");
			}
		}
		for (int i = 0; i < pointer-1; i++) {
			for(int j = i; j < pointer-1; j++){
				if(MyDate.difference(dates.get(j),dates.get(j+1))<0){
					MyDate tmp=dates.get(j);
					dates.set(j,dates.get(j+1));
					dates.set(j+1,tmp);
					String[] Tmp=str[j];
					str[j]=str[j+1];
					str[j+1]=Tmp;
				}
			}
		}
		for (int i = 0; i < pointer-1; i++) {
			if(MyDate.difference(dates.get(i),dates.get(i+1))==0){
				if(str[i][1].compareTo(str[i+1][1])<0){
					MyDate tmp=dates.get(i);
					dates.set(i,dates.get(i+1));
					dates.set(i+1,tmp);
					String[] Tmp=str[i];
					str[i]=str[i+1];
					str[i+1]=Tmp;
				}
			}
		}
		for (int i = 0; i < pointer; i++) {
			this.events[i]=String.format("%s`%s",str[i][0],str[i][1]);
		}

		if(pointer>0){
			dates.remove(pointer-1);
			return str[--pointer][1].substring(1);
		}
		else
			return "NONE";
	}
}
