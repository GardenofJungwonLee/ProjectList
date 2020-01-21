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
		names.add("����");
		names.add("��õ");
		names.add("����");
		names.add("��ȭ");
		names.add("����");
		
		names.add("��õ");
		names.add("��õ");
		names.add("����");
		names.add("�︪��");
		names.add("����");
		
		names.add("û��");
		names.add("����");
		names.add("��õ");
		names.add("����");
		names.add("õ��");
		
		names.add("����");
		names.add("����");
		names.add("����");
		names.add("�ȵ�");
		names.add("�뱸");
		
		names.add("�λ�");
		names.add("���");
		names.add("â��");
		names.add("����");
		
		
		return names;
	}
}

	

