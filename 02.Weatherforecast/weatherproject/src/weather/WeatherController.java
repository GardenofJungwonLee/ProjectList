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

	// 모든 프로젝트 검색 로직
	public static void weather(String region, String sday) {
		try {
			SuccessView.printAllWeather(WeatherService.calculateAverageweather(AllDataDAO.getWeather(region, sday)));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("날씨 검색 에러 발생");
		}
	}

	public static void weather(String region) {
		try {
			SuccessView.printAllWeather(WeatherService.calculateAverageweather(AllDataDAO.getWeather(region)));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("날씨 검색 에러 발생");
		}
	}

	public static void weatherRain(String region, String sday) {
		try {
			SuccessView.printYesOrNo(WeatherService.countRain(AllDataDAO.getTomorrowRain(region, sday)));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("날씨 검색 에러 발생");
		}
	}

	public static void weatherRain(String region) {
		try {
			SuccessView.printYesOrNo(WeatherService.countRain(AllDataDAO.getTomorrowRain(region)));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("날씨 검색 에러 발생");
		}
	}

	public static void weatherWarning(String region) {
		try {
			SuccessView.printWarningMessege(WeatherService.warningMessege(region));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("요청하신 지역이 없습니다.");
		}

	}
}
