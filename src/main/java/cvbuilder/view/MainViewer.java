/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author marko
 */
public class MainViewer extends JFrame{
    private static MainViewer instance;
    
    private UserSectionPanel nameEdit;
    UserSectionTabs upbTabs;
    CoreSectionTabs coreTabs;
    
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
        this.setSize(600, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // add menu bar
        MenuBar mb = new MenuBar();
        this.setJMenuBar(mb.getMb());
        
        // Add the panels for each profile on cv_repo_2.csv
        this.createTabbedPanes();
        this.setVisible(true);
    }
    
    public void createTabbedPanes() {
        // clearing everything within the jframe
        this.getContentPane().removeAll();
        
        // Check if the main tab pane exists and remove it if it does
        if (upbTabs != null) {
            this.remove(upbTabs);
        }

        if (coreTabs != null) {
            this.remove(coreTabs);
        }

        //tabbed panes
        upbTabs = new UserSectionTabs();
        coreTabs = new CoreSectionTabs();

        JTabbedPane mainTabs = new JTabbedPane();
        mainTabs.addTab("User", upbTabs);
        mainTabs.addTab("Core Competencies", coreTabs);    

        this.add(mainTabs, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
}