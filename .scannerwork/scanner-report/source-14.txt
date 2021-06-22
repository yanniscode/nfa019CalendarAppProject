package fr.cnam.pmain;

import fr.cnam.pbuttons.ControlButtonsPanel;
import fr.cnam.pcalendarpanel.CalendarPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static java.awt.FlowLayout.CENTER;

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
        this.controlBtnPanel = new ControlButtonsPanel(this);
        // *** composant du calendrier
        this.calendarPanel = new CalendarPanel();

        this.add(this.mainLabel);
        this.add(this.controlBtnPanel);
        this.add(this.calendarPanel);
    }

    /**
     * Logger - infos
     */
//    private static Logger logger = Logger.getLogger(TestLog4j1.class);

    /**
     * JLabel - Container du Titre principal
     */
    private static JLabel mainLabel;

    /**
     * Container - container du Calendrier
     */
    private static Container calendarContainer;

    /**
     * String - Titre principal
     */
    private static String calendarMainTitle;

    /**
     * CalendarPanel - Container du Calendrier (= liste de DateButtons)
     */
    private static CalendarPanel calendarPanel;

    /**
     * ControlButtonsPanel - Container du Panneau de ControlButton
     */
    private static ControlButtonsPanel controlBtnPanel;




    // *** AJOUTS:


    //    public void removeCalendarPanel() {
    //        remove(this.calendarPanel);
    //        return;
    //    }


    /**
     * @return ControlButtonsPanel
     */
    public static ControlButtonsPanel getControlBtnPanel() {
        return controlBtnPanel;
    }

    /**
     *
     * @param controlBtnPanel
     */
    public void setControlBtnPanel(ControlButtonsPanel controlBtnPanel) {
        this.controlBtnPanel = controlBtnPanel;
        return;
    }

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
    //    add(this.calendarPanel);
        return;
    }

    /**
     * @return String - Calendar Main Label
     */
    public static JLabel getMainLabel() {
        return mainLabel;
    }

    /**
     * @param mainLabel
     */
    public void setMainLabel(JLabel mainLabel) {
        this.mainLabel = mainLabel;
        return;
    }

    /**
     * @return String - Calendar Main Title
     */
    public static String getCalendarMainTitle() {
        return calendarMainTitle;
    }

    /**
     * @param calendarMainTitle
     */
    public void setCalendarMainTitle(String calendarMainTitle) {
        this.calendarMainTitle = calendarMainTitle;
        return;
    }


    @Override
    /**
     * @return void - check du Composant - à utiliser ??
     */
    public void displayMainPanel() {
        return;
    }

}