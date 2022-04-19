
package quizappone;

import java.sql.*;

/**
 *
 * @author Rana Ahsan Ansar
 */
public class QuestionDBImp implements Questions {
//    Create Table if not available in DataBase ------------

    @Override
    public void createQuestionsTable() {

        Connection connection ;
        Statement statement ;
        String Querry = "CREATE TABLE `quizapp`.`questions` ( `id` INT(100) NOT NULL ,  `question` TEXT NOT NULL ,  `opt1` TEXT NOT NULL ,  `opt2` TEXT NOT NULL ,  `opt3` TEXT NOT NULL ,  `opt4` TEXT NOT NULL ,  `correct` INT(10) NOT NULL ,    PRIMARY KEY  (`id`))";
        try {
            connection = CreatConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(Querry);
            System.out.println("Secces");
        } catch (SQLException e) {
            System.out.println("DataBase is already in DataBase");
        }

    }

//    Insert New Question in Database ----------------------------------
    @Override
    public void insertQuestion(Mcqs question) {
        Connection connection ;
        PreparedStatement prepareStatement ;
//        ------------------------
//        INSERT INTO `questions` (`id`, `question`, `opt1`, `opt2`, `opt3`, `opt4`, `correct`) VALUES ('question.getId()', 'question.getQuestion()', 'question.getOpt1()', 'question.getOpt2()', 'question.getOpt3()', 'question.getOpt4()', 'question.getCorrect()');

//        System.out.println(querry);
        try {
            connection = CreatConnection.getConnection();
            prepareStatement = connection.prepareStatement("INSERT INTO `questions` (`id`, `question`, `opt1`, `opt2`, `opt3`, `opt4`, `correct`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            prepareStatement.setInt(1, question.getId());
            prepareStatement.setString(2, question.getQuestion());
            prepareStatement.setString(3, question.getOpt1());
            prepareStatement.setString(4, question.getOpt2());
            prepareStatement.setString(5, question.getOpt3());
            prepareStatement.setString(6, question.getOpt4());
            prepareStatement.setInt(7, question.getCorrect());
            prepareStatement.executeUpdate();
            System.out.println("Inserted");

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void delete(int id) {
        Connection connection ;
        PreparedStatement preparedStatement ;

        try {

            connection = CreatConnection.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `questions` WHERE `questions`.`id` = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Question Deleted!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Mcqs question, int id) {
        Connection connection ;
        PreparedStatement preparedStatement ;

        try {
            connection = CreatConnection.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `questions` SET `question` = ? , `opt1` = ?, `opt2` = ?, `opt3` = ?, `opt4` = ?, `correct` = ? WHERE `questions`.`id` = ?");

            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getOpt1());
            preparedStatement.setString(3, question.getOpt2());
            preparedStatement.setString(4, question.getOpt3());
            preparedStatement.setString(5, question.getOpt4());
            preparedStatement.setInt(6, question.getCorrect());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
            System.out.println("Question Updated SuccesFully");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Mcqs selectById(int id) {
        Mcqs question = new Mcqs();
        Connection connection ;
        PreparedStatement preparedStatement ;
        ResultSet resultSet ;

        try {
            connection = CreatConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `questions` WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                question.setId(resultSet.getInt("id"));
                question.setQuestion(resultSet.getString("question"));

                question.setOpt1(resultSet.getString("opt1"));
                question.setOpt2(resultSet.getString("opt2"));
                question.setOpt3(resultSet.getString("opt3"));
                question.setOpt4(resultSet.getString("opt4"));

                question.setCorrect(resultSet.getInt("correct"));

            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e);
        }

        return question;
    }

    protected void deleteAll() {
        Connection connection;
        Statement statement ;

        try {
            connection = CreatConnection.getConnection();
            statement = connection.createStatement();
            statement.execute("DELETE FROM questions");
            System.out.println("Old Quiz Cleared");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    protected void showAll() {
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = CreatConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `questions`");

            while (resultSet.next()) {
                System.out.println("Question No#:: " + resultSet.getInt("id"));
                System.out.println("Question: " + resultSet.getString("question"));
                System.out.println("------------------------------------------");
                System.out.println("------------------------------------------");
                System.out.println("------------------------------------------");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
