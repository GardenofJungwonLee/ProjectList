package view;

import java.util.ArrayList;

import miniProject.People.dto.ClientDTO;

public class SuccessView {

	public static void printAllWeather(ArrayList<Double> weather) {
		System.out.println("평균기온 : " + weather.get(0) + "℃" + ",  최고기온 : " + weather.get(1) + "℃" + ",   최저기온 : "
				+ weather.get(2) + "℃" + ",   평균운량 : " + weather.get(3) + ",   일 평균 강수량 :" + weather.get(4) + "mm");
	}

	public static void printYesOrNo(boolean result) {
		if (result == true) {
			System.out.println("종성아 우산 챙겨라");
		} else {
			System.out.println("비가 안올겁니다.");
		}
	}

	public static void printAllClients(ArrayList<ClientDTO> allData) {
		for (int i = 0; i < allData.size(); i++) {
			System.out.println(allData.get(i).toString());
		}
	}

	public static void printDeleteClient() {
		System.out.println("요청하신 고객을 삭제하였습니다.");
	}

	public static void printAddClient() {
		System.out.println("요청하신 고객을 추가하였습니다..");
	}

	public static void printClientAge(ArrayList<Integer> ageArray) {
		for (int i = 0; i < ageArray.size(); i++) {
			System.out.println(ageArray.get(i));
		}
	}

	public static void printWarningMessege(String messege) {
		System.out.println(messege);
	}
}
