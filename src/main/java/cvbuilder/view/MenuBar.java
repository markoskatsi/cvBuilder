/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.model.UserGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author marko
 */
public class MenuBar extends JMenuBar implements ActionListener{

    public JMenuBar getMb() {
        return mb;
    }

    public void setMb(JMenuBar mb) {
        this.mb = mb;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public JMenuItem getOpenFile() {
        return openFile;
    }

    public void setOpenFile(JMenuItem openFile) {
        this.openFile = openFile;
    }

    public JMenuItem getQuit() {
        return quit;
    }

    public void setQuit(JMenuItem quit) {
        this.quit = quit;
    }
    private JMenuBar mb;
    private JMenu fileMenu;
    JMenuItem openFile;
    JMenuItem saveFile;
    JMenuItem quit;
    
    public MenuBar(){
    mb = new JMenuBar();
    fileMenu = new JMenu("File");
    
    openFile = new JMenuItem("Open file...");
    saveFile = new JMenuItem("Save File...");
    quit = new JMenuItem("Quit");
    
    //register listeners with menu items
    openFile.addActionListener(this);
    saveFile.addActionListener(this);
    quit.addActionListener(this);
    
    openFile.setActionCommand("OpenFile");
    saveFile.setActionCommand("SaveFile");
    quit.setActionCommand("Quit");
    
    fileMenu.add(openFile);
    fileMenu.add(saveFile);
    fileMenu.add(quit);
    mb.add(fileMenu);
    }
    private File file;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "OpenFile":
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "CSV Files", "csv");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal==JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                    UserGroup.getInstance().readCSV("userprofile.csv");
                    MainViewer.getInstance().createTabbedPane();
                }
                break;
            case "Quit":
                System.exit(0);
                break;
            case "SaveFile":
                UserGroup.getInstance().writeCSV(file.getAbsolutePath());
                break;
                
        }
    }
}
