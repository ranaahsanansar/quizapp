/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizappone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rana Ahsan Ansar
 */
public class Student extends Person {

    int roll_number;
    int total;
    double percentage;
    int percentageInt;
    List<Mcqs> mcqArray = new ArrayList<>();
    private int score;

    Student(String name, int age, int roll_number) {
        super(name, age);
        score = 0;
        total = 0;
        percentage = 0;
        percentageInt = 0;
        mode = false;
        this.roll_number = roll_number;

//        getting Array of Mcqs from DataBase 
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = CreatConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `questions`");

            while (resultSet.next()) {
                Mcqs data = new Mcqs();
                data.setId(resultSet.getInt("id"));
                data.setQuestion(resultSet.getString("question"));

                data.setOpt1(resultSet.getString("opt1"));
                data.setOpt2(resultSet.getString("opt2"));
                data.setOpt3(resultSet.getString("opt3"));
                data.setOpt4(resultSet.getString("opt4"));

                data.setCorrect(resultSet.getInt("correct"));

                mcqArray.add(data);

            }
        } catch (Exception e) {
            System.out.println(e);

            e.printStackTrace();
        }

    }

    private void insertStudent() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = CreatConnection.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `student` (`id`, `roll_number`, `name`, `total`, `obt_marks`, `persentage`) VALUES (NULL, ?, ?, ?, ?, ?)");
            
            preparedStatement.setInt(1, roll_number);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, total);
            preparedStatement.setInt(4, score);
            preparedStatement.setInt(5, percentageInt);
            if (preparedStatement.execute()) {
                System.out.println("Added Done");
            }
            
        }catch (Exception e){
            System.out.println("Error" + e );
        }
    }

    public void attempt_Q() {
//        Put Clear Screen Syntax Here Later

        int answer = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Quiz Starts Now");
        System.out.println("Enter 0 to Next\n\n");

        for (Mcqs Q : mcqArray) {
            total++;
            System.out.println("Question No." + Q.getId() + ". " + Q.getQuestion() + "\n");

            System.out.println("1. " + Q.getOpt1());
            System.out.println("2. " + Q.getOpt2());
            System.out.println("3. " + Q.getOpt3());
            System.out.println("4. " + Q.getOpt4());
            System.out.print("Enter your answer by 1, 2, 3, 4 according to Options given: ");

            try {
                answer = input.nextInt();
                if (answer == Q.getCorrect()) {
                    score++;
                } else if (answer < 5 && answer > 0) {
                    System.out.println("Your answer is Saved");
                } else if (answer > 4 || answer == 0) {
                    System.out.println("Going to Next Question...");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

//            -------------------------------------------------------------------
        }

        System.out.println("Total " + total);
        System.out.println("Your current Score: " + score);
        percentage = (score / total) * 100;
        percentageInt = (int)percentage;
        insertStudent();

    }

}
