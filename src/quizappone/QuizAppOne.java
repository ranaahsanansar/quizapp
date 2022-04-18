/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quizappone;

//import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Rana Ahsan Ansar
 */
public class QuizAppOne {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        int caseNo = 0;
        boolean flag = true;
        String name;
        int age;

        System.out.println("Welcome To Quiz Application");
        System.out.println("Rana Ahsan Ansar 70077960");
        System.out.println("Abdullah Usman 70079106");
        System.out.println("Auns Mehmood 70077518");
        System.out.println("Java Project 6th B");
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");

        while (flag) {
            System.out.println("\n\nSelect Mode");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            try {
                caseNo = input.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Invalid Key");
                exit();
            }
            switch (caseNo) {
                case 1 -> {
                    boolean flag2 = true;
                    System.out.println("Teacher Mode");
                    System.out.println("Enter Name: ");
                    name = input.next();
                    System.out.println("Enter Age: ");
                    age = input.nextInt();
                    Teacher teacher = new Teacher(name, age);
                    
                    while (flag2) {
                        System.out.println("\n1. Create Quiz");
                    System.out.println("2. Show List of Students");
                    System.out.println("3. Update Question");
                    System.out.println("4.Delete Question");
                    System.out.println("5. Show List of Question");
                    System.out.println("6. Exit");
                    caseNo = input.nextInt();
                    switch (caseNo) {
                        case 1 -> {
                            teacher.emptyQuiz();
                            System.out.println("Only Ten Questions are allowed");
                            teacher.insert();
                            break;
                        }
                        case 2 -> {
                            teacher.showListOfStudents();
                            break;
                        }
                        case 3 -> {
                            int id;
                            System.out.print("Enter Question No: ");
                            id = input.nextInt();
                            teacher.update(id);
                            break;
                        }
                        default -> {

                        }

                    }
                    }
                    
                    break;
                }
                case 2 -> {
                    System.out.println("Teacher Mode");
                    break;
                }
                default -> {
                    System.out.println("Invalid");
                    break;
                }

            }
        }

    }

    private static void exit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
