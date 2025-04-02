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
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;



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
    JMenuItem previewCV;
    JMenuItem exportPDF;
    JMenuItem exportWord;
    JMenuItem quit;
    
    public MenuBar(){
    mb = new JMenuBar();
    fileMenu = new JMenu("File");
    cvMenu = new JMenu("CV options");
    
    openFile = new JMenuItem("Open CSV file...");
    saveFile = new JMenuItem("Save As CSV File As...");
    previewCV = new JMenuItem("Preview Custom CV...");
    exportPDF = new JMenuItem("Export CV as PDF...");
    exportWord = new JMenuItem("Export CV as Word...");
    quit = new JMenuItem("Quit");
    
    //register listeners with menu items
    openFile.addActionListener(this);
    saveFile.addActionListener(this);
    previewCV.addActionListener(this);
    exportPDF.addActionListener(this);
    exportWord.addActionListener(this);
    quit.addActionListener(this);
    
    openFile.setActionCommand("OpenFile");
    saveFile.setActionCommand("SaveAs");
    previewCV.setActionCommand("PreviewCV");
    exportPDF.setActionCommand("ExportPDF");
    exportWord.setActionCommand("ExportWord");
    quit.setActionCommand("Quit");
    
    fileMenu.add(openFile);
    fileMenu.add(saveFile);
    fileMenu.add(quit);
    cvMenu.add(previewCV);
    cvMenu.add(exportPDF);
    cvMenu.add(exportWord);
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
            case "PreviewCV":
                //format of cv preview
                String cvText = "Custom CV Preview\n\n";
                
                cvText += "Personal Information\n";
                cvText += CVData.getInstance().getSelectedTitle()+" ";
                cvText += CVData.getInstance().getSelectedName()+"\n";
                cvText += CVData.getInstance().getSelectedEmail()+"\n\n";

                cvText += "Core Competencies\n";
                cvText += CVData.getInstance().getSelectedProfileStatement() + "\n";
                cvText += "Skills: " + CVData.getInstance().getSelectedSkill();
                
                System.out.println(cvText);

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
                case "ExportPDF":
                    JFileChooser pdfChooser = new JFileChooser(Paths.get(System.getProperty("user.dir"), "data").toFile());
                    FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("PDF Files", "pdf");
                    pdfChooser.setFileFilter(pdfFilter);    
                    int returnPDFVal = pdfChooser.showSaveDialog(null);
                    if (returnPDFVal == JFileChooser.APPROVE_OPTION) {
                        File pdfToSave = pdfChooser.getSelectedFile();
                        pdfToSave = new File(pdfToSave.getAbsolutePath() + ".pdf");
                        
                        // creating pdf document
                        try {
                            PdfWriter writer = new PdfWriter(pdfToSave);
                            PdfDocument pdfDoc = new PdfDocument(writer);
                            Document document = new Document(pdfDoc);

                            String cvContent = "Custom CV\n\n";
                
                            cvContent += "Personal Information\n";
                            cvContent += CVData.getInstance().getSelectedTitle()+" ";
                            cvContent += CVData.getInstance().getSelectedName()+"\n";
                            cvContent += CVData.getInstance().getSelectedEmail()+"\n\n";

                            cvContent += "Core Competencies\n";
                            cvContent += CVData.getInstance().getSelectedProfileStatement() + "\n";
                            cvContent += "Skills: " + CVData.getInstance().getSelectedSkill();

                            // adding to pdf document
                            document.add(new Paragraph(cvContent));

                            document.close();

                            JOptionPane.showMessageDialog(null, "CV has been successfully exported to PDF!", 
                                "Export Successful", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                break;
                case "ExportWord":
                    JFileChooser wordChooser = new JFileChooser(Paths.get(System.getProperty("user.dir"), "data").toFile());
                    FileNameExtensionFilter wordFilter = new FileNameExtensionFilter("Word Documents", "docx");
                    wordChooser.setFileFilter(wordFilter);    
                    int returnWordVal = wordChooser.showSaveDialog(null);
                    if (returnWordVal == JFileChooser.APPROVE_OPTION) {
                        File wordToSave = wordChooser.getSelectedFile();
                        wordToSave = new File(wordToSave.getAbsolutePath() + ".docx");

                        try (XWPFDocument doc = new XWPFDocument()) {
                            XWPFParagraph paragraph = doc.createParagraph();
                            XWPFRun run = paragraph.createRun();

                            String cvContent = "Custom CV\n\n";
                
                            cvContent += "Personal Information\n";
                            cvContent += CVData.getInstance().getSelectedTitle()+" ";
                            cvContent += CVData.getInstance().getSelectedName()+"\n";
                            cvContent += CVData.getInstance().getSelectedEmail()+"\n\n";

                            cvContent += "Core Competencies\n";
                            cvContent += CVData.getInstance().getSelectedProfileStatement() + "\n";
                            cvContent += "Skills: " + CVData.getInstance().getSelectedSkill();

                            // adding text with the correct line breaks
                            for (String line : cvContent.split("\n")) {
                                run.setText(line);
                                run.addBreak();
                            }

                            // writing to the file
                            try (FileOutputStream out = new FileOutputStream(wordToSave)) {
                                doc.write(out);
                            }

                            JOptionPane.showMessageDialog(null, "CV has been successfully exported to Word document!", 
                                    "Export Successful", JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    break;
            case "Quit":
                System.exit(0);
                break;
        }
    }
}
