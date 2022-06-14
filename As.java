package jdbcDatadase;
import java.sql.*;
public class As {
	Connection con = null;
	Statement stmt = null;
     As() throws ClassNotFoundException,SQLException
     {
    	// Class.forName("com.mysql.cj.jdc.Driver");
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
    	 
    	 stmt = con.createStatement();
    	 ResultSet rs = stmt.executeQuery("select * from pers");
    	 System.out.println("Name\t\t\t\tsec\t\tSEX");
    	 while(rs.next())
    	 {
    		 System.out.print(rs.getString("name")+"\t");
    		 System.out.print(rs.getNString("Sec")+"\t\t");
    		 System.out.print(rs.getString("SEX")+"\t");
    		 System.out.println();
    	 }
    	 con.close();

    	 
     }
	public static void main(String[] args) {
		try {
			new As();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    
	}

}
