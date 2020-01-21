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

		System.out.println("-----TIME ���� ��Ű�� �ð�-----");
		System.out.println(LocalDateTime.now() + "�α��� �õ�");
		System.out.println("-----������ �α���-----");
		TryLogging.logging(id);
		System.out.println("-----log4J �ð� ���-----");
		LOGGER.info("Logger Name: " + LOGGER.getName());
		System.out.println("");
		if (id == TryLogging.getAdmin()) {
			// ������ ũ�Ѹ� & DB ����
			System.out.println("*******ũ�Ѹ� & DB ���� �۾� *******");
			// AllDataDAO.addAllWeather();

			// Ư����¥�� �����̸����� ��ձ�� �˻�
			System.out.println(" ");
			System.out.println("*******Ư�� ���� & DB Ư�� ��¥ *******");
			WeatherController.weather("�λ�", "08-06");

			// Ư�������� ���� ���°˻�
			System.out.println(" ");
			System.out.println("******* Ư�� ���� ********");
			WeatherController.weather("�λ�");

			// Ư�������� ������ ��������
			System.out.println(" ");
			System.out.println("****** ���� �� ���� �� ���� ���� ********");
			WeatherController.weatherRain("����", "07-27");

			// Ư�������� ��������
			System.out.println(" ");
			System.out.println("******* ������ ���� ���� ���� ********");
			WeatherController.weatherRain("�λ�");

			// ������ ���� ��� �޼���
			System.out.println(" ");
			System.out.println("****** ���� ��� �޼��� ******");
			WeatherController.weatherWarning("�λ�");

			// ��� �� �˻�
			System.out.println(" ");
			System.out.println("******* ��� �� �˻� ********");
			ClientsController.getClients();

			// �������� �� �˻�
			System.out.println(" ");
			System.out.println("******* Ư������ �� �˻� ********");
			ClientsController.getPartClients("����");

			// �̸����� �� �˻�
			System.out.println(" ");
			System.out.println("******* �̸����� �� �˻� ********");
			ClientsController.getPartClient("������");

			// ������� ���˻�
			System.out.println(" ");
			System.out.println("******* Ư�� ��� �� �˻� ********");
			ClientsController.getPartClientsGrade("VVIP");

			// ������
			System.out.println(" ");
			System.out.println("******* �� ���� ********");
			ClientsController.deleteClient("������");

			// ��� �� �˻�
			System.out.println(" ");
			System.out.println("******* ��� �� �˻� ********");
			ClientsController.getClients();

			// �� �߰�
			System.out.println(" ");
			System.out.println("******* �� �߰� ********");
			ClientsController.addClient("������", "530124", "�︪��", "20031024", "SILVER");

			// ��� �� �˻�
			System.out.println(" ");
			System.out.println("******* ��� �� �˻� ********");
			ClientsController.getClients();
			
			// ��� �� ���� �˻�
			System.out.println(" ");
			System.out.println("******* ��� �� ���� �˻� ********");
			ClientsController.ageIs();

			// �� ���� �˻�
			System.out.println(" ");
			System.out.println("******* �� ���� �˻� ********");
			ClientsController.ageIs("�̿���");

		} else {
			System.out.println("������ �� �����ϴ�.");
		}
	}
}
