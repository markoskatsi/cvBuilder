/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.model;

import cvbuilder.view.Observer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private ArrayList<Observer> observers = new ArrayList<>();

    private static CVData instance;

    public static CVData getInstance() {
        if (instance == null) {
            instance = new CVData();
        }
        return instance;
    }

    private CVData() {
        // this.loadDataFromCSVFile("data/cv_repo_2.csv");
    }

    public ArrayList<String> getUserNames() {
        return userNames;
    }

    public ArrayList<String> getUserTitles() {
        return userTitles;
    }

    public ArrayList<String> getUserEmails() {
        return userEmails;
    }

    public ArrayList<String> getCoreSkills() {
        return coreSkills;
    }

    public void setCoreSkills(ArrayList<String> coreSkills) {
        this.coreSkills = coreSkills;
    }

    public ArrayList<String> getProfileStatements() {
        return profileStatements;
    }

    public void setProfileStatements(ArrayList<String> profileStatements) {
        this.profileStatements = profileStatements;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void modelChanged() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void loadDataFromCSVFile(File filename) {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            while (in.ready()) {
                String cSVline = in.readLine();
                String[] values = cSVline.split(",");

                switch (values[0].toLowerCase()) {
                    case "user":
                        switch (values[1].toLowerCase()) {
                            case "name":
                                userNames.clear();
                                // Format: User,Name,Scheherazade Taylor,SJ Taylor,Shaz Taylor
                                for (int i = 2; i < values.length; i++) {
                                    userNames.add(values[i]);
                                }
                                break;
                            case "title":
                                userTitles.clear();
                                // Format: User,Title,Ms.,Miss
                                for (int i = 2; i < values.length; i++) {
                                    userTitles.add(values[i]);
                                }
                                break;
                            case "email":
                                userEmails.clear();
                                // Format: User,Email,strongshaz@bob.com,gmail_account@gmail.com,k1234567@kingston.ac.uk
                                for (int i = 2; i < values.length; i++) {
                                    userEmails.add(values[i]);
                                }
                                break;
                        }
                        break;

                    case "core competencies":
                        switch (values[1].toLowerCase()) {
                            case "skills":
                                coreSkills.clear();
                                for (int i = 2; i < values.length; i++) {
                                    String skills = values[i].replace("////", ",");
                                    coreSkills.add(skills);
                                    System.out.println(skills);
                                }
                                break;
                            case "profile statement":
                                profileStatements.clear();
                                for (int i = 2; i < values.length; i++) {
                                    String statement = values[i].replace("////", ",");
                                    profileStatements.add(statement);
                                    System.out.println(statement);
                                }
                                break;
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNewCSVFile(File file) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            if (!userNames.isEmpty()) {
                writer.print("User,Name");
                for (String name : userNames) {
                    writer.print("," + name);
                }
                writer.println();
            }

            if (!userTitles.isEmpty()) {
                writer.print("User,Title");
                for (String title : userTitles) {
                    writer.print("," + title);
                }
                writer.println();
            }

            if (!userEmails.isEmpty()) {
                writer.print("User,Email");
                for (String email : userEmails) {
                    writer.print("," + email);
                }
                writer.println();
            }

            if (!coreSkills.isEmpty()) {
                writer.print("Core Competencies,Skills");
                for (String skill : coreSkills) {
                    writer.print("," + skill.replace(",", "////")); 
                }
                writer.println();
            }

            if (!profileStatements.isEmpty()) {
                writer.print("Core Competencies,Profile Statement");
                for (String statement : profileStatements) {
                    writer.print("," + statement.replace(",", "////"));
                }
                writer.println();
            }

            System.out.println("File saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
