package weather;

import java.sql.SQLException;

import view.SuccessView;

public class ClientsController {

	private static ClientsController instance;

	private ClientsController() {
	}

	public static ClientsController getInstance() {
		return instance;
	}

	public static void getClients() {
		try {
			SuccessView.printAllClients(ClientsService.getAllClients());
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("검색 에러 발생");
		}
	}

	public static void getPartClients(String region) {
		try {
			SuccessView.printAllClients(ClientsService.getPartClients(region));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("검색 에러 발생");
		}
	}

	public static void ageIs(String name) {
		try {
			SuccessView.printClientAge(ClientsService.getClientsAge(name));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("검색 에러 발생");
		}
	}
	
	public static void ageIs() {
		try {
			SuccessView.printClientAge(ClientsService.getClientsAge());
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("검색 에러 발생");
		}
	}

	public static void getPartClient(String name) {
		try {
			SuccessView.printAllClients(ClientsService.getPartClients(name));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("검색 에러 발생");
		}
	}

	public static void getPartClientsGrade(String grade) {
		try {
			SuccessView.printAllClients(ClientsService.getPartClientsGrade(grade));
		} catch (SQLException s) {
			s.printStackTrace();
			View.showError("검색 에러 발생");
		}
	}

	public static void deleteClient(String name) throws SQLException {
		if (ClientsService.deleteClient(name) == true) {
			SuccessView.printDeleteClient();
		} else {
			View.showError("삭제 실패 요청하신 정보가 없습니다.");
		}
	}

	public static void addClient(String name, String SSN, String region, String registerDay, String grade)
			throws SQLException {
		if (ClientsService.addClient(name, SSN, region, registerDay, grade) == true) {
			SuccessView.printAddClient();
		} else {
			View.showError("고객 추가 자료에 잘못된 정보가 있습니다.");
		}
	}
	


}
