/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.CVData;
import cvbuilder.view.UserSectionPanel;
import cvbuilder.view.UserSectionRow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author marko
 */
public class UserAddControls extends JPanel implements ActionListener {
    private UserSectionPanel view;
    private JTextField tf;
    private JButton jb;

    public UserAddControls(UserSectionPanel view) {
        this.view = view;
        tf = new JTextField(15);
        jb = new JButton("Add");
     
        jb.setActionCommand("add");
        jb.addActionListener(this); 
        
        this.add(tf);
        this.add(jb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newData = tf.getText().trim();
        
        if (!newData.isEmpty()) { 
            UserSectionRow newRow = new UserSectionRow(view.getName(), newData);
            view.addRow(newRow); 
            
            switch (view.getName().toLowerCase()) {
                case "title":
                    CVData.getInstance().getUserTitles().add(newData);
                    break;
                case "name":
                    CVData.getInstance().getUserNames().add(newData);
                    break;
                case "email":
                    CVData.getInstance().getUserEmails().add(newData);
                    break;
            }
            CVData.getInstance().modelChanged();
            tf.setText("");
        }
    }
}