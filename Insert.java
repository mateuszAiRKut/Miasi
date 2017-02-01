/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertsql;
import Zapis.GenerateFile;
import java.sql.*;
import sun.rmi.runtime.Log;


public class Insert {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.h2.Driver";  
   static final String DB_URL = "jdbc:h2:tcp://localhost:9092/activiti";

   //  Database credentials
   static final String USER = "sa";
   static final String PASS = "";
   
   public static boolean Login(String first, String last) {
         Connection conn = null;
    Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("org.h2.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      stmt = conn.createStatement();
      //create table
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
//      String sql = "Select * from Registration where first = ' "+first+" ' AND last = '"+last+"'"; 
String sql = "Select * from Registration where first = ' "+first+" '";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String userid = rs.getString("LAST");
				String username = rs.getString("FIRST");

				System.out.println("userid : " + userid);
				System.out.println("username : " + username);

			}
  boolean o =   stmt.execute(sql);
  
      //if (stmt.executeUpdate(sql) != 0 )
          
      
          
          System.out.println("Created table in given database...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      
      /*String sql2 = "INSERT INTO Registration " +
                   "VALUES (100, 'Zara', 'Ali', 18)";
      stmt.executeUpdate(sql2);
      sql2 = "INSERT INTO Registration " +
                   "VALUES (101, 'Mahnaz', 'Fatma', 25)";
      stmt.executeUpdate(sql2);
      sql2 = "INSERT INTO Registration " +
                   "VALUES (102, 'Zaid', 'Khan', 30)";
      stmt.executeUpdate(sql2);
      sql2 = "INSERT INTO Registration " +
                   "VALUES(103, 'Sumit', 'Mittal', 28)";
      stmt.executeUpdate(sql2);
      System.out.println("Inserted records into the table...");*/
      return o;

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
       // o biekt uzytkowni
       //return zykw.has ** uzy);
       return false;
   }
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
       System.out.println(Login("Zara", "Ali"));
   try {
       GenerateFile ob = new GenerateFile();
       ob.getActualTime();
      //STEP 2: Register JDBC driver
      Class.forName("org.h2.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      stmt = conn.createStatement();
      //create table
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      
      /*String sql2 = "INSERT INTO Registration " +
                   "VALUES (100, 'Zara', 'Ali', 18)";
      stmt.executeUpdate(sql2);
      sql2 = "INSERT INTO Registration " +
                   "VALUES (101, 'Mahnaz', 'Fatma', 25)";
      stmt.executeUpdate(sql2);
      sql2 = "INSERT INTO Registration " +
                   "VALUES (102, 'Zaid', 'Khan', 30)";
      stmt.executeUpdate(sql2);
      sql2 = "INSERT INTO Registration " +
                   "VALUES(103, 'Sumit', 'Mittal', 28)";
      stmt.executeUpdate(sql2);
      System.out.println("Inserted records into the table...");*/

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
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
