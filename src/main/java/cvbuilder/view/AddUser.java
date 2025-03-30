/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.controller.UserAddControls;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author marko
 */
public class AddUser extends JPanel{
    
    private JTextField tf;
    private JButton jb;
    

    public JTextField getTf() {
        return tf;
    }

    public void setTf(JTextField tf) {
        this.tf = tf;
    }

    public JButton getJb() {
        return jb;
    }

    public void setJb(JButton jb) {
        this.jb = jb;
    }
    
    public AddUser() {
        tf = new JTextField(15);
        jb = new JButton("Add");
        
        UserAddControls controller = new UserAddControls();
        
        jb.setActionCommand("add");
        jb.addActionListener(controller);
        
        this.add(tf);
        this.add(jb);
    }
}
