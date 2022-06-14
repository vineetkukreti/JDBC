package jdbcDatadase;
import java.sql.*;
import java.util.Scanner;
public class Both_update_Print {

	Connection con = null;
	Statement stmt = null;
	Both_update_Print() throws SQLException,ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in); 
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing","root","");

			PreparedStatement pst = con.prepareStatement("insert into prep values(?,?)");
		//	System.out.print("Enter the name :");
			String name = sc.nextLine();
		//	System.out.print("Enter the Std Id :");
			int n = sc.nextInt();
		    pst.setString(1,name);
		    pst.setInt(2,n);
		    
			int h= pst.executeUpdate();
			System.out.println(h+" records affected"); 

	    
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from prep");
	//	System.out.println("Name              Sec          Gender   ");
		while(rs.next())
		{
			System.out.print(rs.getString(1)+"\t\t");
			System.out.print(rs.getString(2)+"\t\t");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		try
		{
			new Both_update_Print();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
