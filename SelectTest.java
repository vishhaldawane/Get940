import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest {
	public static void main(String[] args) {
		//1. load the driver
		try {
			System.out.println("Trying to load the driver...");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver...loaded....");
			
			//2 connect to the DB
			System.out.println("Trying to Connect to the database...");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:OSE", "system", "manager");
			System.out.println("Connected to the DB "+conn);
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter table name : ");
			String tableName = scan.next();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from "+tableName ); //sql query here
			while(rs.next()) {
				int x= rs.getInt(1);
				String y = rs.getString(2);
				String z = rs.getString(3);
				System.out.println("Number   : "+x);
				System.out.println("String   : "+y);
				System.out.println("String   : "+z);
				System.out.println("---------------------------");
			}
			rs.close();
			st.close();
			conn.close();
			System.out.println("DB resources closed...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
