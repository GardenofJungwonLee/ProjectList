package log4j;

public class OneInstance {

	public static void main(String[] args) {
		//고객이 admin 인척 로그인 상황
		//코드로 filtering
		String admin = " admin";
		String customer = "customer";
		if(!customer.equals(admin)) {
			Admin.loginFail();
		}
	}
}
