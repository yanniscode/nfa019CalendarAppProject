package fr.cnam.pcalendarapp;

import fr.cnam.pactivity.DateActivityItem;
import fr.cnam.pmain.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class RunCalendarApp extends JFrame {

    /**
     * Default constructor
     */
    public RunCalendarApp() {

        super("My Calendar App");

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            };
        };

        addWindowListener(l);
        setSize(1920, 1080);
        setVisible(true);
    }

    /**
     * 
     */
    private static MainPanel mainPanel;






    /**
     * @param args 
     * @return
     */
    public static void main (String[] args) {
        System.out.println("Hello Great Calendar Of The World !");

        mainPanel = new MainPanel();

        // Option 1:
//        JFrame calendarFrame = new RunCalendarApp();

        // Option 2: (cf: nfa-035):
        JFrame runAppFrame = new JFrame();

        Container runAppContainer = runAppFrame.getContentPane();
        JLabel runAppLabel = new JLabel();

        String calendarTitle = "Calendar App";

        runAppContainer.add(mainPanel);

        // ******************
        runAppLabel.setForeground(Color.lightGray);

        //
        runAppFrame.setSize(1920, 1080);
        runAppFrame.setLocation(0,0);
        runAppFrame.setTitle(calendarTitle);
        runAppFrame.setVisible(true);

        runAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void getMainPanel() {
        // TODO implement here
        return;
    }

}