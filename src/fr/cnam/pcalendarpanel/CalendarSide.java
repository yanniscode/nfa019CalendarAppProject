package fr.cnam.pcalendarpanel;

import fr.cnam.pactivity.ActivityFormFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yannis Guéguen
 */
public class CalendarSide implements CalendarSideInterface {


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * Default constructor
     */
    public CalendarSide() {
        super();
    }

    /**
     * int
     */
    protected int weekYearNumber;



    @Override
    /**
     * @return void
     */
    public void displayCalendarSide() {
        this.logger.log(Level.INFO, () -> "info (displayCalendarSide): "+ this.weekYearNumber);
    }

}