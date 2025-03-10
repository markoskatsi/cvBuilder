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
public class UserSectionPanel extends JPanel {
    
    private ArrayList<String> data;
    ButtonGroup bg = new ButtonGroup();
    ArrayList<UserSectionRow> userPanels = new ArrayList();
    
     public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public ArrayList<UserSectionRow> getUserPanels() {
        return userPanels;
    }
    
    public UserSectionPanel(String name)
    {
        this.setName(name);
        this.setBorder(new TitledBorder(name));
        this.setLayout(new GridLayout(0,1));
        
//        for (CVData u : CVData.getInstance().getUserNames())
//        {
//
//            UserSectionRow rowPanel = new UserSectionRow(u, this.getName());
//            rowPanels.add(rowPanel);
//            rowPanel.setActionListener();
//            bg.add(rowPanel.getJrb());
//            this.add(rowPanel);
//        }
        
        switch (name.toLowerCase()) {
            case "title": 
                this.setData(CVData.getInstance().getUserTitles());
                for (String title : CVData.getInstance().getUserTitles()) {
                    UserSectionRow userPanel = new UserSectionRow(name, title);
                    userPanels.add(userPanel);
                    userPanel.setActionListener();
                    this.add(userPanel);
                }
                this.add(new AddUser());
                break;
            case "name":
                this.setData(CVData.getInstance().getUserNames());
                for (String n : CVData.getInstance().getUserNames()) {
                    UserSectionRow userPanel = new UserSectionRow(name, n);
                    userPanels.add(userPanel);
                    userPanel.setActionListener();
                    this.add(userPanel);
                }
                this.add(new AddUser());
                break;
            case "email":  
                this.setData(CVData.getInstance().getUserEmails());
                for (String email : CVData.getInstance().getUserEmails()) {
                    UserSectionRow userPanel = new UserSectionRow(name, email);
                    userPanels.add(userPanel);
                    userPanel.setActionListener();
                    this.add(userPanel);
                }
                this.add(new AddUser());
                break;
        }
        
    }

    public ArrayList<UserSectionRow> getRowPanels() {
        return userPanels;
    }

    public void setRowPanels(ArrayList<UserSectionRow> rowPanels) {
        this.userPanels = rowPanels;
    }
    
} 