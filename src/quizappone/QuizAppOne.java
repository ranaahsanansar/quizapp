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
    static Scanner input = new Scanner(System.in).useDelimiter("\n");

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
            System.out.println("3. Show Teacher in Sorted Form");
            System.out.println("4. Show Student in Sorted Form");
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
                    int teacherId;
                    System.out.println("Teacher Mode");
                    System.out.print("Enter Name: ");
                    name = input.next();
                    System.out.print("Enter Age: ");
                    age = input.nextInt();
                    System.out.print("Enter Teacher ID: ");
                    teacherId = input.nextInt();
                    Teacher teacher = new Teacher(name, age , teacherId);

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
                            case 4 -> {
                                int id;
                                System.out.println("Enter Question No");
                                id = input.nextInt();
                                teacher.delete(id);
                                break;
                            }
                            case 5 -> {
                                System.out.println("----------------------------------");
                                teacher.showAllQuestion();
                                break;
                            }
                            default -> {
                                System.out.print("Invalid!");
                                flag2 = false;
                                break;
                            }

                        }
                    }

                    break;
                }
                case 2 -> {

                    boolean flag2 = true;
                    int roll_number;
                    System.out.println("Student Mode\n\n");
                    System.out.print("Enter Name: ");
                    name = input.next();
                    System.out.print("Enter Age: ");
                    age = input.nextInt();
                    System.out.print("Enter Roll Number: ");
                    roll_number = input.nextInt();

                    Student student = new Student(name, age, roll_number);

                    while (flag2) {
                        System.out.println("1. AttemptQuiz");
                        System.out.println("2. Show All Students Result");
                        caseNo = input.nextInt();

                        switch (caseNo) {
                            case 1 -> {
                                student.attempt_Q();
                                break;
                            }
                            case 2 -> {
                                student.showListOfStudents();
                            }
                            default -> {
                                System.out.println("Invalid");

                            }
                        }

                    }

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
