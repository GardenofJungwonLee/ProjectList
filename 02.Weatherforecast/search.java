package navercroll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class search {

	public static void main(String[] args) {
		String clientId = "vefoGTuwqIToGYlF72Du";// //? í”Œë¦¬ì??´ì…˜ ?´ë¼?´ì–¸???„ì´?”ê°’";
		String clientSecret = "IgKJmj9jXG";// ? í”Œë¦¬ì??´ì…˜ ?´ë¼?´ì–¸???œí¬ë¦¿ê°’";
		try {
			String text = URLEncoder.encode("?°ì‚°", "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + text; // json ê²°ê³¼
			// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
			// // xml ê²°ê³¼
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // ?•ìƒ ?¸ì¶œ
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // ?ëŸ¬ ë°œìƒ
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
