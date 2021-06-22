package fr.cnam.pcalendarpanel;

import fr.cnam.pdatabase.managment.dao.DateActivityDAO;
import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.penums.ActivityColor;
import fr.cnam.putils.ReformatDate;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.Calendar;


/**
 * @author Yannis Guéguen
 */
public class DateButton extends JPanel implements DateButtonInterface {


    /**
     * constructor 2: pour création des boutons des pages précédentes ou suivantes (par le param Date = du mois précédent ou suivant)
     * @param monthIndex, dayIndex, connection
     */
    public DateButton(int monthIndex, int dayIndex, Connection connection) throws ClassNotFoundException, SQLException {

        super();

        this.activityColor = new ActivityColor();

        this.datePart = new DatePart();

        this.dateValue = this.datePart.getByFirstMondayOfMonthPage(monthIndex, dayIndex);    // idMonth = 0 (mois actuel pour l'initialisation du calendrier)
        this.datePart.setDateValue(this.dateValue);

//        System.out.println("i i i i"+ dayIndex);
//        System.out.println("day ++" + DateBefore);

        // *** conversion de la date (String) au format "dd/MM/yyyy"
        ReformatDate reformatDate = new ReformatDate();
        this.formatedDate = reformatDate.formatDateToString(this.dateValue);

        this.dateButton = new JButton(this.formatedDate);

        // *** si le bouton ne correspond pas au mois de la page, il est désactivé
        this.setButtonToGray(this.datePart, monthIndex);  // 0 = today

        //  *** get Date (DAO)

        // *** update des boutons ayant une activité déjà enregistré avant l'affichage de la page
        this.dateButton = this.getActivityDatas(connection, monthIndex, dayIndex);

        this.dateButton.setPreferredSize(new Dimension(120, 100));

        this.add(this.dateButton);
    }


