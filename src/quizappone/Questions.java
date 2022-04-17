/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package quizappone;

import java.util.List;

/**
 *
 * @author Rana Ahsan Ansar
 */
public interface Questions {
    void createQuestionTable();
    void insertQuestion();
    Mcqs selectById(int id);
    List<Mcqs> selectAll();
    void delete(int id);
    void update(Mcqs Q , int id);
}
