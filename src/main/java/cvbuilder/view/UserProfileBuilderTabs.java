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
    ArrayList<UserRow> eps = new ArrayList();

    public ArrayList<UserRow> getEps() {
        return eps;
    }

    public void setEps(ArrayList<UserRow> eps) {
        this.eps = eps;
    }
    
    public UserProfileBuilderTabs() {
        UserRow namePanel = new UserRow("Name");
        UserRow titlePanel = new UserRow("Title");
        UserRow emailPanel = new UserRow("Email");
        this.eps.add(titlePanel);
        this.eps.add(namePanel);
        this.eps.add(emailPanel);
        for (UserRow ep : this.eps) {
            this.add(ep);
        }
    }
}
