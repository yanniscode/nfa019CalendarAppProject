package fr.cnam.pmain;

import fr.cnam.pactivity.DateActivityItem;
import fr.cnam.pbuttons.ControlButtonsPanel;
import fr.cnam.pcalendarpanel.CalendarPanel;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

import static java.awt.FlowLayout.CENTER;

/**
 * @author Yannis Guéguen
 */
public class MainPanel  extends JPanel implements MainPanelInterface {


    /**
     * Default constructor
     */
    public MainPanel() {

        super();

        FlowLayout glMain = new FlowLayout(CENTER, 1000, 50);
        setLayout(glMain);

        this.calendarMainTitle = "Le Calendrier des Lunaires\n";

        this.mainLabel = new JLabel(this.calendarMainTitle);
        this.mainLabel.setFont(new Font("Serif", 0, 20));
        add(this.mainLabel);

        this.controlBtnPanel = new ControlButtonsPanel(this);
        setSize(300, 200);

        add(this.controlBtnPanel);

        this.calendarPanel = new CalendarPanel();
//        System.out.println(this.calendarPanel.hashCode());

        this.setSize(1600, 900  );

        add(this.calendarPanel);
    }

    /**
     * Logger - infos
     */
//    private static Logger logger = Logger.getLogger(TestLog4j1.class);

    /**
     * String - Titre principal
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

//    /**
//     *
//     * @param controlBtnPanel
//     */
//    public void setControlBtnPanel(ControlButtonsPanel controlBtnPanel) {
//        controlBtnPanel = controlBtnPanel;
//        return;
//    }

    /**
     * @return CalendarPanel
     */
    public static CalendarPanel getCalendarPanel() {
        return calendarPanel;
    }


//    /**
//     *
//     * @param calendarPanel
//     */
//    public void setCalendarPanel(CalendarPanel calendarPanel) {
//
//        calendarPanel = calendarPanel;
//    //    add(this.calendarPanel);
//
//        // TODO implement here
//        return;
//    }

    /**
     * @return String - Calendar Main Title
     */
    public static String getCalendarMainTitle() {
        return calendarMainTitle;
    }

//    /**
//     * @param calendarMainTitle
//     */
//    public void setCalendarMainTitle(String calendarMainTitle) {
//        calendarMainTitle = calendarMainTitle;
//        return;
//    }


    @Override
    /**
     * @return void - check du Composant - à utiliser ??
     */
    public void displayMainPanel() {
        return;
    }

}