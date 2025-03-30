/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.controller.UserSectionControls;
import cvbuilder.model.CVData;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author marko
 */
public class UserSectionRow extends JPanel{

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    private ArrayList<String> data;
    
    public JRadioButton getJrb() {
        return jrb;
    }

    public void setJrb(JRadioButton jrb) {
        this.jrb = jrb;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }
    
    private JRadioButton jrb;
    private JButton editButton;
    private JButton deleteButton;
    private CVData model;
    
    UserSectionControls controller;
    
    public UserSectionRow(String name, String value){
        this.setName(name);
        
        controller = new UserSectionControls(this);
        
        jrb = new JRadioButton(value);
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        
        jrb.addActionListener(controller);
        jrb.setActionCommand("Radio");
        
        editButton.addActionListener(controller);
        editButton.setActionCommand("edit");
        
        deleteButton.addActionListener(controller);
        deleteButton.setActionCommand("delete");
        
        this.setLayout(new FlowLayout());
        this.add(jrb);
        this.add(editButton);
        this.add(deleteButton);
    }
    
    public void setActionListener() {
        editButton.addActionListener(controller);
    }
}
