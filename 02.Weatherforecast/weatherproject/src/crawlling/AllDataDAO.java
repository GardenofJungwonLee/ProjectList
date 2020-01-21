package crawlling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import miniProject.DBUtil.DBUtil;
import miniProject.People.dto.ClientDTO;
import model.domain.Weather;

public class AllDataDAO {

	public static ArrayList<String> names = ProjectJsoup.getNames();
	public static ArrayList<Integer> numbers = ProjectJsoup.getNumbers();
	public static ArrayList<Weather> weather;

	public static boolean addAllWeather() throws Exception {
		boolean answer = false;
		ArrayList<String> list = DateFormat.getDayList();
		Connection con = null;
		PreparedStatement pstmt = null;

		for (int j = 0; j < names.size(); j++) {
			ArrayList<String> refer = FunctionforArray.getAllData(j);
			for (int i = 0; i < DateFormat.getDayList().size(); i++) {

				con = DBUtil.getConnection();
				Thread.sleep(300);
				try {
					pstmt = con.prepareStatement(
							"insert into weather values(weather_number.nextval, ?, ?, ?, ?, ?, ?, ?)");

					System.out.println(names.get(j));
					pstmt.setString(1, names.get(j));
					pstmt.setString(2, list.get(i));
					System.out.println(list.get(i));
					pstmt.setDouble(3, FunctionforArray.findAvgTemp(refer).get(i));
					pstmt.setDouble(4, FunctionforArray.findMaxTemp(refer).get(i));
					pstmt.setDouble(5, FunctionforArray.findMinTemp(refer).get(i));
					pstmt.setDouble(6, FunctionforArray.findClouds(refer).get(i));
					pstmt.setDouble(7, FunctionforArray.findPrecipitation(refer).get(i));

					int result = pstmt.executeUpdate();

					if (result == 1) {
						System.out.println(true);
					}

				} finally {

					DBUtil.close(con, pstmt);
				}
			}
		}
		return answer;
	}

	public static ArrayList<Weather> getAllWeatherData() throws SQLException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Weather> allData = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from weather");
			allData = new ArrayList<Weather>();
			while (rset.next()) {
				allData.add(new Weather(rset.getInt("weather_number"), rset.getString("region"), rset.getString("day"),
						rset.getDouble("avgTemp"), rset.getDouble("maxTemp"), rset.getDouble("minTemp"),
						rset.getDouble("clouds"), rset.getDouble("precipitation")));
			}
			// 6단계 자원반환
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return allData;
	}

	// ==================================================================================
	// 새로 만든 '지역으로 해당 지역 모든 날씨검색 '
	public static ArrayList<Weather> getWeather(String region, String sday) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from WEATHER where region=? and day like ?");
			pstmt.setString(1, region);
			pstmt.setString(2, "%" + sday);
			rset = pstmt.executeQuery();
			weather = new ArrayList<Weather>();
			while (rset.next()) {
				weather.add(new Weather(rset.getInt("weather_number"), rset.getString("region"), rset.getString("day"),
						rset.getDouble("avgTemp"), rset.getDouble("maxTemp"), rset.getDouble("minTemp"),
						rset.getDouble("clouds"), rset.getDouble("precipitation")));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return weather;
	}

	// 특정지역의 내일날씨 검색
	public static ArrayList<Weather> getWeather(String region) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String tomorrow = LocalDate.now().plusDays(1).toString().substring(5);
		String sday = "%" + tomorrow;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from WEATHER where region=? and day like ?");
			pstmt.setString(1, region);
			pstmt.setString(2, sday);
			rset = pstmt.executeQuery();
			weather = new ArrayList<Weather>();
			while (rset.next()) {
				weather.add(new Weather(rset.getInt("weather_number"), rset.getString("region"), rset.getString("day"),
						rset.getDouble("avgTemp"), rset.getDouble("maxTemp"), rset.getDouble("minTemp"),
						rset.getDouble("clouds"), rset.getDouble("precipitation")));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return weather;
	}

	public static ArrayList<Double> getTomorrowRain(String region, String day) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Double> yesOrNo = new ArrayList<>();
		String sday = "%" + day;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select precipitation from WEATHER where region=? and day like ?");
			pstmt.setString(1, region);
			pstmt.setString(2, sday);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				yesOrNo.add(rset.getDouble("precipitation"));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return yesOrNo;
	}

	public static ArrayList<Double> getTomorrowRain(String region) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Double> yesOrNo = new ArrayList<>();
		String tomorrow = LocalDate.now().plusDays(1).toString().substring(5);
		String sday = "%" + tomorrow;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select precipitation from WEATHER where region=? and day like ?");
			pstmt.setString(1, region);
			pstmt.setString(2, sday);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				yesOrNo.add(rset.getDouble("precipitation"));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return yesOrNo;
	}

	// 모든 고객정보 검색
	public static ArrayList<ClientDTO> getAllClients() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<ClientDTO> allData = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from clients");
			allData = new ArrayList<>();
			while (rset.next()) {
				allData.add(new ClientDTO(rset.getInt("client_id"), rset.getString("name"), rset.getString("SSN"),
						rset.getString("region"), rset.getString("registerday"), rset.getString("grade")));
			}
			// 6단계 자원반환
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return allData;
	}

	// 지역으로 고객검색
	public static ArrayList<ClientDTO> getPartClients(String name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ClientDTO> allData = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from clients where name=?");
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			allData = new ArrayList<ClientDTO>();
			while (rset.next()) {
				allData.add(new ClientDTO(rset.getInt("client_id"), rset.getString("name"), rset.getString("SSN"),
						rset.getString("region"), rset.getString("registerday"), rset.getString("grade")));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return allData;
	}

	public static ArrayList<ClientDTO> getPartClientsGrade(String grade) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ClientDTO> allData = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from clients where grade=?");
			pstmt.setString(1, grade);
			rset = pstmt.executeQuery();
			allData = new ArrayList<ClientDTO>();
			while (rset.next()) {
				allData.add(new ClientDTO(rset.getInt("client_id"), rset.getString("name"), rset.getString("SSN"),
						rset.getString("region"), rset.getString("registerday"), rset.getString("grade")));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return allData;
	}

	public static boolean deleteClient(String name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from clients where name=?");
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean addClient(String name, String SSN, String region, String registerDay, String grade)
			throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into clients values(client_id.nextval, ?, ?, ? ,? ,?) ");
			pstmt.setString(1, name);
			pstmt.setString(2, SSN);
			pstmt.setString(3, region);
			pstmt.setString(4, registerDay);
			pstmt.setString(5, grade);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
