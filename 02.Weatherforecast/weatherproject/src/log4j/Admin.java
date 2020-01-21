package log4j;


public class Admin {
	
	static Log4J log = Log4J.getInstance();
	public static void login() {
		System.out.println(log.info());
	}
	public static void loginFail() {
		System.out.println(log.warn());
	}
}
                 