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

    int teacherId;
    
    Teacher(){
        
    }
    
    public Teacher(String name, int age, int teacherId) {
        super(name, age);
        mode = true;
        this.teacherId = teacherId;

    }

    private boolean checkTeacherDB() {
        boolean check = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = CreatConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `teachers` WHERE teacher_id = ? ");
            preparedStatement.setInt(1, this.teacherId);
            resultSet = preparedStatement.executeQuery();
            check = resultSet.next();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e);
        }

        return check;
    }

    private void insertTecherDB() {

        if (!checkTeacherDB()) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = CreatConnection.getConnection();
                preparedStatement = connection.prepareStatement("INSERT INTO `teachers` (`id`, `name`, `age`, `teacher_id`) VALUES (NULL, ?, ?, ? )");

                preparedStatement.setString(1, this.name);
                preparedStatement.setInt(2, this.age);
                preparedStatement.setInt(3, this.teacherId);
                if (preparedStatement.execute()) {
                    System.out.println("Teacher Details Added Into DataBase");
                }

            } catch (Exception e) {
                System.out.println("Error" + e);
            }
        }

    }

    public void insert() throws SQLException {
        insertTecherDB();
        QuestionDBImp database = new QuestionDBImp();
        if (mode == true) {
//          Crate Variables 
            String questionInsert, opt1, opt2, opt3, opt4;
            int correctAnswer;
            for (int i = 1; i <= 10; i++) {
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
//                    e.printStackTrace();
                    System.out.println(e);
                }

            }

        }

    }

    public void delete(int id) {
        if (mode == true) {
            System.out.println("Deleting Question of Id = " + id);
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
            String question_s, opt1, opt2, opt3, opt4;
            int correct_ans;
            System.out.print("Enter new Question:");
            question_s = input.next();
            System.out.println("Enter Options\n1: ");
            opt1 = input.next();
            System.out.println("2: ");
            opt2 = input.next();
            System.out.println("3: ");
            opt3 = input.next();
            System.out.println("4: ");
            opt4 = input.next();
            System.out.println("Enter new Correct Option Number(Integer):");
            correct_ans = input.nextInt();

            Mcqs question = new Mcqs(id, question_s, opt1, opt2, opt3, opt4, correct_ans);
            QuestionDBImp database = new QuestionDBImp();

            database.update(question, id);

        } else {
            System.out.println("You are in Student Mode");
        }
    }

    public void result() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = CreatConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `student`");

            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Roll Number: " + resultSet.getInt("roll_number"));
                System.out.println("Total: " + resultSet.getInt("total"));
                System.out.println("Obtained Marks: " + resultSet.getInt("obt_marks"));
                System.out.println("Persentage: " + resultSet.getInt("persentage") + "%");
                System.out.println("------------------------------------------");
                System.out.println("------------------------------------------");
                System.out.println("------------------------------------------");

            }

        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void emptyQuiz() {
        QuestionDBImp database = new QuestionDBImp();
        database.deleteAll();
    }

    public void showAllQuestion() {
        QuestionDBImp database = new QuestionDBImp();
        database.showAll();

    }

    public List<Person> getList() {
        List<Person> teachers = new ArrayList<>();

        String name_list;
        int tId_list, age_list;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = CreatConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `teachers`");

            while (resultSet.next()) {
                name_list = resultSet.getString("name");
                tId_list = resultSet.getInt("teacher_id");
                age_list = resultSet.getInt("age");

                Teacher getTeacher = new Teacher(name_list, age_list, tId_list);

                teachers.add(getTeacher);

            }

        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e);
        }

        return teachers;
    }

}
