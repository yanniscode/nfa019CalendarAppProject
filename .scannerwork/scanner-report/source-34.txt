package fr.cnam.pactivity;

import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class ActivityFormPanel implements ActivityFormPanelInterface {

    /**
     * Default constructor
     */
    public ActivityFormPanel() {
    }

    /**
     * 
     */
    private String activityPanelTitle;

    /**
     * Date de format: dd
     */
    private Date daySelect;

    /**
     * Date de format: MM
     */
    private Date monthSelect;

    /**
     * Date de format: yyyy
     */
    private Date yearSelect;

    /**
     * Date
     */
    private Date newAggregatedDate;

    /**
     * String
     */
    private String newActivityDescription;

    /**
     * String
     */
    private String newActivityStatus;

    /**
     * int - utilisé pour gérer le temps de connexion au formulaire de saisie
     */
    private int timeOut;







    /**
     * @return DatePart
     */
    public DatePart getNewDay() {
        // TODO implement here
        return null;
    }

    /**
     * @param selectedDay 
     * @return void
     */
    public void setNewDay(DatePart selectedDay) {
        // TODO implement here
        return;
    }

    /**
     * @return DatePart
     */
    public DatePart getNewMonth() {
        // TODO implement here
        return null;
    }

    /**
     * @param selectedMonth 
     * @return void
     */
    public void setNewMonth(DatePart selectedMonth) {
        // TODO implement here
        return;
    }

    /**
     * @return DatePart
     */
    public DatePart getNewYear() {
        // TODO implement here
        return null;
    }

    /**
     * @param selectedYear 
     * @return void
     */
    public void setNewYear(Date selectedYear) {
        // TODO implement here
        return;
    }

    /**
     * @return String
     */
    public String getNewActivityDescription() {
        // TODO implement here
        return "";
    }

    /**
     * @param newActivityText 
     * @return void
     */
    public void setNewActivityDescription(String newActivityText) {
        // TODO implement here
        return;
    }

    /**
     * @param selectedStatus 
     * @return void
     */
    public void setNewActivityStatus(String selectedStatus) {
        // TODO implement here
        return;
    }

    /**
     * @return String
     */
    public String getNewActivityStatus() {
        // TODO implement here
        return "";
    }

    /**
     * @param newAggregatedDate 
     * @param newActivityDescription 
     * @param newActivityStatus 
     * @return void
     */
    public void setDateActivityItem(Date newAggregatedDate, String newActivityDescription, String newActivityStatus) {
        // TODO implement here
        return;
    }

    /**
     * @param timeOut 
     * @return void
     */
    public void setTimeOut(int timeOut) {
        // TODO implement here
        return;
    }

    /**
     * @return int - utilisé pour reset du timeout (gestion du temps de connexion au formulaire de saisie
     */
    public int resetTimeOut() {
        // TODO implement here
        return -1;
    }

    @Override
    /**
     * @return void
     */
    public void displayActivityPanel() {
        // TODO implement here
        return;
    }

}