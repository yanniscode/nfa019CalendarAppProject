package fr.cnam.pcalendarapp;

import fr.cnam.pbuttons.CalendarControlButton;
import fr.cnam.pmain.MainPanel;
import fr.cnam.putils.penums.ErrorMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yannis Guéguen
 */
public class RunCalendarApp extends JFrame {


    /**
     * Default constructor
     */
    public RunCalendarApp() {

        super();

        JFrame runAppFrame = new JFrame();

        runAppFrame.setSize(1920, 1080);
        runAppFrame.setLocation(0,0);
        String calendarTitle = "Le Calendrier des Lunaires";
        runAppFrame.setTitle(calendarTitle);

        Container runAppContainer = runAppFrame.getContentPane();
        runAppContainer.add(mainPanel);

        WindowListener l = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
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

    static {
        try {
            mainPanel = new MainPanel();
        } catch (SQLException | ClassNotFoundException throwables) {
            Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());
            logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, throwables.getStackTrace());
        }
    }


    /**
     * @param args 
     * @return void
     */
    public static void main (String[] args) {
        new RunCalendarApp();
    }

}