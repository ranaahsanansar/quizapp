/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
