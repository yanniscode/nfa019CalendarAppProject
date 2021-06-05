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
     * 
     */
    private Date newAggregatedDate;

    /**
     * 
     */
    private String newActivityDescription;

    /**
     * 
     */
    private String newActivityStatus;

    /**
     * 
     */
    private int timeOut;







    /**
     * @return
     */
    public Date getNewDay() {
        // TODO implement here
        return null;
    }

    /**
     * @param selectedDay 
     * @return
     */
    public void setNewDay(Date selectedDay) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public Date getNewMonth() {
        // TODO implement here
        return null;
    }

    /**
     * @param selectedMonth 
     * @return
     */
    public void setNewMonth(Date selectedMonth) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public Date getNewYear() {
        // TODO implement here
        return null;
    }

    /**
     * @param selectedYear 
     * @return
     */
    public void setNewYear(Date selectedYear) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public String getNewActivityDescription() {
        // TODO implement here
        return "";
    }

    /**
     * @param newActivityText 
     * @return
     */
    public void setNewActivityDescription(String newActivityText) {
        // TODO implement here
        return;
    }

    /**
     * @param selectedStatus 
     * @return
     */
    public void setNewActivityStatus(String selectedStatus) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public String getNewActivityStatus() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public DateActivityItem getDateActivityItem() {
        // TODO implement here
        return null;
    }

    /**
     * @param newAggregatedDate 
     * @param newActivityDescription 
     * @param newActivityStatus 
     * @return
     */
    public void setDateActivityItem(Date newAggregatedDate, String newActivityDescription, String newActivityStatus) {
        // TODO implement here
        return;
    }

    /**
     * @param timeOut 
     * @return
     */
    public void setTimeOut(int timeOut) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public int resetTimeOut() {
        // TODO implement here
        return -1;
    }

    /**
     * @return
     */
    public void displayActivityPanel() {
        // TODO implement here
        return;
    }

}