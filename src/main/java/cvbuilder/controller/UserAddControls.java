/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.view.UserSectionPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author marko
 */
public class UserAddControls implements ActionListener{

    UserSectionPanel view;

    public UserSectionPanel getView() {
        return view;
    }

    public void setView(UserSectionPanel view) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Add button on " + view.getData());
    }
    
    
}
