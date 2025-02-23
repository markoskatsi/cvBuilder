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
    ArrayList<EditPanel> eps = new ArrayList();

    public ArrayList<EditPanel> getEps() {
        return eps;
    }

    public void setEps(ArrayList<EditPanel> eps) {
        this.eps = eps;
    }
    
    public UserProfileBuilderTabs() {
        EditPanel namePanel = new EditPanel("Name");
        EditPanel titlePanel = new EditPanel("Title");
        EditPanel emailPanel = new EditPanel("Email");
        this.eps.add(titlePanel);
        this.eps.add(namePanel);
        this.eps.add(emailPanel);
        for (EditPanel ep : this.eps) {
            this.add(ep);
        }
    }
}
