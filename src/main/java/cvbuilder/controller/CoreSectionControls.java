/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.CVData;
import cvbuilder.view.CoreSectionPanel;
import cvbuilder.view.CoreSectionRow;
import cvbuilder.view.MainViewer;
import cvbuilder.view.UserSectionPanel;
import cvbuilder.view.UserSectionRow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marko
 */
public class CoreSectionControls implements ActionListener{

    public CoreSectionRow getView() {
        return view;
    }

    public void setView(CoreSectionRow view) {
        this.view = view;
    }

    CoreSectionRow view;
    
    public CoreSectionControls(CoreSectionRow core) {
        this.view = core;
    }
    
    @Override
    public void actionPerformed(ActionEvent s) {
        CoreSectionPanel sectionPanel = (CoreSectionPanel) view.getParent();
        
        String oldText = view.getJrb().getText();
        
        ArrayList<String> data = sectionPanel.getData();
        
        switch(s.getActionCommand()) {
            case "edit":
                String newText = JOptionPane.showInputDialog(
                        MainViewer.getInstance(),
                        "Enter the new value for: ", oldText
                );
                //handle blank/cancel
                if (newText != null & !newText.isBlank()) {
                    data.set(data.indexOf(oldText), newText);
                    view.getJrb().setText(newText);
                    System.out.println(data);
                } 
                
                CVData.getInstance().modelChanged();
                break;
            case "delete":
                data.remove(oldText);
                sectionPanel.remove(view);
                sectionPanel.revalidate();
                sectionPanel.repaint();
                CVData.getInstance().modelChanged();
                break;
            default:
                throw new UnsupportedOperationException("Unknown action command: "+ s.getActionCommand());
        }
    }
}
