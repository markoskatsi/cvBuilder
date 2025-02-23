/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author marko
 */
public class UserGroup {
    
    private ArrayList<User> users = new ArrayList();
    private static UserGroup instance;
    
    private UserGroup(){
    }
    
        public static UserGroup getInstance(){
        if (instance==null){
            instance = new UserGroup();
        }
        return instance;
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
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
