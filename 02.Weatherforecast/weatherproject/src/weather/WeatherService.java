package weather;

import java.sql.SQLException;
import java.util.ArrayList;

import crawlling.AllDataDAO;
import model.domain.Weather;
import notExistException.NotExistException;

public class WeatherService {

	private static WeatherService instance = new WeatherService();

	private WeatherService() {
	}

	public static WeatherService getInstance() {
		return instance;
	}

	// weather - CRUD
	public static void notExistweather(String names) throws NotExistException, SQLException {
		ArrayList<Weather> weather = AllDataDAO.getAllWeatherData();
		if (weather == null) {
			throw new NotExistException("검색하진 날씨 정보가 없습니다.");
		}
	}

	// 모든 weather 정보 반환
	public static ArrayList<Weather> getAllweather() throws SQLException {
		return AllDataDAO.getAllWeatherData();
	}

	// region으로 검색
	public static ArrayList<Weather> getweather(String region) throws Exception, NotExistException {
		ArrayList<Weather> getweather = AllDataDAO.getAllWeatherData();
		if (getweather == null) {
			throw new NotExistException("검색하신 지역이 없습니다.");
		}
		return getweather;
	}



	// 새로운 weather 저장
	public static boolean addWeather() throws Exception {
		return AllDataDAO.addAllWeather();

	}

	//내일 날씨의 평균
	public static ArrayList<Double> calculateAverageweather(ArrayList<Weather> weatherPart) {
		ArrayList<Double> averageList = new ArrayList<>();
		double avgSum = 0;
		double maxSum = 0;
		double minSum = 0;
		double cloudsSum = 0;
		double precipitationSum = 0;
		for (int i = 0; i < weatherPart.size(); i++) {
			avgSum = avgSum + weatherPart.get(i).getAvgTemp();
			maxSum = maxSum + weatherPart.get(i).getMaxTemp();
			minSum = minSum + weatherPart.get(i).getMinTemp();
			cloudsSum = cloudsSum + weatherPart.get(i).getClouds();
			precipitationSum = precipitationSum + weatherPart.get(i).getPrecipitation();
		}
		averageList.add((double) Math.round((avgSum / weatherPart.size()) * 100) / 100);
		averageList.add((double) Math.round((maxSum / weatherPart.size()) * 100) / 100);
		averageList.add((double) Math.round((minSum / weatherPart.size()) * 100) / 100);
		averageList.add((double) Math.round((cloudsSum / weatherPart.size()) * 100) / 100);
		averageList.add((double) Math.round((precipitationSum / weatherPart.size()) * 100) / 100);

		return averageList;
	}

	//비가 올지 안올지 여부
	public static boolean countRain(ArrayList<Double> yesOrNo) {
		boolean result = false;
		int count = 0;
		for (int i = 0; i < yesOrNo.size(); i++) {
			if (yesOrNo.get(i) != 0) {
				count++;
			}
		}

		if (count >= 3) {
			result = true;
		}
		return result;
	}

	// 날씨에따른 출력 메세지
	public static String warningMessege(String region) throws SQLException {
		String messege = "";
		double max = WeatherService.calculateAverageweather(AllDataDAO.getWeather(region)).get(1);
		double min = WeatherService.calculateAverageweather(AllDataDAO.getWeather(region)).get(2);
		boolean result = WeatherService.countRain(AllDataDAO.getTomorrowRain(region));
		if (max - min >= 8 && result == true) {
			messege = "일교차가 크고 비도 오니 감기에 조심하세요";
		} else if (max >= 28 && result == true) {
			messege = "덥고 습할 예정이오니 외출을 삼가해 주시기 바랍니다.";
		} else if (min <= 20) {
			messege = "밤길이 쌀쌀하겠습니다.";
		} else if (max <= 30 && max - min < 10 && result == false) {
			messege = "외출하기 아주 좋은 날씨가 예상됩니다.";
		} else if (result == true) {
			messege = "우산 챙기시기 발바니다.";
		} else {
			messege = "평소와 똑같은 날씨가 예상됩니다.";
		}

		return messege;
	}

}
