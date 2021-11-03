import java.sql.*;
import java.util.*;

import java.sql.DriverManager;

public class Demo{
    public static void main(String[] args)
    {
      Scanner sc = new Scanner(System.in);
      try {
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:movie.db");
        if(con!=null)
        {
          Statement stmt = con.createStatement();
       String sql = "update Movies set Movieactor='Ranbir Kapoor' where Moviename='sanju'";
          String sql1 = "delete from Movies where Moviename='gangleader'";
          int n = stmt.executeUpdate(sql);
          System.out.println(n+"records updated");
          
          
          //retrieving
          PreparedStatement pstmt = con.prepareStatement("select * from Movies");
          ResultSet result = pstmt.executeQuery();
          System.out.println("Moviename  Movieactor Movieactress Moviedirector Movieyear");
          System.out.println("**************************************************");
          while(result.next())
          {
            System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getInt(5));
          }
          con.close();
     
          
          //Inserting Statements
      /*    stmt.executeUpdate("create table Movies(Moviename text primary key,Movieactor text,Movieactress text,Moviedirector text,Movieyear int)");
          System.out.println("table created");
          PreparedStatement pstmt = con.prepareStatement("insert into Movies values(?,?,?,?,?)");
          System.out.println("Enter number of Insertions");
          int m=sc.nextInt();
          for(int d=0;d<m;d++) {
          System.out.println("Enter the Movie Name");
          String Moviename = sc.next();
          System.out.println("Enter the Movie Actor");
          String Movieactor = sc.next();
          System.out.println("Enter the Movie Actress");
          String Movieactress = sc.next();
          System.out.println("Enter the Movie Director");
          String Moviedirector = sc.next();
          System.out.println("Enter the Movie Year of Release");
          int Movieyear = sc.nextInt();  
          pstmt.setString(1,Moviename);
          pstmt.setString(2,Movieactor);
          pstmt.setString(3,Movieactress);
          pstmt.setString(4,Moviedirector);
          pstmt.setInt(5,Movieyear);
          int ex = pstmt.executeUpdate();
          System.out.println(ex);}
          */
          }
      }
      catch(Exception e) {
        System.out.println(e);
      }
    }
  }