package navercroll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class search {

	public static void main(String[] args) {
		String clientId = "vefoGTuwqIToGYlF72Du";// //?�플리�??�션 ?�라?�언???�이?�값";
		String clientSecret = "IgKJmj9jXG";// ?�플리�??�션 ?�라?�언???�크릿값";
		try {
			String text = URLEncoder.encode("?�산", "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + text; // json 결과
			// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
			// // xml 결과
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // ?�상 ?�출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // ?�러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
				response.append("\n");
			}
			br.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
