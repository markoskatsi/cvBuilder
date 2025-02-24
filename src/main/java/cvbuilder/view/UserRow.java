/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.model.CVData;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author marko
 */
public class UserRow extends JPanel {
    
    ButtonGroup bg = new ButtonGroup();
    ArrayList<UserPanel> userPanels = new ArrayList();
    
    public UserRow(String name)
    {
        this.setName(name);
        //Border panelBorder = BorderFactory.createTitledBorder("Name");
        TitledBorder panelBorder2 = new TitledBorder(name);
        
        this.setBorder(panelBorder2);
        this.setLayout(new GridLayout(0,1));
        
//        for (CVData u : CVData.getInstance().getUserNames())
//        {
//
//            UserPanel rowPanel = new UserPanel(u, this.getName());
//            rowPanels.add(rowPanel);
//            rowPanel.setActionListener();
//            bg.add(rowPanel.getJrb());
//            this.add(rowPanel);
//        }
        
        switch (name.toLowerCase()) {
            case "title": 
                for (String title : CVData.getInstance().getUserTitles()) {
                    UserPanel userPanel = new UserPanel(name, title);
                    userPanels.add(userPanel);
                    userPanel.setActionListener();
                    this.add(userPanel);
                }
                break;
            case "name":  
                for (String n : CVData.getInstance().getUserNames()) {
                    UserPanel userPanel = new UserPanel(name, n);
                    userPanels.add(userPanel);
                    userPanel.setActionListener();
                    this.add(userPanel);
                }
                break;
            case "email":  
                for (String email : CVData.getInstance().getUserEmails()) {
                    UserPanel userPanel = new UserPanel(name, email);
                    userPanels.add(userPanel);
                    userPanel.setActionListener();
                    this.add(userPanel);
                }
                break;
        }
        
    }

    public ArrayList<UserPanel> getRowPanels() {
        return userPanels;
    }

    public void setRowPanels(ArrayList<UserPanel> rowPanels) {
        this.userPanels = rowPanels;
    }
    
} 