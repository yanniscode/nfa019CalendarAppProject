package fr.cnam.pcalendarpanel;

import fr.cnam.pactivity.DatePart;
import fr.cnam.pcalendarpanel.DateButtonInterface;
import fr.cnam.penums.ActivityColor;
import fr.cnam.putils.ReformatDate;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class DateButton extends JPanel implements DateButtonInterface {

    /**
     * constructor 2: pour création des boutons des pages précédentes ou suivantes (par le param Date = du mois précédent ou suivant)
     * @param newDate
     */
    public DateButton(Date newDate) {

        super();

//        this.datePart = new DatePart();

//        System.out.println("i i i i"+ dayIndex);
//        System.out.println("day ++" + DateBefore);

        // *** récupération de la date (String) au format "dd/MM/yyyy"
        ReformatDate reformatDate = new ReformatDate();
        this.formatedDate = reformatDate.formatDateToString(newDate);

        this.dateButton = new JButton(this.formatedDate);
//
        this.dateButton.setPreferredSize(new Dimension(120, 100));

        this.add(this.dateButton);
    }


    /**
     * Constructor 1: pour création des boutons de base (date = actuelle)
     * @param dayIndex
     */
    public DateButton(int dayIndex) {

        super();

        // *** ref de jour, ici = dans le mois actuel:
        this.datePart = new DatePart();

        this.dateValue = this.datePart.getIndexedDay(dayIndex);
        System.out.println("~~~~~~~~~~~~ ##################################" + this.dateValue);
        this.datePart.setDateValue(this.dateValue);


        // *** récupération de la date (String) au format "dd/MM/yyyy"
        ReformatDate reformatDate = new ReformatDate();
        this.formatedDate = reformatDate.formatDateToString(this.dateValue);

        this.dateButton = new JButton(this.formatedDate);

        this.dateButton.setPreferredSize(new Dimension(120, 100));

        this.setButtonToGray(this.datePart, 0);  // 0 = today

        super.add(this.dateButton);

    }

    // AJOUTS:

    /**
     * DatePart - date considérée (au sens générique)
     */
    private DatePart datePart;

    /**
     * Date - nouvelle date sélectionnée
     */
    private Date dateValue;


    /**
     * @return Date
     */
    public Date getDateValue() {
        return this.dateValue;
    }

    /**
     * @param dateValue
     * return void
     */
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
        return;
    }


    /**
     * DateFormat - pour le formatage d"une date
     */
    private DateFormat dateFormat;

    //        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", dfsFR);

    /**
     * String - date formatée
     */
    private String formatedDate;

    /**
     * JButton - bouton de date
     */
    private JButton dateButton;

    /**
     * Calendar - nouveau calendrier pour mise à jour selon le mois considéré
     */
    private Calendar newCalendar;




    // ***********************
    /**
     * Date - date agrégée (lors de création d'un formulaire avec des éléments d'une date séparé - Jour - Mois -Année)
     */
    private Date aggregatedDate = null;

    /**
     * String - description de l'activité saisie dans le formulaire
     */
    private String activityDescription = null;

    /**
     * String - (enum) status d'une activité selectionné dans le formulaire
     */
    private final String activityStatus = null;

    /**
     * ActivityColor - (enum) couleur du DateButton (selon le status de l'activité: à faire, en cours, en test, réalisée)
     */
    private final ActivityColor activityColor = null;

    /**
     * DatePart - partie Année d'une date
     */
    private DatePart yearSelect = null;

    /**
     * DatePart - partie Mois d'une date
     */
    private DatePart monthSelect = null;

    /**
     * DatePart - partie jour d"une date
     */
    private DatePart daySelect = null;

    /**
     *
     * @return JButton
     */
    public JButton getDateButton() {
        return this.dateButton;
    }



    /**
     *
     *      * @param dateButton
     *      return void
     */
    public void setDateButton(JButton dateButton) {
        this.dateButton = dateButton;
        return;
    }


    /**
     *
     * passe le bouton au status inactif (s'il ne correspond pas au mois de la page affichée)
     * @param newFirstDay
     * @param monthIndex
     */
    public void setButtonToGray(DatePart newFirstDay, int monthIndex) {
        this.datePart = newFirstDay;
//        this.datePart = new DatePart();

        System.out.println(newFirstDay.getDateValue());
        Date newFirstDayTemp = newFirstDay.getDateValue();

        System.out.println("{{{{{{{{{{{{{{{{{{ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ newFirstDayTemp);
        Date dateToCompare = this.datePart.getOneMonthInterval(monthIndex);
        System.out.println("{{{{{{{{{{{{{{{{{{ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ dateToCompare);

        ReformatDate reformatDate = new ReformatDate();
        String formatedReferenceDate = reformatDate.formatMonthToString(dateToCompare);
        String formatedSelectedDate = reformatDate.formatMonthToString(newFirstDayTemp);

//        System.out.println(formatedReferenceDate +" ------------- "+ formatedSelectedDate);
        if(!formatedReferenceDate.equals(formatedSelectedDate)) {
            this.dateButton.setBackground(Color.LIGHT_GRAY);
            this.dateButton.setEnabled(false);
        }
        return;
    }



    // **********


    /**
     * @return Date
     */
    public Date getAggregatedDate() {
        return this.aggregatedDate;
    }


//    /**
//     * @return
//     */
//    public void setAggregatedDate(int dayIndex) {
//
//        this.nextDay = this.datePart.getIndexedDay(dayIndex);
//
//        System.out.println("day ++" + this.nextDay);
//
//        this.formatedDate = this.dateFormat.format(this.nextDay);
//
//        this.dateButton = new JButton(this.formatedDate);
//
//        this.dateButton.setPreferredSize(new Dimension(120, 100));
//
//        super.add(this.dateButton);
//
//        return;
//    }

    /**
     * définit une date agrégée (avec le formulaire - Jour, Mois, Année dans des champs séparés)
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
        return this.yearSelect;
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
     * @return DatePart
     */
    public DatePart getMonthSelect() {
        return this.monthSelect;
    }

    /**
     * @param monthSelect
     * @return void
     */
    public void setMonthSelect(DatePart monthSelect) {
        // TODO implement here
        return;
    }

    /**
     * @return DatePart
     */
    public DatePart getDaySelect() {
        return this.daySelect;
    }


    /**
     * @param daySelect
     * @return void
     */
    public void setDaySelect(DatePart daySelect) {
        this.daySelect = daySelect;
        return;
    }



    /**
     * @return Calendar
     */
    public Calendar getNewCalendar() {
        return this.newCalendar;
    }

    /**
     * @param newCalendar
     * @return void
     */
    public void setNewCalendar(Calendar newCalendar) {
        this.newCalendar = newCalendar;
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

    /**
     * @return void
     */
    public void displayActivity() {
        // TODO implement here
        return;
    }


    @Override
    /**
     * @return void
     */
    public void displayDateButton() {
        // TODO implement here
        return;
    }

}