    /**
     * Constructor 1: pour création des boutons de base (date = actuelle)
     * @param dayIndex, connection
     */
    public DateButton(int dayIndex, Connection connection) throws ClassNotFoundException, SQLException {

        super();

        this.activityColor = new ActivityColor();


        // ********************* GET DATE D'UN JOUR DU MOIS ACTUEL SANS DAO:

        // *** ref de jour, ici = dans le mois actuel:
        this.datePart = new DatePart();

        this.dateValue = this.datePart.getByFirstMondayOfMonthPage(0, dayIndex);    // *** idMonth = 0 (= mois actuel pour l'initialisation du calendrier)
//        System.out.println("~~~~~~~~~~~~ ##################################  " + this.dateValue);
        this.datePart.setDateValue(this.dateValue);

        // *** TEST DATE LONG
//        long converDateToLong = this.dateValue.getTime();
//        System.out.println("Converted Date du jour to Long : "+ converDateToLong); // 1622449832100L
//        java.sql.Date ConvertedDateJour = new java.sql.Date(converDateToLong);
//        System.out.println("Converted Date du jour from Long : "+ ConvertedDateJour);   // date actuelle - ex: '2021-05-31' = premier jour de la page de juin


        // *** récupération de la date (String) au format "dd/MM/yyyy"
        ReformatDate reformatDate = new ReformatDate();
        this.formatedDate = reformatDate.formatDateToString(this.dateValue);

        this.dateButton = new JButton(this.formatedDate);

        this.setButtonToGray(this.datePart, 0);  // 0 = today


        //  *** get Date (DAO)

        // *** update des boutons ayant une activité déjà enregistré avant l'affichage de la page
        this.dateButton = this.getActivityDatas(connection, 0, dayIndex);

        this.dateButton.setPreferredSize(new Dimension(120, 100));

        this.add(this.dateButton);
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


    // *******************

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
    private final ActivityColor activityColor;

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


    // **************

    /**
     *
     * @return JButton
     */
    public JButton getDateButton() {
        return this.dateButton;
    }


    public JButton getActivityDatas(Connection connection, int indexMonth, int dayIndex) {

        this.dateValue = this.datePart.getByFirstMondayOfMonthPage(indexMonth, dayIndex);


        System.out.println(connection);
        DatePart searchDatePart = new DatePart();
        DateActivityDAO dateActivityDAO = new DateActivityDAO(connection);

//        DateActivityItem insertDateActivityItem = new DateActivityItem(searchDatePart);
//        if(dateActivityDAO.create(insertDateActivityItem)) {
//            System.out.println("insert dateActivityItem success");
//        }

        DateActivityItem dateActivityItem;

//        System.out.println("this.dateValue = "+ this.dateValue);
//        System.out.println("######### ACTIVITY DAO: "+ dateActivityDAO);
        dateActivityItem = dateActivityDAO.findByDate(this.dateValue, connection);   // REMPLACER L'INDEX PAR: RECHERCHE PAR DATE -> CRÉER: findByDate() dans DateActivityDAO
//        dateActivityItem = dateActivityDAO.find(150);   // REMPLACER L'INDEX PAR: RECHERCHE PAR DATE -> CRÉER: findByDate() dans DateActivityDAO
//        System.out.println(dateActivityItem);

        Long resLongDateFromBdd = dateActivityItem.getDatePart().getDatePartValue();
//        System.out.println("###### bdd date = " + resLongDateFromBdd); // date: format long - ex: 11111111111L


        // *** si la bdd envoie une dateActivityItem correspondante au jour passé, ET si le bouton est actif (correspond bien au mois affiché)
        if(resLongDateFromBdd != null && !this.dateButton.getBackground().toString().equals("java.awt.Color[r=192,g=192,b=192]")) {
//        if (resLongDateFromBdd != null) {

//            System.out.println("STATUS ~~~~~~~~~~~~~~~~~~~~~~~~~~~ = " + dateActivityItem.getDateActivityStatus());

            java.sql.Date ConvertedDateFromBDD = new java.sql.Date(resLongDateFromBdd);

            searchDatePart.setDateValue(ConvertedDateFromBDD);

            // *** conversion de la date (String) au format "dd/MM/yyyy"
            ReformatDate reformatDate = new ReformatDate();
            this.formatedDate = reformatDate.formatDateToString(ConvertedDateFromBDD);
//            System.out.println("~~~~~~~~~~~~ ##################################" + this.formatedDate);

            String activityDescription = dateActivityItem.getDateActivityDescription();
//            String activityStatus = dateActivityItem.getDateActivityStatus();

            StringBuilder newActivityButtonData = new StringBuilder();
            newActivityButtonData.append(activityDescription);
//            newActivityButtonData.append(activityStatus +" ** "+ this.formatedDate +" ** "+ activityDescription);

            this.dateButton = new JButton(String.valueOf(newActivityButtonData));

            if (dateActivityItem.getDateActivityStatus().equals("\"En définition\"")) {
                this.dateButton.setBackground(this.activityColor.ORANGE);
            } else if (dateActivityItem.getDateActivityStatus().equals("\"En cours\"")) {
                this.dateButton.setBackground(this.activityColor.BLUE);
            } else if (dateActivityItem.getDateActivityStatus().equals("\"En test\"")) {
                this.dateButton.setBackground(this.activityColor.RED);
            } else if (dateActivityItem.getDateActivityStatus().equals("\"Terminée\"")) {
                this.dateButton.setBackground(this.activityColor.GREEN);
            }

        }

        return this.dateButton;
    }

    // **************

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

//        System.out.println(newFirstDay);
        this.datePart = newFirstDay;
//        this.datePart = new DatePart();

//        System.out.println(newFirstDay.getDateValue());
        Date newFirstDayTemp = newFirstDay.getDateValue();

//        System.out.println("{{{{{{{{{{{{{{{{{{ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ newFirstDayTemp);
        Date dateToCompare = this.datePart.getOneMonthInterval(monthIndex);
//        System.out.println("{{{{{{{{{{{{{{{{{{ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ dateToCompare);

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