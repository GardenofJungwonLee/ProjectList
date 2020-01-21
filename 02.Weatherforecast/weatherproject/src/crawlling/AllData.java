package crawlling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import miniProject.DBUtil.DBUtil;
import model.domain.Weather;

public class AllData {

	public static ArrayList<String> names = ProjectJsoup.getNames();
	public static ArrayList<Integer> numbers = ProjectJsoup.getNumbers();

	public static boolean addWeather() throws Exception {
		boolean answer = false;
		ArrayList<String> list = DateFormat.getDayList();
		Connection con = null;
		PreparedStatement pstmt = null;
		for (int j = 19; j < names.size(); j++) {
			ArrayList<String> refer = FunctionforArray.getAllData(j);
			for (int i = 0; i < list.size(); i++) {
				con = DBUtil.getConnection();

				Thread.sleep(50);
				try {
					pstmt = con.prepareStatement(
							"insert into weather values(weather_number.nextval, ?, ?, ?, ?, ?, ?, ?)");

					System.out.println(list.get(i));// 데이터 처리정보상황을 보기위한 출력값 - 볼필요없음
					pstmt.setString(1, names.get(j));
					pstmt.setString(2, list.get(i));
					pstmt.setDouble(3, FunctionforArray.findAvgTemp(refer).get(i));
					pstmt.setDouble(4, FunctionforArray.findMaxTemp(refer).get(i));
					pstmt.setDouble(5, FunctionforArray.findMinTemp(refer).get(i));
					pstmt.setDouble(6, FunctionforArray.findClouds(refer).get(i));
					pstmt.setDouble(7, FunctionforArray.findPrecipitation(refer).get(i));

					int result = pstmt.executeUpdate();

					if (result == 1) {
						System.out.println(true);// 데이터 처리정보상황을 보기위한 출력값 - 볼필요없음
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
			
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return allData;
	}
}
