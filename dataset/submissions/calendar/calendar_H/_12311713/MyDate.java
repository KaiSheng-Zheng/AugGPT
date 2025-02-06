import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import java.text.*;
import java.util.*;
public class MyDate {
	private int year;
	private int month;
	private int day;
	Date date;
	Calendar cal=Calendar.getInstance();
	public MyDate(int year, int month, int day){
		SimpleDateFormat tmp=new SimpleDateFormat("yyyy-MM-dd");
		String str=String.format("%d-%02d-%02d",year,month,day);
		try {
			this.date=tmp.parse(str);
		} catch (ParseException e) {
			System.out.println("lol");
		}
		this.cal.setTime(date);
	}
	@Override
	public String toString(){
		return String.format("%d-%02d-%02d",cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
	}
	public void addDays(int days){
		cal.add(Calendar.DAY_OF_YEAR,days);
	}
	public static int difference(MyDate date1, MyDate date2){
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		int ans=0;
		try {
			Date star = dft.parse(date2.toString());
			Date endDay=dft.parse(date1.toString());
			Long starTime=star.getTime();
			Long endTime=endDay.getTime();
			Long num=endTime-starTime;
			ans=(int)(num/24/60/60/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ans;
	}
}
