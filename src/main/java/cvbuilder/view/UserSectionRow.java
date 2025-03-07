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
public class UserSectionRow extends JPanel {
    
     public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    private ArrayList<String> data;
    
    ButtonGroup bg = new ButtonGroup();
    ArrayList<UserSectionPanel> userPanels = new ArrayList();
    
    public UserSectionRow(String name)
    {
        this.setName(name);
        //Border panelBorder = BorderFactory.createTitledBorder("Name");
        TitledBorder panelBorder2 = new TitledBorder(name);
        
        this.setBorder(panelBorder2);
        this.setLayout(new GridLayout(0,1));
        
//        for (CVData u : CVData.getInstance().getUserNames())
//        {
//
//            UserSectionPanel rowPanel = new UserSectionPanel(u, this.getName());
//            rowPanels.add(rowPanel);
//            rowPanel.setActionListener();
//            bg.add(rowPanel.getJrb());
//            this.add(rowPanel);
//        }
        
        switch (name.toLowerCase()) {
            case "title": 
                for (String title : CVData.getInstance().getUserTitles()) {
                    UserSectionPanel userPanel = new UserSectionPanel(name, title);
                    userPanels.add(userPanel);
                    userPanel.setActionListener();
                    this.add(userPanel);
                }
                this.add(new AddUser());
                break;
            case "name":  
                for (String n : CVData.getInstance().getUserNames()) {
                    UserSectionPanel userPanel = new UserSectionPanel(name, n);
                    userPanels.add(userPanel);
                    userPanel.setActionListener();
                    this.add(userPanel);
                }
                this.add(new AddUser());
                break;
            case "email":  
                for (String email : CVData.getInstance().getUserEmails()) {
                    UserSectionPanel userPanel = new UserSectionPanel(name, email);
                    userPanels.add(userPanel);
                    userPanel.setActionListener();
                    this.add(userPanel);
                }
                this.add(new AddUser());
                break;
        }
        
    }

    public ArrayList<UserSectionPanel> getRowPanels() {
        return userPanels;
    }

    public void setRowPanels(ArrayList<UserSectionPanel> rowPanels) {
        this.userPanels = rowPanels;
    }
    
} 