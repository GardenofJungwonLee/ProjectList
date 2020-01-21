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
			throw new NotExistException("�˻����� ���� ������ �����ϴ�.");
		}
	}

	// ��� weather ���� ��ȯ
	public static ArrayList<Weather> getAllweather() throws SQLException {
		return AllDataDAO.getAllWeatherData();
	}

	// region���� �˻�
	public static ArrayList<Weather> getweather(String region) throws Exception, NotExistException {
		ArrayList<Weather> getweather = AllDataDAO.getAllWeatherData();
		if (getweather == null) {
			throw new NotExistException("�˻��Ͻ� ������ �����ϴ�.");
		}
		return getweather;
	}



	// ���ο� weather ����
	public static boolean addWeather() throws Exception {
		return AllDataDAO.addAllWeather();

	}

	//���� ������ ���
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

	//�� ���� �ȿ��� ����
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

	// ���������� ��� �޼���
	public static String warningMessege(String region) throws SQLException {
		String messege = "";
		double max = WeatherService.calculateAverageweather(AllDataDAO.getWeather(region)).get(1);
		double min = WeatherService.calculateAverageweather(AllDataDAO.getWeather(region)).get(2);
		boolean result = WeatherService.countRain(AllDataDAO.getTomorrowRain(region));
		if (max - min >= 8 && result == true) {
			messege = "�ϱ����� ũ�� �� ���� ���⿡ �����ϼ���";
		} else if (max >= 28 && result == true) {
			messege = "���� ���� �����̿��� ������ �ﰡ�� �ֽñ� �ٶ��ϴ�.";
		} else if (min <= 20) {
			messege = "����� �ҽ��ϰڽ��ϴ�.";
		} else if (max <= 30 && max - min < 10 && result == false) {
			messege = "�����ϱ� ���� ���� ������ ����˴ϴ�.";
		} else if (result == true) {
			messege = "��� ì��ñ� �߹ٴϴ�.";
		} else {
			messege = "��ҿ� �Ȱ��� ������ ����˴ϴ�.";
		}

		return messege;
	}

}
