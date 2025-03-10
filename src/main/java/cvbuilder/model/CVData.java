/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.model;

import cvbuilder.view.Observer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author marko
 */

public class CVData {
    
    private ArrayList<String> userNames = new ArrayList<>();
    private ArrayList<String> userTitles = new ArrayList<>();
    private ArrayList<String> userEmails = new ArrayList<>();
    private ArrayList<String> coreSkills = new ArrayList<>();
    private ArrayList<String> profileStatements = new ArrayList<>();

    public ArrayList<String> getUserTitles() {
        return userTitles;
    }

    public ArrayList<String> getUserEmails() {
        return userEmails;
    }
   
    public ArrayList<String> getUserNames() {
        return userNames;
    }
    
    private ArrayList<Observer> observers = new ArrayList<>();
    
    public ArrayList<Observer> getObservers() {
        return observers;
    }
    
    public void modelChanged() {
        for (Observer o: observers) {
        o.update();
        }
    }
    
    private static CVData instance;

    public static CVData getInstance(){
        if (instance==null){
            instance = new CVData();
        }
        return instance;
    }

    
    private CVData(){
    
        this.loadDataFromCSVFile("data/cv_repo_2.csv");
    }

    
    public void updateUserBy() {
       
    }
    
     public void deleteUserBy() {
       
    }
    
    public void loadDataFromCSVFile(String filename) {
        try(BufferedReader in = new BufferedReader(new FileReader(filename));) {
            while (in.ready()) {
                String cSVline = in.readLine();
                
                String[] values = cSVline.split(",");
                switch (values[0].toLowerCase()) {
                    case "user":  
                        switch (values[1].toLowerCase()) {
                            case "name": 
                                //Format 1: User,Name,Scheherazade Taylor,SJ Taylor,Shaz Taylor
                                for (int i=2; i<values.length; i++) {
                                    userNames.add(values[i]);
                                }
                                break;
                            case "title":
                                //Format 2: User,Title,Ms.,Miss
                                for (int i=2; i<values.length; i++) {
                                    userTitles.add(values[i]);
                                }
                                break;
                            case "email":
                                //Format 3: User,Email,strongshaz@bob.com,gmail_account@gmail.com,k1234567@kingston.ac.uk
                                for (int i=2; i<values.length; i++) {
                                    userEmails.add(values[i]);
                                }
                                break;
                        }
                    case "core competencies":
                        switch (values[1].toLowerCase()) {
                            case "skills": 
                                for (int i=2; i<values.length; i++) {
                                    String skills = values[i].replace("////", ",");
                                    coreSkills.add(skills);
                                }
                                break;
                            case "profile statement":
                                for (int i=2; i<values.length; i++) {
                                    String statement = values[i].replace("////", ",");
                                    profileStatements.add(statement);
                                }
                        }
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
//    public void writeCSV(String filename) {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) 
//        {
//            for (User u : users) 
//            {
//                writer.println(u.getTitle() + "," + u.getName() + "," + u.getEmail());
//            }
//            System.out.println("File saved!"); //testing it ran
//        }
//        catch (Exception e) 
//        {
//            e.printStackTrace();
//        }
    //}
    
}
