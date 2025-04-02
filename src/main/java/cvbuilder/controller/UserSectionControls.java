/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.CVData;
import cvbuilder.view.MainViewer;
import cvbuilder.view.UserSectionRow;
import cvbuilder.view.UserSectionPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        UserSectionPanel sectionPanel = (UserSectionPanel) view.getParent();
        
        String oldText = view.getJrb().getText();
        
        ArrayList<String> data = sectionPanel.getData();
        
        switch(s.getActionCommand()) {
            case "edit":
                String newText = JOptionPane.showInputDialog(
                        MainViewer.getInstance(),
                        "Enter the new value for: ", oldText
                );
                //handle blank/cancel
                if (newText != null & !newText.isBlank()) {
                    data.set(data.indexOf(oldText), newText);
                    view.getJrb().setText(newText);
                    System.out.println(data);
                } 
                
                CVData.getInstance().modelChanged();
                break;
            case "delete":
                data.remove(oldText);
                sectionPanel.getUserPanels().remove(view);
                sectionPanel.remove(view);
                sectionPanel.revalidate();
                sectionPanel.repaint();
                CVData.getInstance().modelChanged();
                break;
            //case "radio":
                //System.out.println("Radio button selected: " + view.getJrb().getText());
            default:
                throw new UnsupportedOperationException("Unknown action command: "+ s.getActionCommand());
        }
    }
}
