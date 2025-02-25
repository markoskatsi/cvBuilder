/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.model.CVData;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author marko
 */
public class UserPanel extends JPanel implements ActionListener{

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
    
    public UserPanel(String name, String value){
        this.setName(name);
        
        jrb = new JRadioButton(value);
        
        editButton = new JButton("Edit");
        editButton.addActionListener(this);
        editButton.setActionCommand("Edit");

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        deleteButton.setActionCommand("Delete");
        
        this.setLayout(new FlowLayout());
        this.add(jrb);
        jrb.addActionListener(this);
        jrb.setActionCommand("Radio");
        this.add(editButton);
        this.add(deleteButton);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        String newValue = null;
        switch (ac) 
        {
            case "Edit": 
                switch(this.getName()) {
            case "Title":
                newValue = JOptionPane.showInputDialog(null, "Enter Your Text:", jrb.getText());
                    break;
            case "Email":
                newValue = JOptionPane.showInputDialog(null, "Enter Your Text:", jrb.getText());
                    break;
            case "Name":
                newValue = JOptionPane.showInputDialog(null, "Enter Your Text:", jrb.getText());
                    break;        
        }
            
//            if (newValue != null) 
//            {
//                //setting the model values depending on what has been changed by the user
//                System.out.println("User input: "+newValue);
//                
//                switch (this.getName()) {
//                    case "Title":
//                        model.setTitle(newValue);
//                        this.getJrb().setText(model.getTitle());
//                        break;
//                    case "Email":
//                        model.setEmail(newValue);
//                        this.getJrb().setText(model.getEmail());
//                        break;
//                    case "Name":
//                        model.setName(newValue);
//                        this.getJrb().setText(model.getName());
//                        break;
//        }
//                jrb.setText(newValue);
////                //printing out tabbed pane users after change
////                for (User u : CVData.getInstance().getUsers()) 
////                    {
////                        System.out.println(u.getName());
////                    }
//            }
//            else 
//            {
//                System.out.println("User cancelled the input.");
//            }    
            //System.out.println(CVData.getInstance().getUsers());
            break;
            
            case "Delete": 
            int response = JOptionPane.showConfirmDialog(null,"Would you like to delete user?");
            if (response==JOptionPane.YES_OPTION) 
            {
               // CVData.getInstance().getUsers().remove(model);
                MainViewer.getInstance().createTabbedPane();
            }
            //System.out.println(CVData.getInstance().getUsers());
            break;
//            case "Radio":
//                //need to idnetify which row it is on
//               // int index = CVData.getInstance().getUsers().indexOf(this.model);
//                for (EditPanel ep : MainViewer.getInstance().getUpbTabs().getEps()) {
//                    ep.getRowPanels().get(index).getJrb().setSelected(true);
//                }
//                        break;
        }
        
    }

    public void setActionListener() {
        editButton.addActionListener(this);
    }
}
