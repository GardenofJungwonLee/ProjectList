package weather;

import java.util.ArrayList;

import crawlling.AllDataDAO;

public class View {
	// 예외 상황 출력
		public static void showError(String message) {
			System.out.println(message);
		}
	
	
	// 모든 프로젝트 출력
		public static void weatherprojectView(ArrayList AllWeatherData) {
			int length = AllWeatherData.size();
			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println("검색정보 " + (index + 1) + " - " + AllWeatherData.get(index));
				}
			}
		}
}
