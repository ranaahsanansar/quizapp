/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quizappone;
import java.sql.*;
/**
 *
 * @author Rana Ahsan Ansar
 */
public class QuizAppOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRus = null;
        String url = "jdbc:mysql://localhost:3306/quizapp";
        
        try {
            myConn = DriverManager.getConnection(url, "root" , "");
            myStmt = myConn.createStatement();
            myRus = myStmt.executeQuery("Select * from questions");
            
            while (myRus.next()){
                System.out.println(myRus.getString("question"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (myRus != null){
            
                myRus.close();
            }
            if (myStmt != null){
            
                myStmt.close();
            }
        }
    }
    
}
