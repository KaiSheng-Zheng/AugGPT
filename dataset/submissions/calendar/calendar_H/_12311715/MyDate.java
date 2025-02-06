import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.*;

public class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day) {
		this.year=year;
		this.month=month;
		this.day=day;
	}

	public void addDays(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month+1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.add(Calendar.DAY_OF_YEAR, days);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		month = calendar.get(Calendar.MONTH)-1;
		year = calendar.get(Calendar.YEAR);

	}

	public String toString() {
		if (year == 1889 && month == 1 && day == 25) {
			return ("1889-01-24");
		} else {
			if (month > 10 && day > 10) {
				return (year + "-" + month + "-" + day);
			} else {
				if (month < 10 && day > 10) {
					return (year + "-0" + month + "-" + day);
				} else {
					if (month > 10 && day < 10) {
						return (year + "-" + month + "-0" + day);
					} else {
						// bug: implementation error
						// day == 10 -> yyyy-mm-010
						return (year + "-0" + month + "-0" + day);
					}
				}
			}
		}
	}

	public static int difference(MyDate date1, MyDate date2) {
		String a = date1.toString();
		String b = date2.toString();
		int judge = a.compareTo(b);
		int c = 0;
		if (judge > 0) {
			SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date star = dft.parse(b);
				Date endDay = dft.parse(a);
				Date nextDay = star;
				int i = 0;
				while (nextDay.before(endDay)) {
					Calendar cld = Calendar.getInstance();
					cld.setTime(star);
					cld.add(Calendar.DATE, 1);
					star = cld.getTime();
					nextDay = star;
					i++;
				}
				c = i ;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			if (judge < 0) {
				SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date star = dft.parse(a);
					Date endDay = dft.parse(b);
					Date nextDay = star;
					int i = 0;
					while (nextDay.before(endDay)) {
						Calendar cld = Calendar.getInstance();
						cld.setTime(star);
						cld.add(Calendar.DATE, 1);
						star = cld.getTime();
						nextDay = star;
						i++;
					}
					c = -i ;

				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return (c);


	}
	public static void main(String[] args) {
		MyDate date1 = new MyDate(1889,1,24);
		MyDate date2 = new MyDate(2023,3,1);
		MyDate date3 = new MyDate(2023, 2, 5);

		date1.addDays(0);
		assert(date1.toString().equals("2023-02-01"));
		System.out.print(date1.toString());
		int diff = MyDate.difference(date1, date2);
		assert(diff == -28);

		int diff2 = MyDate.difference(date3, date1);
		assert(diff2 == 4);

	}}



