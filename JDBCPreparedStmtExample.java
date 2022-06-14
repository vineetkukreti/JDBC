package jdbcDatadase;
import java.sql.*;

public class JDBCPreparedStmtExample{
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            //STEP 2: Register JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Step 3: Open a Connection
            conn = DriverManager.getConnection("dbc:mysql://localhost:3306//employeedb1");

            //Step 4: Execute a query
            System.out.println("Creating statement...");
            String sql = "UPDATE pers set empcode=? WHERE empname=?";
            stmt = conn.prepareStatement(sql);

            //Bind values into the parameters.
            stmt.setInt(1, 222); //This will set age
            stmt.setString(2, "DDD"); // This will set ID

            //lets update age of the record with Id = 102
            int rows = stmt.executeUpdate();
            System.out.println("Rows impacted : "+rows);

            //lets select all the records and display them.
            sql = "SELECT * FROM Employeedb";
            ResultSet rs = stmt.executeQuery(sql);

            //Step 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id = rs.getInt("empcode");
                int age = rs.getInt("dno");
                String first = rs.getString("empname");
                String last = rs.getString("designation");

                //Display values
                System.out.println("ID: "+id);
                System.out.println(", Age: "+age);
                System.out.println(",First: "+first);
                System.out.println(", Last: "+last);
            }
            //Step 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle Errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){}//nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end JDBCExample