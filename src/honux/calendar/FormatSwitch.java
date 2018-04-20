package honux.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatSwitch {
	static Date date;
	String stringDate;
	public FormatSwitch(String stringDate) {
		this.stringDate = stringDate;
	}
	public Date formatSwitch(String stringDate) {
	System.out.println("stringDate test :"+ stringDate);
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return date;
		
	}
}