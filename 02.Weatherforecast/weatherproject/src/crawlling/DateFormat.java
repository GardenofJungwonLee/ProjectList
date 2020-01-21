package crawlling;

import java.time.LocalDate;
import java.util.ArrayList;

public class DateFormat {
		
	
	public static ArrayList<String> getDayList(){
		ArrayList<String> list = new ArrayList<>();
		LocalDate date  = LocalDate.parse("2000-01-01"); 
		while(!date.equals(LocalDate.now())) {
			list.add(date.toString());
			date = date.plusDays(1); 
		}
		return list;
	}
    
}
