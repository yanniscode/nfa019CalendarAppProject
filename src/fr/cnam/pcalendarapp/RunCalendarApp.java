package fr.cnam.pcalendarapp;

import fr.cnam.pmain.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

        JFrame runAppFrame = new JFrame();

        runAppFrame.setSize(1920, 1080);
        runAppFrame.setLocation(0,0);
        String calendarTitle = "Le Calendrier des Lunaires";
        runAppFrame.setTitle(calendarTitle);

        mainPanel = new MainPanel();

        Container runAppContainer = runAppFrame.getContentPane();
        runAppContainer.add(mainPanel);

        WindowListener l = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            };
        };

        this.addWindowListener(l);

        runAppFrame.setVisible(true);

        // *** fermeture effective du programme si on le quitte
        runAppFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    /**
     * MainPanel
     */
    private static MainPanel mainPanel;




    /**
     * @param args 
     * @return void
     */
    public static void main (String[] args) throws SQLException, ClassNotFoundException {
        RunCalendarApp runCalendarApp = new RunCalendarApp();
    }

}