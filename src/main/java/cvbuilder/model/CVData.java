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
    
    private ArrayList<User> users = new ArrayList();
    private static CVData instance;
    private ArrayList<Observer> observers = new ArrayList<>();
    
    public ArrayList<Observer> getObservers() {
        return observers;
    }
    
    public void modelChanged() {
        for (Observer o: observers) {
        o.update();
        }
    }

    public static CVData getInstance(){
        if (instance==null){
            instance = new CVData();
        }
        return instance;
    }

    
    /*private CVData(){
    }
        this.loadDataFromCSVFile("userprofile.csv")
    }*/
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    //helper method to delete User bu the User.id field
    public void deleteUserById(String id) {
        for (User u: users) {
            if (u.getId().equals(id)) {
                users.remove(u);
                break;
            }
        }
    }
    
    //helper method to update a User based on User.id and a new value
    public void updateByIdAndField(String id, String fieldName, String newValue) {
        for (User u : users) {
            if(u.getId().equals(id)) {
                User.set(fieldName, u, newValue);
                break;
            }
        }
    }
    
    public void loadDataFromCSVFile(String filename) {
        try(BufferedReader in = new BufferedReader(new FileReader(filename));) {
            while (in.ready()) {
                String cSVline = in.readLine();
                
                String[] values = cSVline.split(",");
                
                User u = new User();
                u.setId(values[0]);
                u.setTitle(values[1]);
                u.setName(values[2]);
                u.setEmail(values[3]);
                
                this.users.add(u);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readCSV(String filename) {
        users.clear();
        
        try(BufferedReader br = new BufferedReader(new FileReader(filename));)
        { 
            String line;
            while((line = br.readLine()) != null )
            {
                String[] info = line.split(",");
                users.add(new User(info[0], info[1],info[2],info[3]));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void writeCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) 
        {
            for (User u : users) 
            {
                writer.println(u.getTitle() + "," + u.getName() + "," + u.getEmail());
            }
            System.out.println("File saved!"); //testing it ran
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
