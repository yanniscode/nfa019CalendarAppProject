package fr.cnam.pcalendarapp;

import fr.cnam.pdatabase.managment.dao.DateActivityDAO;
import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.pmain.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Yannis Guéguen
 */
public class RunCalendarApp extends JFrame {

    /**
     * Default constructor
     */
    public RunCalendarApp() throws SQLException, ClassNotFoundException {

        super();

        System.out.println("Hello, Great Calendar Of The World !");

        JFrame runAppFrame = new JFrame();

        runAppFrame.setSize(1920, 1080);
        runAppFrame.setLocation(0,0);
        String calendarTitle = "Le Calendrier des Lunaires";
        runAppFrame.setTitle(calendarTitle);

        this.mainPanel = new MainPanel();
//        System.out.println(this.mainPanel);

        Container runAppContainer = runAppFrame.getContentPane();
        runAppContainer.add(this.mainPanel);

//        JLabel runAppLabel = new JLabel();
//        runAppLabel.setForeground(Color.lightGray);
//        runAppContainer.add(runAppLabel);

        WindowListener l = new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            };
        };

        this.addWindowListener(l);

        runAppFrame.setVisible(true);

        // *** fermeture effective du programme si on le quitte
        runAppFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private static MainPanel mainPanel;
    private static RunCalendarApp runCalendarApp;

    /**
     * @param args 
     * @return
     */
    public static void main (String[] args) throws SQLException, ClassNotFoundException {

        runCalendarApp = new RunCalendarApp();

        //        mainPanel = new MainPanel();


//        System.out.println("Hello Great Calendar Of The World !");
//        System.out.println(mainPanel);
//        setMainPanel(mainPanel);
//        System.out.println(getMainPanel());
        // *** Option 1:
//        JFrame calendarFrame = new RunCalendarApp();

        // *** Option 2: (cf: nfa-035):
//        JFrame runAppFrame = new JFrame();

//        Container runAppContainer = runAppFrame.getContentPane();
////        JLabel runAppLabel = new JLabel();
//
//        String calendarTitle = "Le Calendrier des Lunaires";
//
//        runAppContainer.add(mainPanel);
//
////        runAppLabel.setForeground(Color.lightGray);
//
//        runAppFrame.setSize(1920, 1080);
//        runAppFrame.setLocation(0,0);
//        runAppFrame.setTitle(calendarTitle);
//        runAppFrame.setVisible(true);
//
//        runAppFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        return;
    }

//    /**
//     * @return MainPanel
//     */
//    public MainPanel getMainPanel() {
//        return this.mainPanel;
//    }
//
//    /**
//     * @param NewMainPanel
//     * @return void
//     */
//    public  void setMainPanel(MainPanel NewMainPanel) {
//        this.mainPanel = NewMainPanel;
//        return;
//    }

}