/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.CVData;
import cvbuilder.view.CoreSectionPanel;
import cvbuilder.view.CoreSectionRow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author marko
 */
public class CoreAddControls extends JPanel implements ActionListener {
    private CoreSectionPanel view;
    private JTextField tf;
    private JButton jb;

    public CoreAddControls(CoreSectionPanel view) {
        this.view = view;
        tf = new JTextField(40);
        jb = new JButton("Add");
     
        jb.setActionCommand("add");
        jb.addActionListener(this); 
        
        this.add(tf);
        this.add(jb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newData = tf.getText().trim();
        
        if (!newData.isEmpty()) { 
            switch (view.getName().toLowerCase()) {
                case "skills":
                    CVData.getInstance().getCoreSkills().add(newData);
                    break;
                case "profile statement":
                    CVData.getInstance().getProfileStatements().add(newData);
                    break;
            }
            CoreSectionRow newRow = new CoreSectionRow(view.getName(), newData);
            view.addCoreRow(newRow); 
            
            CVData.getInstance().modelChanged();
            tf.setText("");
        }
    }
}