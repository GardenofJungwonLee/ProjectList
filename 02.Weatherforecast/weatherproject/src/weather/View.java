package weather;

import java.util.ArrayList;

import crawlling.AllDataDAO;

public class View {
	// ���� ��Ȳ ���
		public static void showError(String message) {
			System.out.println(message);
		}
	
	
	// ��� ������Ʈ ���
		public static void weatherprojectView(ArrayList AllWeatherData) {
			int length = AllWeatherData.size();
			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println("�˻����� " + (index + 1) + " - " + AllWeatherData.get(index));
				}
			}
		}
}
