/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder;

import cvbuilder.model.CVData;
import cvbuilder.view.MainViewer;
import java.util.ArrayList;

/**
 *
 * @author marko
 */
public class App {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //read in the data
        CVData ug = CVData.getInstance();
        ug.readCSV("userprofile.csv");
        MainViewer mainView = MainViewer.getInstance(); 
    }
    public static ArrayList<String> names = new ArrayList();
    
}