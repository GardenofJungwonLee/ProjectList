package log4j;

import log4j.Admin;

public class TryLogging {

	static String admin = "admin1234";
	public static void logging(String name){
		//���� admin ��ô �α��� ��Ȳ
		//�ڵ�� filtering
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
