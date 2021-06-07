package fr.cnam.pcalendarpanel;

import fr.cnam.pactivity.DateActivityItem;
import fr.cnam.pbuttons.ControlButton;

import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class CalendarPanel implements CalendarPanelInterface {

    /**
     * Default constructor
     */
    public CalendarPanel() {
    }

    /**
     * 
     */
    private Set<DateActivityItem> yearList;

    /**
     * 
     */
    private Set<DateActivityItem> monthList;

    /**
     * 
     */
    private Set<DateActivityItem> daysList;



    /**
     * @return
     */
    public Set<DateActivityItem> getLastMonth() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<DateActivityItem> getNextMonth() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<DateActivityItem> getDaysList() {
        // TODO implement here
        return null;
    }

    /**
     * @param controlBtn 
     * @return
     */
    public void setDaysList(ControlButton controlBtn) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void displayCalendar() {
        // TODO implement here
        return;
    }

}