/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import java.util.ArrayList;
import javax.swing.JTabbedPane;

/**
 *
 * @author marko
 */
public class UserSectionTabs extends JTabbedPane {
    ArrayList<UserSectionPanel> eps = new ArrayList();

    public ArrayList<UserSectionPanel> getEps() {
        return eps;
    }

    public void setEps(ArrayList<UserSectionPanel> eps) {
        this.eps = eps;
    }
    
    public UserSectionTabs() {
        UserSectionPanel namePanel = new UserSectionPanel("Name");
        UserSectionPanel titlePanel = new UserSectionPanel("Title");
        UserSectionPanel emailPanel = new UserSectionPanel("Email");
        this.eps.add(titlePanel);
        this.eps.add(namePanel);
        this.eps.add(emailPanel);
        for (UserSectionPanel ep : this.eps) {
            this.add(ep);
        }
    }
}
