package log4j;

import log4j.Admin;

public class TryLogging {

	static String admin = "admin1234";
	public static void logging(String name){
		//고객이 admin 인척 로그인 상황
		//코드로 filtering
		if(admin.equals(name)) {
			Admin.login();
		}else {
			Admin.loginFail();
		}
	}
	public static String getAdmin() {
		return admin;
	}
}
