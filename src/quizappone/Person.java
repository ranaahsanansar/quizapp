/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizappone;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Rana Ahsan Ansar
 */
public abstract class Person {

    static boolean mode = true;
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showListOfStudents() {
//        List<Student> students = new ArrayList();

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
            e.printStackTrace();
        }

    }
}
