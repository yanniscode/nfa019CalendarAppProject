package fr.cnam.pmain;

import fr.cnam.pbuttons.CalendarControlButtonsPanel;
import fr.cnam.pcalendarpanel.CalendarPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

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

        // *** composant du calendrier
        this.calendarPanel = new CalendarPanel();

        this.add(this.mainLabel);
        this.add(this.controlBtnPanel);
        this.add(this.calendarPanel);
    }



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


    /**
     *
     * @param calendarPanel
     */
    public void setCalendarPanel(CalendarPanel calendarPanel) {
        this.calendarPanel = calendarPanel;
    }


    @Override
    /**
     * @return void - check du Composant - à utiliser ??
     */
    public void displayMainPanel() {
        // TODO implement here
    }

}