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
    
    private UserSectionPanel nameEdit;
    UserSectionTabs upbTabs;
    private JPanel coreTab;
    
    public UserSectionTabs getUpbTabs() {
        return upbTabs;
    }

    public void setUpbTabs(UserSectionTabs upbTabs) {
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
        this.setTitle("CV Builder");
        this.setSize(450, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // add menu bar
        MenuBar mb = new MenuBar();
        this.setJMenuBar(mb.getMb());
        
        // Add the panels for each profile on cv_repo_2.csv
        this.createTabbedPane();
        this.setVisible(true);
    }
    
    public void createTabbedPane() {
    // Check if the main tab pane exists and remove it if it does
    if (upbTabs != null) {
        this.remove(upbTabs);
    }
    
    //tabbed panes
    upbTabs = new UserSectionTabs();
    coreTab = new JPanel();

    JTabbedPane mainTabs = new JTabbedPane();
    mainTabs.addTab("User", upbTabs);
    mainTabs.addTab("Core Competencies", coreTab);    

    this.add(mainTabs, BorderLayout.CENTER);
    this.revalidate();
    this.repaint();
}
    
    
//    public void createEditPanel(){
//        // delete all tabs
//        if (nameEdit != null) {
//            this.remove(nameEdit);
//        }
//        //create UserSectionPanel with RowPanels   
//        nameEdit = new UserSectionPanel("title");
//        this.add(nameEdit,BorderLayout.CENTER);
//        this.revalidate();
//    }
}