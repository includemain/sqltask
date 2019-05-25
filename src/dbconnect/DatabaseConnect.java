package dbconnect;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class DatabaseConnect {
	private static String DRIVER = "";
	private static String URL = "";
	private static String USERNAME = "";
	private static String PASSWORD = "";

	static {
		getPeopertiesInfo();
	}
	private static void getPeopertiesInfo() {
		Properties prop = new Properties();
		InputStream inputStream = Thread.currentThread()
				.getContextClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DRIVER = prop.getProperty("driver");
		URL = prop.getProperty("url");
		USERNAME = prop.getProperty("username");
		PASSWORD = prop.getProperty("password");
	}
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("error1");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			System.out.println("error2");
			e.printStackTrace();
		}
		return conn;
	}
}
