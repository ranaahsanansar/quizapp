/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizappone;
import java.sql.*;

/**
 *
 * @author Rana Ahsan Ansar
 */
public class QuestionDBImp  {
//    Create Table if not available in DataBase ------------
    public void createQuestionsTable(){
        
        Connection connection = null;
        Statement statement = null;
        String Querry = "CREATE TABLE `quizapp`.`questions` ( `id` INT(100) NOT NULL ,  `question` TEXT NOT NULL ,  `opt1` TEXT NOT NULL ,  `opt2` TEXT NOT NULL ,  `opt3` TEXT NOT NULL ,  `opt4` TEXT NOT NULL ,  `correct` INT(10) NOT NULL ,    PRIMARY KEY  (`id`))";
        try{
            connection = CreatConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(Querry);
            System.out.println("Secces");
        }catch (SQLException e){
            System.out.println("DataBase is already in DataBase");
        }
        
    }
    
//    Insert New Question in Database 
    
    public void insertQuestion(Mcqs question) throws SQLException{
        Connection connection = null;
        PreparedStatement prepareStatement = null;
//        ------------------------
//        INSERT INTO `questions` (`id`, `question`, `opt1`, `opt2`, `opt3`, `opt4`, `correct`) VALUES ('question.getId()', 'question.getQuestion()', 'question.getOpt1()', 'question.getOpt2()', 'question.getOpt3()', 'question.getOpt4()', 'question.getCorrect()');

//        System.out.println(querry);
           
            
            try{
        connection = CreatConnection.getConnection();
         prepareStatement = connection.prepareStatement("INSERT INTO `questions` (`id`, `question`, `opt1`, `opt2`, `opt3`, `opt4`, `correct`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            prepareStatement.setString(1, question.getOpt1());
            prepareStatement.setString(2, question.getQuestion());
            prepareStatement.setString(3, question.getOpt1());
            prepareStatement.setString(4, question.getOpt2());
            prepareStatement.setString(5, question.getOpt3());
            prepareStatement.setString(6, question.getOpt4());
            prepareStatement.setString(7, question.getCorrect());
            prepareStatement.executeUpdate();
                System.out.println("Inserted");
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
