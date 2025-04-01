/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.model.CVData;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author marko
 */
public class MenuBar extends JMenuBar implements ActionListener{
    
    private CoreSectionPanel view;

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
    private JMenu cvMenu;
    JMenuItem openFile;
    JMenuItem saveFile;
    JMenuItem createCV;
    JMenuItem quit;
    
    public MenuBar(){
    mb = new JMenuBar();
    fileMenu = new JMenu("File");
    cvMenu = new JMenu("CV options");
    
    openFile = new JMenuItem("Open CSV file...");
    saveFile = new JMenuItem("Save As CSV File As...");
    createCV = new JMenuItem("Create Custom CV...");
    quit = new JMenuItem("Quit");
    
    //register listeners with menu items
    openFile.addActionListener(this);
    saveFile.addActionListener(this);
    createCV.addActionListener(this);
    quit.addActionListener(this);
    
    openFile.setActionCommand("OpenFile");
    saveFile.setActionCommand("SaveAs");
    createCV.setActionCommand("CreateCV");
    quit.setActionCommand("Quit");
    
    fileMenu.add(openFile);
    fileMenu.add(saveFile);
    fileMenu.add(createCV);
    fileMenu.add(quit);
    cvMenu.add(createCV);
    mb.add(fileMenu);
    mb.add(cvMenu);
    }
    private File file;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "OpenFile":
                JFileChooser chooser = new JFileChooser(Paths.get(System.getProperty("user.dir"), "data").toFile());
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "CSV Files", "csv");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal==JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                    CVData.getInstance().loadDataFromCSVFile(file);
                    MainViewer.getInstance().createTabbedPanes();
                }
                break;
            case "SaveAs":
                JFileChooser saveChooser = new JFileChooser(Paths.get(System.getProperty("user.dir"), "data").toFile());
                FileNameExtensionFilter saveFilter = new FileNameExtensionFilter(
                "CSV Files", "csv");
                saveChooser.setFileFilter(saveFilter);    
                int returnSaveVal = saveChooser.showSaveDialog(null);
                if (returnSaveVal == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = saveChooser.getSelectedFile();
                    CVData.getInstance().writeNewCSVFile(fileToSave);
                }
                break;
            case "CreateCV":
                
                //format of cv preview
                String cvText = "Custom CV Preview\n\n";
                
                cvText += "Personal Information\n";
                cvText += CVData.getInstance().getSelectedTitle()+" ";
                cvText += CVData.getInstance().getSelectedName()+"\n";
                cvText += CVData.getInstance().getSelectedEmail()+"\n\n";

                cvText += "Core Competencies\n";
                cvText += CVData.getInstance().getSelectedProfileStatement() + "\n";
                cvText += "Skills: " + CVData.getInstance().getSelectedSkill();

                // creating a text area
                JTextArea textArea = new JTextArea(cvText.toString());
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setPreferredSize(new Dimension(500, 200));

                JOptionPane.showMessageDialog(
                    this, 
                    textArea, 
                    "Custom CV", 
                    JOptionPane.PLAIN_MESSAGE
                );
                break;
            case "Quit":
                System.exit(0);
                break;
        }
    }
}
