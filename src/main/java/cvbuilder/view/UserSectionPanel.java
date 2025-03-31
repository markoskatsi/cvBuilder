/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.controller.UserAddControls;
import cvbuilder.model.CVData;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author marko
 */
public class UserSectionPanel extends JPanel {

    private ArrayList<String> data;
    private ArrayList<UserSectionRow> userPanels = new ArrayList<>();
    
    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public ArrayList<UserSectionRow> getUserPanels() {
        return userPanels;
    }

    public UserSectionPanel(String name) {
        this.setName(name);
        this.setBorder(new TitledBorder(name));
        this.setLayout(new GridLayout(0, 1)); 

        switch (name.toLowerCase()) {
            case "title":
                this.setData(CVData.getInstance().getUserTitles());
                break;
            case "name":
                this.setData(CVData.getInstance().getUserNames());
                break;
            case "email":
                this.setData(CVData.getInstance().getUserEmails());
                break;
        }
        
        for (String value : data) {
            UserSectionRow userPanel = new UserSectionRow(name, value);
            userPanels.add(userPanel);
            this.add(userPanel); 
        }
        this.add(new UserAddControls(this));
    }

    public void addUserRow(UserSectionRow row) {
        this.removeAll();
        userPanels.add(row);
        for (UserSectionRow panel : userPanels) {
            this.add(panel);
        }
        this.add(new UserAddControls(this));
        this.revalidate();
        this.repaint();
    }
}

