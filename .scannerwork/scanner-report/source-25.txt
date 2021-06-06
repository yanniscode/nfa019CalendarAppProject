package fr.cnam.pactivity;

import fr.cnam.penums.ActivityColor;

import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class DateActivityItem implements DateActivityItemInterface {

    /**
     * Default constructor
     */
    public DateActivityItem() {
    }

    /**
     * 
     */
    private Date aggregatedDate = null;

    /**
     * 
     */
    private String activityDescription = null;

    /**
     * 
     */
    private final String activityStatus = null;

    /**
     * 
     */
    private final ActivityColor activityColor = null;

    /**
     * 
     */
    private DatePart yearSelect = null;

    /**
     * 
     */
    private DatePart monthSelect = null;

    /**
     * 
     */
    private DatePart daySelect = null;






    /**
     * @return
     */
    public Date getAggregatedDate() {
        // TODO implement here
        return null;
    }

    /**
     * @param yearSelect 
     * @param MonthSelect 
     * @param DaySelect 
     * @return
     */
public void setAggregatedDate(DatePart yearSelect, DatePart MonthSelect, DatePart DaySelect) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public DatePart getYearSelect() {
        // TODO implement here
        return null;
    }

    /**
     * @param yearSelect 
     * @return
     */
    public void setYearSelect(DatePart yearSelect) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void getMonthSelect() {
        // TODO implement here
        return;
    }

    /**
     * @param monthSelect 
     * @return
     */
    public void setMonthSelect(DatePart monthSelect) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public DatePart getDaySelect() {
        // TODO implement here
        return null;
    }

    /**
     * @param daySelect 
     * @return
     */
    public void setDaySelect(DatePart daySelect) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public String getActivityDescription() {
        // TODO implement here
        return "";
    }

    /**
     * @param activityDescription 
     * @return
     */
    public void setActivityDescription(String activityDescription) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public String getActivityStatus() {
        // TODO implement here
        return "";
    }

    /**
     * @param activityStatus 
     * @return
     */
    public void setActivityStatus(String activityStatus) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public ActivityColor getActivityColor() {
        // TODO implement here
        return null;
    }

    /**
     * @param activityColor 
     * @return
     */
    public void setActivityColor(ActivityColor activityColor) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void displayActivity() {
        // TODO implement here
        return;
    }

}