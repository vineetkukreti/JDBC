package jdbcDatadase;
import java.sql.*;
import java.util.*;
public class InsertionInTable {
	Connection con = null;
	Statement stmt = null;
	InsertionInTable() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
//		PreparedStatement pst = con.prepareStatement("insert into pers values(?,?,?)");
//		pst.setString(1, "mukesh");
//		pst.setString(2,"D");
//		pst.setString(3,"L");
//		
		//int i = pst.executeUpdate();
		//System.out.println(i+" records affected");  
//		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from pers");
		System.out.println("Name              Sec          Gender   ");
		while(rs.next())
		{
			System.out.print(rs.getString(1)+"\t\t");
			System.out.print(rs.getString(2)+"\t\t");
			System.out.print(rs.getString(3)+"\t\t");
			System.out.println();
		}
		con.close();
	}

	public static void main(String[] args) {
		try
		{
			new InsertionInTable();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
