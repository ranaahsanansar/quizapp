
package quizappone;


/**
 *
 * @author Rana Ahsan Ansar
 */
public interface Questions {
    void createQuestionsTable();
    void insertQuestion(Mcqs question);
    Mcqs selectById(int id);
    void delete(int id);
    void update(Mcqs Q , int id);
}
