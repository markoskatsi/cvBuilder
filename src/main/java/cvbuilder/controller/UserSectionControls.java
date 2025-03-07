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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marko
 */
public class UserSectionControls implements ActionListener{

    public UserSectionPanel getView() {
        return view;
    }

    public void setView(UserSectionPanel view) {
        this.view = view;
    }

    UserSectionPanel view;
    
    public UserSectionControls(UserSectionPanel usr) {
        this.view = usr;
    }
    
    @Override
    public void actionPerformed(ActionEvent s) {
        //System.out.println(s.getActionCommand());
        UserSectionRow sectionRow = (UserSectionRow) view.getParent();
        
        String oldText = view.getJrb().getText();
        ArrayList<String> data = sectionRow.getData();
        switch(s.getActionCommand()) {
            case "edit":
                String newText = JOptionPane.showInputDialog(
                        MainViewer.getInstance(),
                        "Enter the new value for: ", oldText
                );
                //handle blank/cancel
                if (newText != null & !newText.isBlank()) {
                    data.set(data.indexOf(oldText), newText);
                } 
                
                CVData.getInstance().modelChanged();
                break;
            case "delete":
                data.remove(oldText);
                CVData.getInstance().modelChanged();
                break;
            default:
                throw new UnsupportedOperationException("Unknown action command: "+ s.getActionCommand());
        }
    }
}
