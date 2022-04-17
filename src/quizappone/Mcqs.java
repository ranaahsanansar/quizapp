/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizappone;

/**
 *
 * @author Rana Ahsan Ansar
 */
public class Mcqs {
    private int id;
    private String Question_s;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String correct;
    
    public Mcqs(){
        
    }
    
    public Mcqs(int id , String Question , String opt1, String opt2 , String opt3, String opt4, String correct){
    this.id = id ;
    this.Question_s = Question;
    this.opt1 = opt1;
    this.opt2 = opt2;
    this.opt3 = opt3;
    this.opt4 = opt4;
    this.correct = correct;
    
    }
    
    
}
