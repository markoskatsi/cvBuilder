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
public class CoreSectionPanel extends JPanel {
    
    private ArrayList<String> data;
    ButtonGroup bg = new ButtonGroup();
    ArrayList<CoreSectionRow> corePanels = new ArrayList();
    
     public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public ArrayList<CoreSectionRow> getCorePanels() {
        return corePanels;
    }
    
    public CoreSectionPanel(String name)
    {
        this.setName(name);
        this.setBorder(new TitledBorder(name));
        this.setLayout(new GridLayout(0,1));
        
        switch (name.toLowerCase()) {
            case "skills":
                this.setData(CVData.getInstance().getCoreSkills());
                break;
            case "profile statement":
                this.setData(CVData.getInstance().getProfileStatements());
                break;
        }
        
        for (String item : data) {
            CoreSectionRow corePanel = new CoreSectionRow(name, item);
            corePanels.add(corePanel);
            this.add(corePanel); 
        }
    }

    public ArrayList<CoreSectionRow> getRowPanels() {
        return corePanels;
    }

    public void setRowPanels(ArrayList<CoreSectionRow> rowPanels) {
        this.corePanels = rowPanels;
    }
    
} 