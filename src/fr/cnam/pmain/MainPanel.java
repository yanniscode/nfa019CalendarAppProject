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

        this.mainLabel = new JLabel(calendarMainTitle);
        this.mainLabel.setFont(new Font("Serif", 0, 20));
        add(this.mainLabel);
<<<<<<< HEAD

        this.controlBtnPanel = new ControlButtonsPanel(this);
        setSize(300, 200);

        add(this.controlBtnPanel);

        this.calendarPanel = new CalendarPanel();
//        System.out.println(this.calendarPanel.hashCode());

        this.setSize(1600, 900  );

=======

        this.controlBtnPanel = new ControlButtonsPanel(this);
        setSize(300, 200);

        add(this.controlBtnPanel);

        this.calendarPanel = new CalendarPanel();
//        System.out.println(this.calendarPanel.hashCode());

        this.setSize(1600, 900  );

>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
        add(this.calendarPanel);
    }

    /**
     * Logger - infos
     */
//    private static Logger logger = Logger.getLogger(TestLog4j1.class);
<<<<<<< HEAD

    /**
     * String - Titre principal
     */
    private JLabel mainLabel;

    /**
=======

    /**
     * String - Titre principal
     */
    private JLabel mainLabel;

    /**
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
     * Container - container du Calendrier
     */
    private Container calendarContainer;

    /**
     * String - Titre principal
     */
    private String calendarMainTitle;

    /**
     * CalendarPanel - Container du Calendrier (= liste de DateButtons)
     */
    private CalendarPanel calendarPanel;

    /**
     * ControlButtonsPanel - Container du Panneau de ControlButton
     */
    private ControlButtonsPanel controlBtnPanel;




    // *** AJOUTS:


    //    public void removeCalendarPanel() {
    //        remove(this.calendarPanel);
    //        return;
    //    }


    /**
     * @return ControlButtonsPanel
     */
    public ControlButtonsPanel getControlBtnPanel() {
        return this.controlBtnPanel;
<<<<<<< HEAD
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
=======
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
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
     * @return CalendarPanel
     */
    public CalendarPanel getCalendarPanel() {
        return this.calendarPanel;
    }


    /**
     *
     * @param calendarPanel
     */
    public void setCalendarPanel(CalendarPanel calendarPanel) {

        this.calendarPanel = calendarPanel;
    //    add(this.calendarPanel);

        // TODO implement here
        return;
    }

    /**
     * @return String - Calendar Main Title
     */
    public String getCalendarMainTitle() {
        return this.calendarMainTitle;
<<<<<<< HEAD
=======
    }

    /**
     * @param calendarMainTitle
     */
    public void setCalendarMainTitle(String calendarMainTitle) {
        this.calendarMainTitle = calendarMainTitle;
        return;
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
    }


    @Override
    /**
<<<<<<< HEAD
     * @param calendarMainTitle
     */
    public void setCalendarMainTitle(String calendarMainTitle) {
        this.calendarMainTitle = calendarMainTitle;
        return;
    }


    @Override
    /**
=======
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
     * @return void - check du Composant - à utiliser ??
     */
    public void displayMainPanel() {
        return;
    }

}