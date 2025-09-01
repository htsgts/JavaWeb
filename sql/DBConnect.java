import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	Connection conn = null;
	
	DBConnect(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:9933/web",
					"root",
					"1234"
					);
			if(conn != null) {
				System.out.println(conn);
				System.out.println("Congratulations!! Connect OK");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnect dbConn = new DBConnect(); 
	}

}
