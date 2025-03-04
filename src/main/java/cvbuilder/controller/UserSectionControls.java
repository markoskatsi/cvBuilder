/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.CVData;
import cvbuilder.view.MainViewer;
import cvbuilder.view.UserSectionPanel;
import cvbuilder.view.UserSectionRow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author marko
 */
public class UserSectionControls implements ActionListener{

    public UserSectionRow getView() {
        return view;
    }

    public void setView(UserSectionRow view) {
        this.view = view;
    }

    UserSectionRow view;
    
    public UserSectionControls(UserSectionRow usr) {
        this.view = usr;
    }
    
    @Override
    public void actionPerformed(ActionEvent s) {
        //System.out.println(s.getActionCommand());
        UserSectionRow sectionPanel = (UserSectionRow) view.getParent();
        
//        String oldText = view.getErb().getText();
        String[] cmds = s.getActionCommand().split("-");
        switch(cmds[0]) {
            case "edit":
                //pop up dialog and process user input
                //to do put current text into dialog
                System.out.println("Editing user: " + cmds[2]);
                String newText = JOptionPane.showInputDialog(
                        MainViewer.getInstance(),
                        "Enter the new value for: " + cmds[1]
                );
                //handle blank/cancel
                if (newText != null & !newText.isBlank()) {
                    //CVData.getInstance().updateByIdAndField(cmds[2],cmds[1],newText);
                    CVData.getInstance().modelChanged();
                } 
                break;
            case "delete":
                System.out.println("Deleting user: " + cmds[2]);
                CVData.getInstance().deleteUserById(cmds[1], cmds[3]);
                CVData.getInstance().modelChanged();
                break;
            default:
                throw new UnsupportedOperationException("Unknown action command: "+ s.getActionCommand());
        }
    }
}
