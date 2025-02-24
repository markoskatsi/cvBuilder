/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author marko
 */
public class MainViewer extends JFrame{
    private static MainViewer instance;
    
    private UserRow nameEdit;
    
    UserProfileBuilderTabs upbTabs;
    private JPanel coreTab;

    public UserProfileBuilderTabs getUpbTabs() {
        return upbTabs;
    }

    public void setUpbTabs(UserProfileBuilderTabs upbTabs) {
        this.upbTabs = upbTabs;
    }
    
    public static MainViewer getInstance(){
      if (instance==null){
           instance = new MainViewer();
      }
      return instance;
    }
    
        
    private MainViewer() {
        //creating window
        this.setLayout(new BorderLayout());
        this.setTitle("User Profile Builder");
        this.setSize(450, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add menu bar
        MenuBar mb = new MenuBar();
        this.setJMenuBar(mb.getMb());
        
                
        /*//creating border and its layout
        nameEdit = new JPanel();
        Border panelBorder = BorderFactory.createTitledBorder("Name");
        nameEdit.setBorder(panelBorder);
        nameEdit.setLayout(new GridLayout(0,1));
        this.add(nameEdit,BorderLayout.CENTER);
        
        //Adding all tabs
        JTabbedPane tabs = new JTabbedPane();
        id = new JPanel();
        id.setBorder(BorderFactory.createTitledBorder("ID"));
        id.setLayout(new GridLayout(0,1));
        tabs.addTab("User ID", id);
        
        title = new JPanel();
        title.setBorder(BorderFactory.createTitledBorder("Title"));
        title.setLayout(new GridLayout(0,1));
        tabs.addTab("User Title", title);
        
        tabs.addTab("User Name", nameEdit);
        email = new JPanel();
        email.setBorder(BorderFactory.createTitledBorder("Email"));
        email.setLayout(new GridLayout(0,1));
        tabs.addTab("User Email", email);
        this.add(tabs);*/
        
        // Add the panels for each profile on username.csv
        
        //this.createEditPanel();
        this.createTabbedPane();
        //this.createEditPanel();
        

        this.setVisible(true);
    }
    
    public void createTabbedPane() {
    // Check if the main tab pane exists and remove it if it does
    if (upbTabs != null) {
        this.remove(upbTabs);
    }

    upbTabs = new UserProfileBuilderTabs();
    coreTab = new JPanel();

    JTabbedPane UserTabbedPane = new JTabbedPane();

    UserTabbedPane.addTab("User", upbTabs);
    UserTabbedPane.addTab("Core Competencies", coreTab);

    this.add(UserTabbedPane, BorderLayout.CENTER);
    
    this.revalidate();
    this.repaint();
}
    
    
    public void createEditPanel(){
        // delete all tabs
        if (nameEdit != null) {
            this.remove(nameEdit);
        }
        //create UserRow with RowPanels   
        nameEdit = new UserRow("title");
        this.add(nameEdit,BorderLayout.CENTER);
        this.revalidate();
    }
}