package fr.cnam.pmain;

import fr.cnam.pactivity.ActivityFormFrame;
import fr.cnam.pbuttons.CalendarControlButton;
import fr.cnam.pbuttons.CalendarControlButtonsPanel;
import fr.cnam.pcalendarpanel.CalendarPanel;
import fr.cnam.putils.penums.ErrorMessage;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Yannis Guéguen
 */
public class MainPanel extends Container implements MainPanelInterface {

    /**
     * Default constructor
     */
    public MainPanel() throws SQLException, ClassNotFoundException {

        super();

        FlowLayout glMain = new FlowLayout(FlowLayout.CENTER, 1000, 50);
        this.setLayout(glMain);

        this.calendarMainTitle = "Le Calendrier des Lunaires";

        this.mainLabel = new JLabel(this.calendarMainTitle);
        this.mainLabel.setFont(new Font("Serif", 0, 20));

        // *** composant des boutons de contrôle du calendrier - note: le MainPanel est passé en paramètre au ControlButtonsPanel (this):
        this.controlBtnPanel = new CalendarControlButtonsPanel(this);

        this.add(this.mainLabel);
        this.add(this.controlBtnPanel);
        this.add(calendarPanel);

    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * JLabel - Container du Titre principal
     */
    private JLabel mainLabel;

    /**
     * String - Titre principal
     */
    private String calendarMainTitle;

    /**
     * CalendarPanel - Container du Calendrier (= liste de DateButtons)
     */
    private static CalendarPanel calendarPanel;

    static {
        try {
            calendarPanel = new CalendarPanel();
        } catch (SQLException | ClassNotFoundException throwables) {
            Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());
            logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, throwables.getStackTrace());
        }
    }

    /**
     * ControlButtonsPanel - Container du Panneau de ControlButton
     */
    private CalendarControlButtonsPanel controlBtnPanel;



    /**
     * @return CalendarPanel
     */
    public static CalendarPanel getCalendarPanel() {
        return calendarPanel;
    }

    public static void setCalendarPanel(CalendarPanel calendarPanelInserted) {
        calendarPanel = calendarPanelInserted;
    }


    @Override
    /**
     * @return void - check du Composant - à utiliser ??
     */
    public void displayMainPanel() {
        this.logger.log(Level.INFO, () -> "info (displayFormControlBtn): "+ this.mainLabel +" - "+ this.controlBtnPanel);
    }

}