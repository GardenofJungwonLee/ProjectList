package weather;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import crawlling.AllDataDAO;
import miniProject.People.dto.ClientDTO;

public class ClientsService {

	private static ClientsService instance;

	private ClientsService() {
	}

	public static ClientsService getInstance() {
		return instance;
	}

	// 모든 고객 정보 반환
	public static ArrayList<ClientDTO> getAllClients() throws SQLException {
		return AllDataDAO.getAllClients();
	}

	// 일부 고객정보 반환
	public static ArrayList<ClientDTO> getPartClients(String name) throws SQLException {
		return AllDataDAO.getPartClients(name);
	}

	// 모든 고객 나이 계산
	public static ArrayList<Integer> getClientsAge() throws SQLException {
		ArrayList<Integer> ageArray = new ArrayList<>();
		ArrayList<ClientDTO> refer = AllDataDAO.getAllClients();
		for (int i = 0; i < refer.size(); i++) {
			ageArray.add(
					LocalDate.now().getYear() - 1900 - Integer.parseInt(refer.get(i).getSSN().substring(0, 2)) + 1);
		}
		return ageArray;
	}

	// 이름으로 고객 나이 계산
	public static ArrayList<Integer> getClientsAge(String name) throws SQLException {
		ArrayList<Integer> ageArray = new ArrayList<>();
		ArrayList<ClientDTO> refer = AllDataDAO.getPartClients(name);
		for (int i = 0; i < refer.size(); i++) {
			ageArray.add(
					LocalDate.now().getYear() - 1900 - Integer.parseInt(refer.get(i).getSSN().substring(0, 2)) + 1);
		}
		return ageArray;
	}

	public static ArrayList<ClientDTO> getPartClientsGrade(String grade) throws SQLException {
		return AllDataDAO.getPartClientsGrade(grade);
	}

	public static boolean deleteClient(String name) throws SQLException {
		return AllDataDAO.deleteClient(name);
	}

	public static boolean addClient(String name, String SSN, String region, String registerDay, String grade)
			throws SQLException {
		return AllDataDAO.addClient(name, SSN, region, registerDay, grade);
	}

}
