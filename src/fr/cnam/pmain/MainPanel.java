package fr.cnam.pmain;

import fr.cnam.pbuttons.ControlButtonsPanel;
import fr.cnam.pcalendarpanel.CalendarPanel;

import javax.swing.*;
import java.awt.*;

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

        FlowLayout glMain = new FlowLayout(CENTER, 1000, 100);
        setLayout(glMain);

        this.calendarMainTitle = "Le Calendrier des lunaires\n";

        JLabel mainLabel = new JLabel(calendarMainTitle);
        mainLabel.setFont(new Font("Serif", 0, 20));
        add(mainLabel);

        CalendarPanel calendarPanel = new CalendarPanel();

        setSize(1600, 900  );
        add(calendarPanel);
//        calendarPanel.setSize(200, 300);
//        calendarPanel.setVisible(true);

    }


    private Container calendarContainer;

    /**
     * 
     */
    private String calendarMainTitle;

    /**
     * 
     */
    private CalendarPanel calendarPanel;

    /**
     * 
     */
    private ControlButtonsPanel controlBtnPanel;




    /**
     * @return
     */
    public ControlButtonsPanel getControlBtnPanel() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public CalendarPanel getCalendarPanel() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
//    public void setCalendarPanel(CalendarPanel calendarPanel) {
//
//        Container calendarContainer = new Container();
//        add(calendarPanel);
//
//        // TODO implement here
//        return;
//    }

    /**
     * @return
     */
    public String getCalendarMainTitle() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public void displayMainPanel() {
        // TODO implement here
        return;
    }

}