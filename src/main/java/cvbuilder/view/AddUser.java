/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

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
public class AddUser extends JPanel implements ActionListener{
    
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
        
        jb.setActionCommand("submit");
        jb.addActionListener(this);
        
        this.add(tf);
        this.add(jb);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            System.out.println(tf.getText());
            tf.setText("");
        }
    }
}
