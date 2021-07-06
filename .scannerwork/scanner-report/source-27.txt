package fr.cnam.pcalendarpanel;

import fr.cnam.pbuttons.CalendarControlButton;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Yannis Guéguen
 */
public class CalendarHeader implements CalendarHeaderInterface {

    /**
     * Default constructor
     */
    public CalendarHeader() {
        super();
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());

    /**
     * String
     */
    protected String monthName;

    /**
     * Set<String>
     */
    protected Set<String> displayCalendarHeader;


    @Override
    /**
     * @return void
     */
    public void displayCalendarHeader() {
        this.logger.log(Level.INFO, () -> "info (displayCalendarHeader): "+ " - "+ this.monthName +" - "+this.displayCalendarHeader);
    }

}