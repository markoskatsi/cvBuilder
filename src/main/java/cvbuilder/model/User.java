/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.model;

/**
 *
 * @author marko
 */
public class User {

    private String name;
    private String id;
    private String title;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User(String id, String title,String name,String email) {
        this.name = name;
        this.id = id;
        this.title = title;
        this.email = email;
    }
    
    public String toString() {
        return "User { ID = " + id + " , Title = " + title + " , Name = " + name + " , Email = " + email + " }" + "\n";
    }

}