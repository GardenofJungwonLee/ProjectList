package weather;

import java.sql.SQLException;

import crawlling.AllDataDAO;
import view.SuccessView;

public class WeatherController {

	private static WeatherController instance;

	private WeatherController() {
	}

	public static WeatherController getInstance() {
		return instance;
	}

	// ��� ������Ʈ �˻� ����
	public static void weather(String region, String sday) {
		try {
			SuccessView.printAllWeather(WeatherService.calculateAverageweather(AllDataDAO.getWeather(region, sday)));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("���� �˻� ���� �߻�");
		}
	}

	public static void weather(String region) {
		try {
			SuccessView.printAllWeather(WeatherService.calculateAverageweather(AllDataDAO.getWeather(region)));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("���� �˻� ���� �߻�");
		}
	}

	public static void weatherRain(String region, String sday) {
		try {
			SuccessView.printYesOrNo(WeatherService.countRain(AllDataDAO.getTomorrowRain(region, sday)));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("���� �˻� ���� �߻�");
		}
	}

	public static void weatherRain(String region) {
		try {
			SuccessView.printYesOrNo(WeatherService.countRain(AllDataDAO.getTomorrowRain(region)));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("���� �˻� ���� �߻�");
		}
	}

	public static void weatherWarning(String region) {
		try {
			SuccessView.printWarningMessege(WeatherService.warningMessege(region));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("��û�Ͻ� ������ �����ϴ�.");
		}

	}
}
