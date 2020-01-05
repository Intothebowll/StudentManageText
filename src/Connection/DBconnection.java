package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
  public static Connection con=null;
   public static  Connection getConnection()
   {
		try {
			String dbDriver="com.mysql.jdbc.Driver";
			Class.forName(dbDriver);
			System.out.println("Driver Suceess");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanage","root","123456");
			System.out.println("Connection Suceess");
		} catch (SQLException e) {
			System.out.println("Connetion failure");
			e.printStackTrace();
		}
		return con;
   }
   public static void closeConnection()
   {
	   if(con!=null)
		try {
			con.close();
			System.out.println("database close success");
		} catch (SQLException e) {
			System.out.println("close failure");
			e.printStackTrace();
		}
   }
}
