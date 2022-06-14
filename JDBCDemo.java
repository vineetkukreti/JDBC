package jdbcDatadase;
import java.sql.*;
import java.util.*;
public class JDBCDemo 
{
   Connection con=null;
   Statement stmt=null;
   JDBCDemo() throws ClassNotFoundException, SQLException
   {
     Scanner sc = new Scanner(System.in);
      Class.forName("com.mysql.cj.jdbc.Driver");
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb1","root","");
       System.out.println("Enter Department number:");
       stmt=con.createStatement();
       int vardno = sc.nextInt();
       ResultSet rs=stmt.executeQuery("select * from pers where dno =" + vardno);
       System.out.println("Below is the list of employee working in Deptt No."+ vardno);
       System.out.println("Employee Code\t Employee Name\t Designation   \t Department No.");
       while(rs.next())
       {
           System.out.print(rs.getInt("empcode") + "       \t");
           System.out.print(rs.getString("empname")+ "       \t");
           System.out.print(rs.getString("designation")+ "   \t");
           System.out.println(rs.getInt("dno"));
        }
       con.close();
       sc.close();
     }
     public static void main(String[] args) 
     {
	// TODO Auto-generated method stub
	try{
		new JDBCDemo();
	   }
	catch(Exception e)
   	   { 
		e.printStackTrace();
		
   	   }
    }

}
