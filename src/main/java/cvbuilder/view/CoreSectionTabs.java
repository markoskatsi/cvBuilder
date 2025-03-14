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
public class CoreSectionTabs extends JTabbedPane {
    ArrayList<CoreSectionPanel> eps = new ArrayList();

    public ArrayList<CoreSectionPanel> getEps() {
        return eps;
    }

    public void setEps(ArrayList<CoreSectionPanel> eps) {
        this.eps = eps;
    }
    
    public CoreSectionTabs() {
        CoreSectionPanel skillPanel = new CoreSectionPanel("Skills");
        CoreSectionPanel statementPanel = new CoreSectionPanel("Profile Statement");
        this.eps.add(skillPanel);
        this.eps.add(statementPanel);
        for (CoreSectionPanel ep : this.eps) {
            this.add(ep);
        }
    }
}
