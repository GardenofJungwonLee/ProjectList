package crawlling;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class FunctionforArray {
	
	public static ArrayList<String> names = ProjectJsoup.getNames();
	public static ArrayList<Integer> numbers = ProjectJsoup.getNumbers();

	
	static Document main = null;
	
	public static ArrayList<String> getAllData(int s) throws Exception{

		String[] middle = {};
		ArrayList<String> factor = new ArrayList<>();
		
			System.out.println("============ 지역 : " + names.get(s) + "============");
			for(int j = 2000; j <= 2019; j++) {
				System.out.println("=========== "+j+" 년 ===========");
				int year = j;
				for(int m = 1; m <= 12; m++) {			
					System.out.println("============" + m + " 월 ============");
					String site = "http://www.weather.go.kr/weather/climate/past_cal.jsp?stn=" + numbers.get(s)+"&yy=" + year + "&mm=" + m +"&obs=1";
					try {
						Thread.sleep(3000);
						main = Jsoup.connect(site).timeout(10000000).get();
					} catch (Exception e) {
						e.printStackTrace();
					}
					for(int k = 1; k<7; k++) {
						int lines = 2*k;
						String address = "#content_weather > table > tbody tr:nth-child("+lines+") td";
						try {
							Elements info = main.select(address);
							
							for(int l = 0 ; l < 7; l++) {
								if(info.get(l).text().length()!=0) {
									middle = info.get(l).text().replace(": -", ":0.0mm").split(" ");
									for(int x = 0 ; x < middle.length; x++) {
										factor.add(middle[x]);
									}
								}
							}
	
						}catch(Exception e){
							
						}
					}
				}
				
			}
			return factor;

		}
	
	public static List<Double> findAvgTemp(ArrayList<String> factor){
		
		List<Double> avgTemp = new ArrayList<Double>();
		
		for(int p = 0; p < factor.size(); p++) {
			int q = factor.get(p).length();
			if(p%5==0) {
				avgTemp.add(Double.parseDouble(factor.get(p).substring(5,q-1)));
			}
		}
		return avgTemp;
	}
	
	public static List<Double> findMaxTemp(ArrayList<String> factor){
		
		List<Double> maxTemp = new ArrayList<>();

		for(int p = 0; p < factor.size(); p++) {
			int q = factor.get(p).length();
			 if(p%5==1) {
				maxTemp.add(Double.parseDouble(factor.get(p).substring(5,q-1)));
			}
		}

		return maxTemp;
	}
	
	public static List<Double> findMinTemp(ArrayList<String> factor){
		
		List<Double> minTemp = new ArrayList<>();
		
		for(int p = 0; p < factor.size(); p++) {
			int q = factor.get(p).length();
			if(p%5==2) {
				minTemp.add(Double.parseDouble(factor.get(p).substring(5,q-1)));
			
			}
		}

		return minTemp;
	}
	
	public static List<Double> findClouds(ArrayList<String> factor){
		
		List<Double> clouds = new ArrayList<>();
		
		for(int p = 0; p < factor.size(); p++) {
			if(p%5==3) {
				clouds.add(Double.parseDouble(factor.get(p).substring(5)));
			}
		}

		return clouds;
	}
	
	public static List<Double> findPrecipitation(ArrayList<String> factor){
		
		List<Double> precipitation = new ArrayList<>();
		
		for(int p = 0; p < factor.size(); p++) {
			int q = factor.get(p).length();
			if(p%5==4){
				precipitation.add(Double.parseDouble(factor.get(p).substring(5,q-2)));
			}
		}

		return precipitation;
	}
	
}














