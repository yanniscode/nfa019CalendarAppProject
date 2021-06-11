package fr.cnam.pactivity;

import fr.cnam.penums.ActivityColor;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class DateActivityItem extends JPanel implements DateActivityItemInterface {


    private DatePart datePart;

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    //        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", dfsFR);
    private String formatedDate;

    private JButton dateItemButton;

    private int dayIndex;

    private Calendar newCalendar;


    /**
     * Constructor 3
     * @param dayIndex
     * @param newCalendar
     */
    public DateActivityItem(int dayIndex, Calendar newCalendar) {

        super();

    }


    /**
     *  Constructor 2
     * @param DateBefore
     */
    public DateActivityItem(Date DateBefore) {

        super();

    }


    /**
     * Default constructor
     */
    public DateActivityItem(int dayIndex) {

        super();

    }



    // ajouts:

    /**
     * Date
     */
    private Date nextDay;


    /**
     * Date - date agrégée
     */
    private Date aggregatedDate = null;

    /**
     * String
     */
    private String activityDescription = null;

    /**
     * String
     */
    private final String activityStatus = null;

    /**
     * ActivityColor
     */
    private final ActivityColor activityColor = null;

    /**
     * DatePart
     */
    private DatePart yearSelect = null;

    /**
     * DatePart
     */
    private DatePart monthSelect = null;

    /**
     * DatePart
     */
    private DatePart daySelect = null;


    /**
     * @return JButton
     */
    public JButton getDateItemButton(){
        return this.dateItemButton;
    };

    public void setDateItemButton(JButton dateItemButton){
        this.dateItemButton = dateItemButton;
        return;
    }




    // **************************************




    /**
     * @return Date
     */
    public Date getAggregatedDate() {
        // TODO implement here
        return null;
    }

    /**
     * @param yearSelect
     * @param MonthSelect
     * @param DaySelect
     * @return void
     */
    public void setAggregatedDate(DatePart yearSelect, DatePart MonthSelect, DatePart DaySelect) {
        // TODO implement here
        return;
    }

    /**
     * @return DatePart
     */
    public DatePart getYearSelect() {
        // TODO implement here
        return null;
    }

    /**
     * @param yearSelect
     * @return void
     */
    public void setYearSelect(DatePart yearSelect) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public DatePart getMonthSelect() {
        // TODO implement here
        return null;
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
     * @return DatePart
     */
    public DatePart getDaySelect() {
        // TODO implement here
        return null;
    }

    /**
     * @param daySelect
     * @return void
     */
    public void setDaySelect(DatePart daySelect) {

        this.daySelect = daySelect;
        // TODO implement here
        return;
    }

    /**
     * @return String
     */
    public String getActivityDescription() {
        // TODO implement here
        return "";
    }

    /**
     * @param activityDescription
     * @return void
     */
    public void setActivityDescription(String activityDescription) {
        // TODO implement here
        return;
    }

    /**
     * @return String
     */
    public String getActivityStatus() {
        // TODO implement here
        return "";
    }

    /**
     * @param activityStatus
     * @return void
     */
    public void setActivityStatus(String activityStatus) {
        // TODO implement here
        return;
    }

    /**
     * @return ActivityColor
     */
    public ActivityColor getActivityColor() {
        // TODO implement here
        return null;
    }

    /**
     * @param activityColor
     * @return void
     */
    public void setActivityColor(ActivityColor activityColor) {
        // TODO implement here
        return;
    }

    @Override
    /**
     * @return void
     */
    public void displayActivity() {
        // TODO implement here
        return;
    }

}