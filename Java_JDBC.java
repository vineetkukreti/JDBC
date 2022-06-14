package jdbcDatadase;
import java.sql.*;
public class Java_JDBC {
	Connection con = null;
	Statement stmt = null;
	Java_JDBC() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb1","root","");
		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from pers");
		System.out.println("Employee Code\t Employee Name\t Designation   \t Department No.");
		 while(rs.next())
	       {
	           System.out.print(rs.getInt("empcode") + "       \t");
	           System.out.print(rs.getString("empname")+ "       \t");
	           System.out.print(rs.getString("designation")+ "   \t");
	           System.out.println(rs.getInt("dno"));
	        }
	       con.close();
	       
	}
	public static void main(String[] args) {
		
		try {
		new Java_JDBC();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
