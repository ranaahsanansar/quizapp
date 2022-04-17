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
        Teacher T = new Teacher("Captain" , 22);
        T.insertQuestion();
    }
    
}
