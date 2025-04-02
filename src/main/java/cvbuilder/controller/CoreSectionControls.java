  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.controller;

import cvbuilder.model.CVData;
import cvbuilder.view.CoreSectionPanel;
import cvbuilder.view.CoreSectionRow;
import cvbuilder.view.MainViewer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author marko
 */
public class CoreSectionControls implements ActionListener {

    public CoreSectionRow getView() {
        return view;
    }

    public void setView(CoreSectionRow view) {
        this.view = view;
    }

    CoreSectionRow view;

    public CoreSectionControls(CoreSectionRow usr) {
        this.view = usr;
    }

    @Override
    public void actionPerformed(ActionEvent s) {
        // Getting the parent section panel of the coresectionrow clicked on
        CoreSectionPanel sectionPanel = (CoreSectionPanel) view.getParent();

        String oldSkillsText = view.getJrb().getText();
        String oldTextAreaText = null;
        
        if (view.getTextArea() != null) {
            oldTextAreaText = view.getTextArea().getText();
        }
        
        ArrayList<String> data = sectionPanel.getData();
        
        switch (s.getActionCommand()) {
            case "edit":
                if (view.getTextArea() != null) {
                    // Creating a JTextArea so the user can see all of the oldText
                    JTextArea textAreaForDialog = new JTextArea(oldTextAreaText);
                    textAreaForDialog.setLineWrap(true);
                    textAreaForDialog.setWrapStyleWord(true);
                    textAreaForDialog.setEditable(true);
                    textAreaForDialog.setPreferredSize(new Dimension(400, 150));

                    // Putting it in a scrollable panel
                    JScrollPane scrollPane = new JScrollPane(textAreaForDialog);

                    int option = JOptionPane.showConfirmDialog(
                        MainViewer.getInstance(),
                        scrollPane,
                        "Edit Profile Statement",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                    );

                    if (option == JOptionPane.OK_OPTION) {
                        String newTextArea = textAreaForDialog.getText();

                        if (newTextArea != null && !newTextArea.isBlank()) {
                            data.set(data.indexOf(oldTextAreaText), newTextArea);
                            view.getTextArea().setText(newTextArea);
                            System.out.println(data);
                        }
                    }
                } else {
                    String newText = JOptionPane.showInputDialog(
                        MainViewer.getInstance(),
                        "Enter the new value for: ", oldSkillsText
                    );

                    if (newText != null && !newText.isBlank()) {
                        data.set(data.indexOf(oldSkillsText), newText);
                        view.getJrb().setText(newText);
                        System.out.println(data);
                    }
                }
                CVData.getInstance().modelChanged();
                break;

            case "delete":
                if (oldTextAreaText != null) {
                    data.remove(oldTextAreaText);
                } else {
                    data.remove(oldSkillsText);
                }
                sectionPanel.getCorePanels().remove(view);
                sectionPanel.remove(view);
                sectionPanel.revalidate();
                sectionPanel.repaint();
                CVData.getInstance().modelChanged();
                break;
            //case "radio":
                //System.out.println("Radio button selected: " + view.getJrb().getText());        
            default:
                throw new UnsupportedOperationException("Unknown action command: " + s.getActionCommand());
        }
    }
}
