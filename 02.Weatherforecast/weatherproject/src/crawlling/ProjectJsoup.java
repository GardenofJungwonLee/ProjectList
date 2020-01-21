package crawlling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ProjectJsoup {

		
	public static Document weather = null;
	static{
		try {
			weather = Jsoup.connect("http://www.weather.go.kr/weather/climate/past_cal.jsp?").timeout(1000000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static Elements region = weather.select("#observation_select1");
	static int a = region.get(0).getAllElements().size();

	
	public static ArrayList<Integer> getNumbers(){
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(108);
		numbers.add(112);
		numbers.add(119);
		numbers.add(201);
		numbers.add(202);
		
		numbers.add(203);
		numbers.add(101);
		numbers.add(114);
		numbers.add(115);
		numbers.add(105);
		
		numbers.add(131);
		numbers.add(128);
		numbers.add(221);
		numbers.add(133);
		numbers.add(232);
		
		numbers.add(146);
		numbers.add(156);
		numbers.add(165);
		numbers.add(136);
		numbers.add(143);
		
		numbers.add(159);
		numbers.add(152);
		numbers.add(155);
		numbers.add(189);
		
		return numbers;
	}
			
	
	public static ArrayList<String> getNames(){
		ArrayList<String> names = new ArrayList<String>();
		names.add("서울");
		names.add("인천");
		names.add("수원");
		names.add("강화");
		names.add("양평");
		
		names.add("이천");
		names.add("춘천");
		names.add("원주");
		names.add("울릉도");
		names.add("강릉");
		
		names.add("청주");
		names.add("충주");
		names.add("제천");
		names.add("대전");
		names.add("천안");
		
		names.add("전주");
		names.add("광주");
		names.add("목포");
		names.add("안동");
		names.add("대구");
		
		names.add("부산");
		names.add("울산");
		names.add("창원");
		names.add("제주");
		
		
		return names;
	}
}

	

