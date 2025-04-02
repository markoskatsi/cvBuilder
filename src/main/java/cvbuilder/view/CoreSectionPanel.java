/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.controller.CoreAddControls;
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
    private ButtonGroup bg = new ButtonGroup();
    private ArrayList<CoreSectionRow> corePanels = new ArrayList();
    
    public ButtonGroup getBg() {
        return bg;
    }
    
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
        
        for (String value : data) {
            CoreSectionRow corePanel = new CoreSectionRow(name, value);
            corePanels.add(corePanel);
            bg.add(corePanel.getJrb());
            this.add(corePanel); 
        }
        this.add(new CoreAddControls(this));
    }
    
    public void addCoreRow(CoreSectionRow row) {
        this.removeAll();
        corePanels.add(row);
        for (CoreSectionRow panel : corePanels) {
            this.add(panel);
        }
        this.add(new CoreAddControls(this));
        this.revalidate();
        this.repaint();
    }

    public ArrayList<CoreSectionRow> getRowPanels() {
        return corePanels;
    }

    public void setRowPanels(ArrayList<CoreSectionRow> rowPanels) {
        this.corePanels = rowPanels;
    }
    
} 