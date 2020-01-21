package view;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import log4j.TryLogging;
import weather.ClientsController;
import weather.WeatherController;

public class StartView {

	static String id = "admin1234";

	private static final Logger LOGGER = Logger.getLogger(id);

	public static void main(String[] args) throws Exception {

		System.out.println("-----TIME 내장 패키지 시간-----");
		System.out.println(LocalDateTime.now() + "로그인 시도");
		System.out.println("-----관리자 로그인-----");
		TryLogging.logging(id);
		System.out.println("-----log4J 시간 기록-----");
		LOGGER.info("Logger Name: " + LOGGER.getName());
		System.out.println("");
		if (id == TryLogging.getAdmin()) {
			// 데이터 크롤링 & DB 저장
			System.out.println("*******크롤링 & DB 저장 작업 *******");
			// AllDataDAO.addAllWeather();

			// 특정날짜와 지역이름으로 평균기온 검색
			System.out.println(" ");
			System.out.println("*******특정 지역 & DB 특정 날짜 *******");
			WeatherController.weather("부산", "08-06");

			// 특정지역의 내일 날씸검색
			System.out.println(" ");
			System.out.println("******* 특정 지역 ********");
			WeatherController.weather("부산");

			// 특정지역과 날씨의 강수여부
			System.out.println(" ");
			System.out.println("****** 지역 과 날씨 의 강수 여부 ********");
			WeatherController.weatherRain("서울", "07-27");

			// 특정지역의 강수여부
			System.out.println(" ");
			System.out.println("******* 지역의 내일 강수 여부 ********");
			WeatherController.weatherRain("부산");

			// 지역별 날씨 경고 메세지
			System.out.println(" ");
			System.out.println("****** 날씨 경고 메세지 ******");
			WeatherController.weatherWarning("부산");

			// 모든 고객 검색
			System.out.println(" ");
			System.out.println("******* 모든 고객 검색 ********");
			ClientsController.getClients();

			// 서울지역 고객 검색
			System.out.println(" ");
			System.out.println("******* 특정지역 고객 검색 ********");
			ClientsController.getPartClients("서울");

			// 이름으로 고객 검색
			System.out.println(" ");
			System.out.println("******* 이름으로 고객 검색 ********");
			ClientsController.getPartClient("문인재");

			// 등급으로 고객검색
			System.out.println(" ");
			System.out.println("******* 특정 등급 고객 검색 ********");
			ClientsController.getPartClientsGrade("VVIP");

			// 고객삭제
			System.out.println(" ");
			System.out.println("******* 고객 삭제 ********");
			ClientsController.deleteClient("문인재");

			// 모든 고객 검색
			System.out.println(" ");
			System.out.println("******* 모든 고객 검색 ********");
			ClientsController.getClients();

			// 고객 추가
			System.out.println(" ");
			System.out.println("******* 고객 추가 ********");
			ClientsController.addClient("문인재", "530124", "울릉도", "20031024", "SILVER");

			// 모든 고객 검색
			System.out.println(" ");
			System.out.println("******* 모든 고객 검색 ********");
			ClientsController.getClients();
			
			// 모든 고객 나이 검색
			System.out.println(" ");
			System.out.println("******* 모든 고객 나이 검색 ********");
			ClientsController.ageIs();

			// 고객 나이 검색
			System.out.println(" ");
			System.out.println("******* 고객 나이 검색 ********");
			ClientsController.ageIs("이원정");

		} else {
			System.out.println("공개할 수 없습니다.");
		}
	}
}
