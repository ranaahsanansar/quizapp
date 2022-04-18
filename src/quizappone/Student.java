/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizappone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rana Ahsan Ansar
 */
public class Student extends Person {
    
    Student(String name , int age , int roll_number ){
        super(name,age);
        mode = false;
    }
    
    
    public void attempt_Q(){
        List<Mcqs> msqArray = new ArrayList<Mcqs>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = CreatConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `questions`");
            
            while (resultSet.next()){
                Mcqs data = new Mcqs();
                data.setId(resultSet.getInt("id"));
                data.setQuestion(resultSet.getString("question"));
                
                data.setOpt1(resultSet.getString("opt1"));
                data.setOpt2(resultSet.getString("opt2"));
                data.setOpt3(resultSet.getString("opt3"));
                data.setOpt4(resultSet.getString("opt4"));
                
                data.setCorrect(resultSet.getInt("correct"));
                
                msqArray.add(data);
                
            }
        }catch (Exception e){
            System.out.println(e);
            
            e.printStackTrace();
        }
        
        System.out.println("");
        
        
    }
    
}
