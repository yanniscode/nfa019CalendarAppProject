package fr.cnam.pactivity;

import fr.cnam.penums.ActivityColor;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class DateActivityItem extends JPanel implements DateActivityItemInterface {


    DatePart datePart;

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    //        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", dfsFR);
    String formatedDate;

    JButton dateItemButton;


    /**
     * Default constructor
     */
    public DateActivityItem() {

        super();

//        dateItemButton = new JButton();
//        super.add(dateItemButton);

        datePart = new DatePart();


//        System.out.println("~~~~ "+datePart.getFirstMonday(2021, Calendar.JANUARY));

        // changement de mois: test PREMIER LUNDI DE LA PAGE DU CALENDAR:
//        System.out.println("+++ "+ datePart.getFirstMondayOfNextMonthPage());
//        System.out.println("~~~~ "+datePart.getFirstMondayOfActualMonthPage());
//        System.out.println("--- "+ datePart.getFirstMondayOfLastMonthPage());


//        datePart.resetDaysIndex();  // reset incr (day)

//        Date nextDay;
////        Date nextDay = datePart.getNextDay();
////        System.out.println("day ++"+ nextDay);
//
//        nextDay = datePart.getIndexedDay();

//        for(int i = 1; i < 35; i ++){
//            System.out.println("i: "+ i);
//            nextDay = datePart.getIndexedDay();
//            System.out.println("day ++"+ nextDay);
//
//        }

                // ***************
//        Date daySelectTest;

//        daySelectTest = datePart.getFirstMondayOfActualMonthPage();
//        System.out.println("~~ "+daySelectTest);
//
//        daySelectTest = datePart.getFirstMondayOfNextMonthPage();
//        System.out.println("~~~~ "+daySelectTest);

//        daySelectTest = datePart.getFirstMondayOfLastMonthPage();
//        System.out.println("~~ "+daySelectTest);

//        daySelectTest = datePart.getFirstMondayOfLastMonthPage();
//        System.out.println("~~ "+daySelectTest);
//
//        daySelectTest = datePart.getFirstMondayOfLastMonthPage();
//        System.out.println("~~ "+daySelectTest);

//        daySelectTest = datePart.getFirstMondayOfLastMonthPage();
//        System.out.println("~~ "+daySelectTest);
//////
//        daySelectTest = datePart.getFirstMondayOfNextMonthPage();
//        System.out.println("~~ "+daySelectTest);
//
//        daySelectTest = datePart.getFirstMondayOfActualMonthPage();
//        System.out.println("~~ "+daySelectTest);

//
//////
//        daySelectTest = datePart.getFirstMondayOfNextMonthPage();
//        System.out.println("~~ "+daySelectTest);
////
//        daySelectTest = datePart.getFirstMondayOfNextMonthPage();
//        System.out.println("~~ "+daySelectTest);
//
//        daySelectTest = datePart.getFirstMondayOfNextMonthPage();
//        System.out.println("~~ "+daySelectTest);

//
//        daySelectTest = datePart.getFirstMondayOfNextMonthPage();
//        System.out.println("~~ "+daySelectTest);

//        System.out.println("~~~~ "+datePart.getFirstDayOfMonth());

//        super.setSize(150,50);


        // pour obtenir une date type mois: 'Juin' (String à partir de Date)
//        System.out.println(daySelectTest);

//        DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);



//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
////        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", dfsFR);
//        String formatedDate;
//
//        JButton dateItemButton;


////        for(int i = 1; i < 35; i ++) {
////            System.out.println("i: "+ i);
////            nextDay = datePart.getIndexedDay();
//            System.out.println("day ++"+ nextDay);
////
//            formatedDate = dateFormat.format(nextDay);
//
//            dateItemButton = new JButton(formatedDate);
//
////            super.add(dateItemButton);
//            dateItemButton.setPreferredSize(new Dimension(120,100));
////        }

//        super.add(dateItemButton);

//        dateItemButton.setPreferredSize(new Dimension(120,100));
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


    // AJOUT:

            Date nextDay;

    /**
     *
     * @return
     */
    public void setAggregatedDate(int dayIndex) {

        this.nextDay = this.datePart.getIndexedDay(dayIndex);

//        Date daySelectTest;
//        daySelectTest = datePart.getFirstMondayOfActualMonthPage();

        System.out.println("day ++"+ this.nextDay);

        this.formatedDate = this.dateFormat.format(this.nextDay);

        this.dateItemButton = new JButton(this.formatedDate);

        this.dateItemButton.setPreferredSize(new Dimension(120,100));

        super.add(this.dateItemButton);

        return;
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