/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quizappone;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Rana Ahsan Ansar
 */
public class QuizAppOne {

    /**
     * @param args the command line arguments
     */
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        Teacher T = new Teacher("Captain" , 22);
//        T.insert();
//        T.update(1);
//        System.out.println("Mcq UpdatedMian");
        Student student = new Student("Ahsan" , 22 , 99);
        student.attempt_Q();

    }
    
}
