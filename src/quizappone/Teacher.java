/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizappone;

import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author Rana Ahsan Ansar
 */
public class Teacher extends Person {

    public Teacher(String name, int age) {
        super(name, age);
    }

    public void insert() throws SQLException {
        if (mode == true) {
            System.out.println("Enter Question No: ");
            Mcqs question = new Mcqs(9, "What is Your Name", "AhsanCaptain", "Ahmed", "Ali", "Umar", 1);
            QuestionDBImp database = new QuestionDBImp();
            database.insertQuestion(question);
        }

    }
    
    

    public void delete(int id) {
        if (mode == true){
            System.out.println("Delete Question of Id = " + id);
            if (id <= 10 && id > 0) {
                QuestionDBImp database = new QuestionDBImp();
                database.delete(id);
            }
            else {
                System.out.println("Invalid ID!");
            }
            
        }

    }

    public void update(Mcqs Q, int id) {

    }

}
