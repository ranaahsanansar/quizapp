/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizappone;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Rana Ahsan Ansar
 */
public abstract class Person {

    static boolean mode = true;
    String name;
    int age;
    
    Person(){
        name = "Null";
        age = 1;
    }

    Person(String name, int age) {
        if (age < 100 && age > 10) {
            this.age = age;
        }else {
            this.age = 0;
        }
        
        if (name.length() > 3){
            this.name = name;
        }else {
            this.name = "Unknown";
        }
        
    }
    
   protected abstract void result();
   protected abstract List<Person> getList();
   protected abstract void display();
   
}
