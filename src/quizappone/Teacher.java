/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizappone;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static quizappone.QuizAppOne.input;

/**
 *
 * @author Rana Ahsan Ansar
 */
public class Teacher extends Person {

    public Teacher(String name, int age) {
        super(name, age);
        mode = true;
    }

    public void insert() throws SQLException {
        QuestionDBImp database = new QuestionDBImp();
        if (mode == true) {
//          Crate Variables 
            String questionInsert, opt1, opt2, opt3, opt4;
            int correctAnswer;
            for (int i = 0; i <= 10; i++) {
                System.out.print("Enter Question: ");
                questionInsert = input.next();
                System.out.print("Enter option 1: ");
                opt1 = input.next();
                System.out.print("Enter option 2: ");
                opt2 = input.next();
                System.out.print("Enter option 3: ");
                opt3 = input.next();
                System.out.print("Enter option 4: ");
                opt4 = input.next();
                System.out.print("Enter Correct Option Number(Integer):");

                try {
                    correctAnswer = input.nextInt();
                    Mcqs question = new Mcqs(i, questionInsert, opt1, opt2, opt3, opt4, correctAnswer);
                    database.insertQuestion(question);
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                }

            }

        }

    }

    public void delete(int id) {
        if (mode == true) {
            System.out.println("Delete Question of Id = " + id);
            if (id <= 10 && id > 0) {
                QuestionDBImp database = new QuestionDBImp();
                database.delete(id);
            } else {
                System.out.println("Invalid ID!");
            }

        }
    }

    public void update(int id) {
        if (mode == true) {
            Mcqs question = new Mcqs(id, "What is Your Name", "AhsanCaptain", "Ahmed", "Ali", "Umar", 1);
            QuestionDBImp database = new QuestionDBImp();

            database.update(question, id);

        } else {
            System.out.println("You are in Student Mode");
        }
    }

    public void emptyQuiz() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = CreatConnection.getConnection();
            statement = connection.createStatement();
            statement.execute("​TRUNCATE TABLE `quizapp`.`questions`");
            System.out.println("Old Quiz Cleared");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
