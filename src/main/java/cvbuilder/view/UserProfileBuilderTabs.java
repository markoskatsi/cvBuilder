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
public class UserProfileBuilderTabs extends JTabbedPane {
    ArrayList<UserSectionRow> eps = new ArrayList();

    public ArrayList<UserSectionRow> getEps() {
        return eps;
    }

    public void setEps(ArrayList<UserSectionRow> eps) {
        this.eps = eps;
    }
    
    public UserProfileBuilderTabs() {
        UserSectionRow namePanel = new UserSectionRow("Name");
        UserSectionRow titlePanel = new UserSectionRow("Title");
        UserSectionRow emailPanel = new UserSectionRow("Email");
        this.eps.add(titlePanel);
        this.eps.add(namePanel);
        this.eps.add(emailPanel);
        for (UserSectionRow ep : this.eps) {
            this.add(ep);
        }
    }
}
