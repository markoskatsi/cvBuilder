/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.controller.CoreSectionControls;
import cvbuilder.model.CVData;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author marko
 */
public class CoreSectionRow extends JPanel{

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    private ArrayList<String> data;
    
    public JRadioButton getJrb() {
        return jrb;
    }

    public void setJrb(JRadioButton jrb) {
        this.jrb = jrb;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }
    
    private JRadioButton jrb;
    private JButton editButton;
    private JButton deleteButton;
    private CVData model;    
    CoreSectionControls controller;
    private JTextArea textArea;
    
    public CoreSectionRow(String name, String value) {
        this.setName(name);
        CoreSectionControls controller = new CoreSectionControls(this);

        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        editButton.setActionCommand("edit");
        editButton.addActionListener(controller);

        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(controller);

        this.setLayout(new FlowLayout());

        if (name.equalsIgnoreCase("profile statement")) {
            textArea = new JTextArea(value);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(350, 70)); 

            jrb = new JRadioButton();

            this.add(jrb);
            this.add(scrollPane); 
            this.add(editButton);
            this.add(deleteButton);
        } else {
            jrb = new JRadioButton(value);
            this.add(jrb);
            this.add(editButton);
            this.add(deleteButton);
        }
        
        jrb.addActionListener(e -> {
            if (jrb.isSelected()) {
                switch (this.getName().toLowerCase()) {
                    case "skills":
                        CVData.getInstance().setSelectedSkill(jrb.getText());
                        break;
                    case "profile statement":
                        CVData.getInstance().setSelectedProfileStatement(this.getTextArea().getText());
                        break;
                }
            }
        });
    }
    
    public JTextArea getTextArea() {
        return textArea;
    }

    public void setActionListener() {
        editButton.addActionListener(controller);
    }
}
