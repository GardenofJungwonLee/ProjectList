package log4j;

public class OneInstance {

	public static void main(String[] args) {
		//���� admin ��ô �α��� ��Ȳ
		//�ڵ�� filtering
		String admin = " admin";
		String customer = "customer";
		if(!customer.equals(admin)) {
			Admin.loginFail();
		}
	}
}
