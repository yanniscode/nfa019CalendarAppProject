package fr.cnam.pdatabase.managment.model;

import fr.cnam.pactivity.ActivityFormFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateActivityItem implements DateActivityItemInterface {


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * String
     */
    private String datePartDescription;

    /**
     * String
     */
    private String datePartStatus;

    /**
     * DatePart
     */
    private DatePart datePart;


    /**
     *  constructor 2
     */
    public DateActivityItem(DatePart datePart) {
        super();
        this.datePart = datePart;
    }

    /**
     * Default constructor
     */
    public DateActivityItem() {
        super();
    }


    /**
     * @return DatePart
     */
    public DatePart getDatePart() {
        return this.datePart;
    }

    /**
     * @param datePart
     * @return void
     */
    public void setDatePart(DatePart datePart) {
        this.datePart = datePart;
    }

    /**
     * @return String
     */
    public String getDateActivityDescription() {
        return this.datePartDescription;
    }

    /**
     * @param datePartDescription
     * @return void
     */
    public void setDateActivityDescription(String datePartDescription) {
        this.datePartDescription = datePartDescription;
    }

    /**
     * @return String
     */
    public String getDateActivityStatus() {
        return this.datePartStatus;
    }

    /**
     * @param datePartStatus
     * @return void
     */
    public void setDateActivityStatus(String datePartStatus) {
        this.datePartStatus = datePartStatus;
    }


    @Override
    public void displayActivity() {
        this.logger.log(Level.INFO, () -> "info (displayActivity): "+ this.getDatePart().getDateValue()+" - "+ this.datePartDescription +" - "+ this.datePartStatus);
    }

}
