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
}
