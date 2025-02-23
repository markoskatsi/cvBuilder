/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.model.User;
import cvbuilder.model.UserGroup;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author marko
 */
public class EditPanel extends JPanel {
    
    ButtonGroup bg = new ButtonGroup();
    ArrayList<RowPanel> rowPanels = new ArrayList();
    
    public EditPanel(String name)
    {
        this.setName(name);
        //Border panelBorder = BorderFactory.createTitledBorder("Name");
        TitledBorder panelBorder2 = new TitledBorder(this.getName());
        
        this.setBorder(panelBorder2);
        this.setLayout(new GridLayout(0,1));
        
        for (User u : UserGroup.getInstance().getUsers())
        {

            RowPanel rowPanel = new RowPanel(u, this.getName());
            rowPanels.add(rowPanel);
            rowPanel.setActionListener();
            bg.add(rowPanel.getJrb());
            this.add(rowPanel);
        }
        
    }

    public ArrayList<RowPanel> getRowPanels() {
        return rowPanels;
    }

    public void setRowPanels(ArrayList<RowPanel> rowPanels) {
        this.rowPanels = rowPanels;
    }
    
} 