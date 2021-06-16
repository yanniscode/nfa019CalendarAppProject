package fr.cnam.pcalendarapp;

import fr.cnam.pmain.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Yannis Guéguen
 */
public class RunCalendarApp extends JFrame {

    /**
     * Default constructor
     */
    public RunCalendarApp() {

        super();

        System.out.println("Hello, Great Calendar Of The World !");

        this.mainPanel = new MainPanel();
        System.out.println(this.mainPanel);

        JFrame runAppFrame = new JFrame();
        runAppFrame.setSize(1920, 1080);
        runAppFrame.setLocation(0,0);
        String calendarTitle = "Le Calendrier des Lunaires";
        runAppFrame.setTitle(calendarTitle);
        runAppFrame.setVisible(true);
        runAppFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container runAppContainer = runAppFrame.getContentPane();
        runAppContainer.add(mainPanel);

//        JLabel runAppLabel = new JLabel();
//        runAppLabel.setForeground(Color.lightGray);
//        runAppContainer.add(runAppLabel);

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            };
        };
        addWindowListener(l);

    }

    private static MainPanel mainPanel;
    private static RunCalendarApp runCalendarApp;

    /**
     * @param args 
     * @return
     */
    public static void main (String[] args) {

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