import java.sql.*;

public class ConnMySQL
{

    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        String dbName = "dbad_kol_ksiegarnia";
        String dbUserName = "dbad_s464852";
        String dbPassword = "C0Xp6aofb6";
        String connectionString = "jdbc:mysql://mssql-2017.labs.wmi.amu.edu.pl/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {

           conn = DriverManager.getConnection(connectionString);
           Statement stat = conn.createStatement();
           ResultSet rs = stat.executeQuery("select * from Autorzy");

           while(rs.next()){
               System.out.println(rs.getString("nazwsiko") + " " + rs.getString("kraj"));
           }


        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if(conn != null)
            {
                try
                {
                    conn.close();
                }
                catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}