
package quizappone;
import java.sql.*;
/**
 *
 * @author Rana Ahsan Ansar
 */
public class CreatConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/quizapp";
   
    public static final String USERNAME = "root";
    
    public static final String PASSWORD = "";
 
    public static Connection getConnection() {
        Connection connection = null;
 
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
        }
 
        return connection;
    }
}
