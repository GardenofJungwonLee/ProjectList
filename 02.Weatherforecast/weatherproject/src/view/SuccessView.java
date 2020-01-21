package view;

import java.util.ArrayList;

import miniProject.People.dto.ClientDTO;

public class SuccessView {

	public static void printAllWeather(ArrayList<Double> weather) {
		System.out.println("��ձ�� : " + weather.get(0) + "��" + ",  �ְ��� : " + weather.get(1) + "��" + ",   ������� : "
				+ weather.get(2) + "��" + ",   ��տ : " + weather.get(3) + ",   �� ��� ������ :" + weather.get(4) + "mm");
	}

	public static void printYesOrNo(boolean result) {
		if (result == true) {
			System.out.println("������ ��� ì�ܶ�");
		} else {
			System.out.println("�� �ȿð̴ϴ�.");
		}
	}

	public static void printAllClients(ArrayList<ClientDTO> allData) {
		for (int i = 0; i < allData.size(); i++) {
			System.out.println(allData.get(i).toString());
		}
	}

	public static void printDeleteClient() {
		System.out.println("��û�Ͻ� ���� �����Ͽ����ϴ�.");
	}

	public static void printAddClient() {
		System.out.println("��û�Ͻ� ���� �߰��Ͽ����ϴ�..");
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
